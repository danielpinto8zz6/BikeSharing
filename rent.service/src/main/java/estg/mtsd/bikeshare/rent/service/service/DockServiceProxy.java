package estg.mtsd.bikeshare.rent.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dock-service")
public interface DockServiceProxy {
	
	 @RequestMapping("/dock/hasBike")
	 public boolean dockHasBike(@RequestParam("dockId") Integer dockId, @RequestParam("bikeId") Integer bikeId);

}
