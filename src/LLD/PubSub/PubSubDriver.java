package LLD.PubSub;


import LLD.PubSub.models.Subscription;
import LLD.PubSub.models.Consumer;
import LLD.PubSub.models.Message;
import LLD.PubSub.models.Producer;
import LLD.PubSub.models.Topic;
import LLD.PubSub.repository.TopicRepository;

import LLD.PubSub.services.MessageDispatcher;
import LLD.PubSub.services.ProducerService;
import LLD.PubSub.services.SimpleConsumer;
import LLD.PubSub.services.SubscriptionService;
import LLD.PubSub.services.TopicManager;

public class PubSubDriver {
    public static void main(String[] args){
        //Intitlize repositories
        TopicRepository topicRepository = new TopicRepository();
        TopicManager topicManager = new TopicManager(topicRepository);
        SubscriptionService subscriptionService = new SubscriptionService(topicRepository);
        MessageDispatcher dispatcher = new MessageDispatcher(topicRepository);
        ProducerService producerService = new ProducerService(topicRepository);

        // Topic Creation
        Topic ordersTopic =topicManager.createTopic("Orders");
        Topic paymentsTopic = topicManager.createTopic("Payments");
        // Producer
        Producer producer = new Producer("P1");

        // Consumers
        Consumer C1 = new SimpleConsumer("C1");
        Consumer C2 = new SimpleConsumer("C2");
        Consumer C3 = new SimpleConsumer("C3");
        

        Subscription s1 = new Subscription("Sub1", C1);
        Subscription s2 = new Subscription("Sub2", C2);
        Subscription s3 = new Subscription("Sub3", C3);
        
         // Subscribe
        subscriptionService.subscribe(ordersTopic.getTopicId(),s1);

        subscriptionService.subscribe(ordersTopic.getTopicId(),s2);

        subscriptionService.subscribe(paymentsTopic.getTopicId(),s3);

        
        producerService.publish( producer, ordersTopic.getTopicId(), new Message("Order1","Order1 Created"));
        producerService.publish( producer, ordersTopic.getTopicId(), new Message("Order2","Order2 Created"));
        producerService.publish( producer, paymentsTopic.getTopicId(), new Message("Payment1","Payment1 Successful"));


                // Start workers
        dispatcher.startDispatcher(ordersTopic.getTopicId());
        dispatcher.startDispatcher(paymentsTopic.getTopicId());

        dispatcher.stopDispatcher();
    }
}