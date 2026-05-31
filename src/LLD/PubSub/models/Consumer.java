package LLD.PubSub.models;

public interface Consumer {
    String getConsumerId();

    void consume(Message message);
}
