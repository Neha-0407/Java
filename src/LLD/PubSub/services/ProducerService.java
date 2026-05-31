package LLD.PubSub.services;

import LLD.PubSub.models.Message;
import LLD.PubSub.models.Producer;
import LLD.PubSub.models.Topic;
import LLD.PubSub.repository.TopicRepository;

public class ProducerService {

    private final TopicRepository topicRepository;

    public ProducerService(TopicRepository topicRepository) {
        this.topicRepository =topicRepository;
    }

    public void publish(Producer producer, String topicId,Message message) {

        Topic topic = topicRepository.getTopicById(topicId);

        if(topic == null) {
            throw new RuntimeException(
                    "Topic not found : "
                            + topicId
            );
        }

        topic.addMessage(message);

        System.out.println(
                producer.getProducerId()
                + " published : "
                + message.getPayload()
                + " to "
                + topicId
        );
    }
}