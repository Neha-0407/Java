package LLD.PubSub.services;

import LLD.PubSub.models.Subscription;
import LLD.PubSub.models.Topic;
import LLD.PubSub.repository.TopicRepository;

public class SubscriptionService {

    private final TopicRepository topicRepository;

    public SubscriptionService(
            TopicRepository topicRepository) {

        this.topicRepository =
                topicRepository;
    }

    public void subscribe(
            String topicId,
            Subscription subscription) {

        Topic topic =
                topicRepository
                        .getTopicById(topicId);

        if (topic == null) {
            throw new RuntimeException(
                    "Topic not found : " +
                    topicId
            );
        }

        topic.getSubscriptions().put(
                subscription
                        .getConsumer()
                        .getConsumerId(),
                subscription
        );
    }

    public void unsubscribe(
            String topicId,
            String consumerId) {

        Topic topic =
                topicRepository
                        .getTopicById(topicId);

        if (topic == null) {
            throw new RuntimeException(
                    "Topic not found : " +
                    topicId
            );
        }

        topic.getSubscriptions()
                .remove(consumerId);
    }

    
}