package estg.mtsd.bikeshare.dummy.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		}
		
		return "dummy";
	}

	@RequestMapping("/dummy")
	public String closeBike(@RequestParam(value = "close", required = false) OpenDockEvent close, Model model) {

		synchronized(docks.myDockList) {

			dockClosedEventProducer.send(new DockClosedEvent(close.getBikeId(), close.getDockId()));

			docks.myDockList.remove(close);
        }
		
		log.info("Closing dock: " + close.getDockId());

		return "redirect:/dummy";
	}
}