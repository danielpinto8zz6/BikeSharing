package estg.mtsd.bikeshare.notifications.service.controllers;

import com.google.firebase.messaging.FirebaseMessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import estg.mtsd.bikeshare.notifications.service.service.FirebaseMessagingService;
import estg.mtsd.bikeshare.notifications.service.service.TokenService;
import estg.mtsd.bikeshare.shared.library.utils.JwtUtils;
import estg.mtsd.bikeshare.shared.library.vo.NotificationVo;

@Controller
public class NotificationController {

    private final FirebaseMessagingService firebaseService;

    @Autowired
    TokenService tokenService;

    public NotificationController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody NotificationVo notificationVo) throws FirebaseMessagingException {

        String token = tokenService.findById(notificationVo.getEmail());

        return firebaseService.sendNotification(notificationVo, token);
    }
}
