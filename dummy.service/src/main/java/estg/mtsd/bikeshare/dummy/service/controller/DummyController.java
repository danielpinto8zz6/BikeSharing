package estg.mtsd.bikeshare.dummy.service.controller;

import estg.mtsd.bikeshare.dummy.service.producers.DockEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import estg.mtsd.bikeshare.shared.library.vo.DockEvent;

@RestController
public class DummyController {

    @Autowired
    DockEventProducer dockEventProducer;

    @PostMapping("bike")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void rent(@RequestBody DockEvent dockEvent) throws Exception {
        dockEventProducer.send(dockEvent);
    }
}
