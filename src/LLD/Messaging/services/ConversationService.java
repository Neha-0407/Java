package LLD.Messaging.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import LLD.Messaging.model.Conversation;
import LLD.Messaging.model.Message;
import LLD.Messaging.repository.ConversationRepository;

public class ConversationService {
    private final AtomicLong conversationIdGenerator = new AtomicLong(0);
    private final ConversationRepository conversationRepository;
    public ConversationService( ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }
    Conversation createConverSation(List<String> participantIds){
        String conversationId = "conv_" + conversationIdGenerator.incrementAndGet();
        Conversation conversation = new Conversation(conversationId);
        conversation.setParticipantIds(participantIds);
        conversationRepository.saveConversation(conversationId, conversation);
        return conversation;
    }

    List<Message> getConversationHistory(String conversationId){
        Conversation conversation = conversationRepository.getConversation(conversationId);
        return conversation.getMessages();
    }

     public void addMessageToConversation(String conversationId,Message message) {
        Conversation conversation =conversationRepository.getConversation(conversationId);
        conversation.addMessage(message);
    }

    public void markConversationAsRead(String conversationId,String userId) {
        Conversation conversation = conversationRepository.getConversation(conversationId);
        conversation.markMessagesAsRead(userId);
    }
    public Conversation findConversationById(String conversationId) {
        return conversationRepository.getConversation(conversationId);
    }

    public void validateSender(Conversation conversation,String senderId){
        if(!conversation.getUserId().contains(senderId)){
            throw new IllegalArgumentException("Sender with id " + senderId + " is not a participant of the conversation");
        }
    }
}
