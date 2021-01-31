package estg.mtsd.bikeshare.dummy.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import estg.mtsd.bikeshare.dummy.service.data.docks;
import estg.mtsd.bikeshare.dummy.service.producers.DockClosedEventProducer;
import estg.mtsd.bikeshare.shared.library.vo.DockClosedEvent;
import estg.mtsd.bikeshare.shared.library.vo.OpenDockEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DummyWebController {

	@Autowired
	DockClosedEventProducer dockClosedEventProducer;
	
	@GetMapping("/dummy")
	public String loadBikes(Model model) {

		synchronized(docks.myDockList) {
			model.addAttribute("bikes", docks.myDockList);
			model.addAttribute("form", new OpenDockEvent());
		}
		
		return "dummy";
	}

	@PostMapping("/dummy")
	public String closeBike(@ModelAttribute("form") OpenDockEvent bike) {

		dockClosedEventProducer.send(new DockClosedEvent(bike.getBikeId(), bike.getDockId()));
		
		synchronized(docks.myDockList) {

			OpenDockEvent myOpenDockEventToRemove = null;
			for (OpenDockEvent myOpenDockEvent : docks.myDockList) {
				
				if (myOpenDockEvent.getBikeId() == bike.getBikeId()) {
					
					myOpenDockEventToRemove = myOpenDockEvent;
					break;
				}
			}

			docks.myDockList.remove(myOpenDockEventToRemove);
		}

		log.info("Closing bike: " + bike.getBikeId() + " in dock id: " + bike.getDockId());

		return "redirect:/dummy";
	}
}