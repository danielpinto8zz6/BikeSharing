package estg.mtsd.bikeshare.travel.history.receiver.service.controller;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;
import estg.mtsd.bikeshare.travel.history.receiver.service.service.TravelEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TravelEventController {

    @Autowired
    TravelEventService travelEventService;

    @PostMapping("travel")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(TravelEventVo travelEventVo) {
        travelEventService.save(travelEventVo);
    }

    @GetMapping("travel")
    public List<TravelEventVo> getAll() {
        return travelEventService.getAll();
    }
}
