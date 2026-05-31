package LLD.PubSub.models;

public class Producer {
    private final String producerId;
    public Producer(String producerId) {
        this.producerId = producerId;
    }
    public String getProducerId() {
        return producerId;
    }
}
