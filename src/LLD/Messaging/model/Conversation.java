package LLD.Messaging.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

import LLD.Messaging.enums.ConversationType;

public class Conversation {
    private final String conversationId;
    private String conversationName;
    private ConversationType conversationType;
    private List<String> participantIds;
    private final List<Message> messages;
    private final Map<String, Integer> unreadMessageCountByUser;
    private final AtomicLong sequenceGenerator = new AtomicLong(0);
    private final ReentrantLock lock = new ReentrantLock();
    public Conversation(String conversationId) {
        this.conversationId = conversationId;
        this.messages = new CopyOnWriteArrayList<>();
        this.unreadMessageCountByUser = new ConcurrentHashMap<>();
        initializeUnreadMessageCount();
    }
    public void initializeUnreadMessageCount(){
        for(String user : participantIds){
            unreadMessageCountByUser.put(user, 0);
        }
    }

    public void addMessage(Message message) {
        lock.lock();
        try{
            messages.add(message);
            // Increment unread message count for all users except the sender
            for (String user : participantIds) {
                if (!user.equals(message.getSenderId())) {
                unreadMessageCountByUser.computeIfPresent(user, (k, v) -> v + 1);
                }
            }
        }finally{
            lock.unlock();
        }
    }

    public long getNextSequenceNumber() {
        return sequenceGenerator.incrementAndGet();
    }

     public synchronized void markMessagesAsRead(
            String userId
    ) {
        unreadMessageCountByUser.put(userId, 0);
    }


    public String getConversationId() {
        return conversationId;
    }
    public String getConversationName() {
        return conversationName;
    }
    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
    }
    public ConversationType getConversationType() {
        return conversationType;
    }
    public void setConversationType(ConversationType conversationType) {
        this.conversationType = conversationType;
    }
    public List<String> getUserId() {
        return participantIds;
    }
    public void setUserId(List<String> userId) {
        this.participantIds = userId;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public Map<String, Integer> getUnreadMessageCountByUser() {
        return unreadMessageCountByUser;
    }
    public void setUnreadMessageCountByUser(Map<String, Integer> unreadMessageCountByUser) {
        this.unreadMessageCountByUser = unreadMessageCountByUser;
    }


}
