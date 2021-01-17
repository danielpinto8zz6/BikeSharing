package estg.mtsd.bikeshare.notifications.service.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.reflect.TypeToken;
import estg.mtsd.bikeshare.notifications.service.vo.NotificationVo;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Map;

@Service
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


    public String sendNotification(NotificationVo notificationVo, String token) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(notificationVo.getTitle())
                .setBody(notificationVo.getBody())
                .build();

        Message.Builder messageBuilder = Message
                .builder()
                .setToken(token)
                .setNotification(notification);

        if (notificationVo.getPaymentVo() != null) {
            String json = JsonUtils.toJson(notificationVo.getPaymentVo());
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            Map<String, String> map = JsonUtils.fromJson(json, type);

            messageBuilder.putAllData(map);
        }

        return firebaseMessaging.send(messageBuilder.build());
    }
}
