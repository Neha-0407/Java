package LLD.Messaging.model;

public class Notification {
    private  String notificationId;
    private String messageId;
    private String recipientId;
    public String getRecipientId() {
        return recipientId;
    }
    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }
    public String getNotificationId() {
        return notificationId;
    }
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    
}
