package estg.mtsd.bikeshare.dummy.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import estg.mtsd.bikeshare.dummy.service.data.docks;
import estg.mtsd.bikeshare.dummy.service.producers.DockClosedEventProducer;
import estg.mtsd.bikeshare.shared.library.vo.DockClosedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DummyWebController {

	@Autowired
	DockClosedEventProducer dockClosedEventProducer;
	
	@GetMapping("/dummy")
	public String loadBikes(Model model) {

		synchronized(docks.myDockList) {
			model.addAttribute("form", docks.myDockList);
		}
		
		return "dummy";
	}

	@GetMapping("/dummy/close/dock/{dockId}/bike/{bikeId}")
	public String closeBike(@PathVariable("dockId") int dockId, @PathVariable("bikeId") int bikeId, Model model) {

		dockClosedEventProducer.send(new DockClosedEvent(bikeId, dockId));
		
		log.info("Closing bike: " + bikeId);

		return "redirect:/dummy";
	}
}