package LLD.PubSub.services;



import LLD.PubSub.models.Topic;
import LLD.PubSub.repository.TopicRepository;
import LLD.PubSub.models.Subscription;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageDispatcher {
    private final TopicRepository topicRepository;
    private final ExecutorService executorService;
    public MessageDispatcher(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
        this.executorService = Executors.newFixedThreadPool(5);
    }

    public void startDispatcher(String topicId){
        Topic topic = topicRepository.getTopicById(topicId);
        if(topic == null){
            throw new RuntimeException("Topic not found : " + topicId);
        }
        List<Subscription> subscriptions = topic.getSubscriptions().values().stream().toList();
        for(Subscription subscription : subscriptions){
            executorService.submit(new SubscriberWorker(subscription, topic));
        }
    }

    public void stopDispatcher(){
        executorService.shutdown();
    }
}
