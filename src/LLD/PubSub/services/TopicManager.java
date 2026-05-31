package LLD.PubSub.services;

import java.util.concurrent.atomic.AtomicInteger;

import LLD.PubSub.models.Message;
import LLD.PubSub.models.Topic;
import LLD.PubSub.repository.TopicRepository;

public class TopicManager {
    private final AtomicInteger topicIdGenerator = new AtomicInteger(0);
    private final TopicRepository topicRepository;
   
    public TopicManager(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic createTopic(String topicName) {
        Topic topic = new Topic("Top_"+topicIdGenerator.incrementAndGet(), topicName);
        topicRepository.addTopic(topic);
        return topic;
    }

    public Topic getTopicById(String topicId) {
        return topicRepository.getTopicById(topicId);
    }

    public void publishMessage(Topic topic, Message message) {
        topic.addMessage(message);
    }

}
