package estg.mtsd.bikeshare.dummy.service.controller;

import estg.mtsd.bikeshare.dummy.service.producers.DockClosedEventProducer;
import estg.mtsd.bikeshare.shared.library.vo.DockClosedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @Autowired
    DockClosedEventProducer dockClosedEventProducer;

    @PostMapping("bike")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void insertBike(@RequestBody DockClosedEvent dockClosedEvent) throws Exception {
        dockClosedEventProducer.send(dockClosedEvent);
    }
}
