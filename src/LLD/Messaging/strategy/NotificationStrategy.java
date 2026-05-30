package LLD.Messaging.strategy;

import javax.management.Notification;

public interface NotificationStrategy {
    void sendNotification(Notification notification);
}
