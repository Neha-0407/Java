package LLD.Messaging.strategy;

public class NotificationFactory {
    public static NotificationStrategy getNotificationStrategy(String type) {
        switch(type.toLowerCase()){
            case "email":
                return new EmailNotificationStrategy();
            case "sms":
                return new SMSNotificationStrategy();
            case "push":
                return new PushNotificationStrategy();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
        
    }
}
