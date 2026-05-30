package LLD.Messaging.model;
import LLD.Messaging.enums.MessageStatus;

public class Message {
    Long messageId;
    String content;
    String senderId;
    //String receiverId; -  because if it's a grp conversation, there can be multiple receivers. So we can maintain a list of receiverIds in Conversation class.
    String conversationId;
    long sequenceNumber;
    MessageStatus messageStatus;
    long timestamp;
    
    public Long getMessageId() {
        return messageId;
    }
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSenderId() {
        return senderId;
    }
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    public String getConversationId() {
        return conversationId;
    }
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
    public MessageStatus getMessageStatus() {
        return messageStatus;
    }
    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void markAsRead() {
        this.messageStatus = MessageStatus.READ;
    }
    
}
