package LLD.PubSub.services;

import LLD.PubSub.models.Consumer;
import LLD.PubSub.models.Message;

public class SimpleConsumer implements Consumer {

    private final String consumerId;

    public SimpleConsumer(String consumerId) {
        this.consumerId = consumerId;
    }



    @Override
    public void consume(Message message) {
        System.out.println(
                "Message consumed by : " +
                consumerId +
                " Message : " +
                message.getMessageId()
        );
    }



    @Override
    public String getConsumerId() {
        // TODO Auto-generated method stub
        return consumerId;
    }
    
}
