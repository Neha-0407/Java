package LLD.Messaging.repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import LLD.Messaging.model.Message;
import java.util.Map;

public class MessageRepository {
    private final Map<String, List<Message>> conversationMessagesMap = new ConcurrentHashMap<>();
    private final Map<Long, Message> messageByIdMap = new ConcurrentHashMap<>();

    public void addMessageToConversation(String conversationId, Message message) {
        conversationMessagesMap.computeIfAbsent(conversationId, k -> new ArrayList<>()).add(message);
    }

    public void saveMessage(Message message) {
        messageByIdMap.put(message.getMessageId(), message);
    }

    public Message findMessageById(Long messageId) {
        return messageByIdMap.get(messageId);
    }

}
