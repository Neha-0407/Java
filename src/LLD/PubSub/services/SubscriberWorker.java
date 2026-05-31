package LLD.PubSub.services;

import java.util.concurrent.locks.ReentrantLock;

import LLD.PubSub.models.Message;
import LLD.PubSub.models.Subscription;
import LLD.PubSub.models.Topic;

public class SubscriberWorker implements Runnable {
    
        private final Subscription subscription;
        private final Topic topic;  


        public SubscriberWorker(Subscription subscription, Topic topic) {
            this.subscription = subscription;
            this.topic = topic;
        }

        @Override
        public void run(){
            topic.getLock().lock();
            try{
                while(topic.getMessages().size() <= subscription.getOffset()){
                    //wait for messages to be published
                    topic.getMessageAvailable().await();
                }
                while(topic.getMessages().size() > subscription.getOffset()){
                    Message message = topic.getMessages().get(subscription.getOffset());
                    if(subscription.shouldConsume(message)){
                        subscription.getConsumer().consume(message);
                    }
                    subscription.setOffset(subscription.getOffset() + 1);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                topic.getLock().unlock();
            }
        }


}
