package LLD.Messaging.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import LLD.Messaging.model.Conversation;
import LLD.Messaging.model.Message;

public class ConversationRepository {
    private final Map<String, Conversation> conversationMap = new ConcurrentHashMap<>();
    private final Map<String,List<Message>> conversationMessagesMap = new ConcurrentHashMap<>();


    public void saveConversation(String conversationId, Conversation conversation) {
        conversationMap.putIfAbsent(conversationId, conversation);
    }
    
    public Conversation getConversation(String conversationId) {
        Conversation conversation = conversationMap.get(conversationId);
        if (conversation == null) {
            throw new ConversationNotFoundException("Conversation with id " + conversationId + " not found");
        }
        return conversation;
    }
}
