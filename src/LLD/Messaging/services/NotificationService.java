package LLD.Messaging.services;

import java.util.concurrent.atomic.AtomicLong;

import javax.management.Notification;

import LLD.Messaging.enums.NotificationStatus;
import LLD.Messaging.model.Conversation;
import LLD.Messaging.strategy.NotificationFactory;
import LLD.Messaging.strategy.NotificationStrategy;

public class NotificationService {
    private final NotificationStrategy notificationStrategy;

    private final AtomicLong notificationIdGenerator;

    public NotificationService(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
        this.notificationIdGenerator = new AtomicLong(0);
    }

    public void sendNotification(String userId, String message) {
        String notificationId = "notif_" + notificationIdGenerator.incrementAndGet();
        Notification notification = new Notification();
        notification.setNotificationId(notificationId);
        notification.setRecipientId(userId);
        notification.setMessage(message);
        NotificationStrategy strategy =
                NotificationFactory.getNotificationStrategy(
                        user.getNotificationType()
                );
        notificationStrategy.sendNotification(notification);
         notification.setNotificationStatus(
                NotificationStatus.SENT
        );
    }

    private Notification createNotification(
            String receiverId,
            String messageContent
    ) {

        Notification notification =
                new Notification();

        notification.setNotificationId(
                notificationIdGenerator
                        .incrementAndGet()
        );

        notification.setReceiverId(
                receiverId
        );

        notification.setMessage(
                messageContent
        );

        notification.setNotificationStatus(
                NotificationStatus.PENDING
        );

        return notification;
    }

    public void notifyParticipants(Conversation conversation,
            String senderId,
            String messageContent
    ) {
        for (String participantId : conversation.getUserId()) {
            if (!participantId.equals(senderId)) {
                sendNotification(participantId, messageContent);
            }
        }
    }
}
