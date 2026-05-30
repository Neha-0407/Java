package LLD.Messaging.strategy;

import javax.management.Notification;

public class SMSNotificationStrategy implements NotificationStrategy {
    
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Sending SMS to user: " + notification.getUserId() + " with message: " + notification.getMessage());
    }
    
}
