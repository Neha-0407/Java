package LLD.PubSub.models;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class Subscription {
    private final String subscriptionId;
    private Consumer consumer;
    private int offset;
    private Predicate<Message> filter; //filtered message consumption

    public Subscription(String subscriptionId, Consumer consumer) {
        this.subscriptionId = subscriptionId;
        this.consumer = consumer;
        this.offset = 0;

    }
    

    public String getSubscriptionId() {
        return subscriptionId;
    }
    public Consumer getConsumer() {
        return consumer;
    }

    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public Predicate<Message> getFilter() {
        return filter;
    }

    public void setFilter(Predicate<Message> filter) {
        this.filter = filter;
    }


    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public boolean shouldConsume(Message message){
        return filter == null || filter.test(message);
    }
    
}
