package LLD.Messaging.services;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import LLD.Messaging.enums.MessageStatus;
import LLD.Messaging.model.Message;
import LLD.Messaging.repository.MessageRepository;

public class MessageService {
    
    private final AtomicLong messageIdGenerator = new AtomicLong(0);
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message  createMessage(String senderId,String conversationId, String content,long sequenceNumber) {
        Message message = new Message();
        message.setMessageId(messageIdGenerator.incrementAndGet());
        message.setSenderId(senderId); // This should be set to the actual sender's user ID
        message.setConversationId(conversationId);
        message.setContent(content);
        message.setMessageStatus(MessageStatus.SENT);
        message.setTimestamp(System.currentTimeMillis());
        message.setSequenceNumber(sequenceNumber);
        messageRepository.saveMessage(message); 
        return message;
    }

    void markAsRead(Long messageId){
        // Logic to find the message by messageId and update its status to READ
        Message message = messageRepository.findMessageById(messageId);
        message.markAsRead();
    }

    


}
