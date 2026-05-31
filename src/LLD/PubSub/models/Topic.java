package LLD.PubSub.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Topic {
    private final String topicId;
    private final String topicName;
    private List<Message> messages;
    private Map<String, Subscription> subscriptions; //consumerId to subscription mapping or else
    //  how would we know who has subscribed to the topic and what is their offset
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition messageAvailable = lock.newCondition();

    public Topic(String topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.messages = new ArrayList<>();
        this.subscriptions = new ConcurrentHashMap<>();
    }

    public String getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }
    public void addMessage(Message message) {
        lock.lock();
        try{
            messages.add(message);
            messageAvailable.signalAll(); //notify waiting subscribers
        } finally {
            lock.unlock();
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Map<String, Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Map<String, Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public Condition getMessageAvailable(){
        return messageAvailable;
    }

}
