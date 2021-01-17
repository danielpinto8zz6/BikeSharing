package estg.mtsd.bikeshare.notifications.service.controllers;

import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import estg.mtsd.bikeshare.notifications.service.service.FirebaseMessagingService;
import estg.mtsd.bikeshare.shared.library.vo.NotificationVo;

@Controller
public class NotificationController {

    private final FirebaseMessagingService firebaseService;

    public NotificationController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody NotificationVo notification) throws FirebaseMessagingException {
        return firebaseService.sendNotification(notification);
    }
}
