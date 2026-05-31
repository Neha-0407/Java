package LLD.PubSub.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import LLD.PubSub.models.Topic;

public class TopicRepository {
    private final ConcurrentHashMap<String, Topic> topicMap = new ConcurrentHashMap<>();

    public void addTopic(Topic topic) {
        topicMap.putIfAbsent(topic.getTopicId(), topic);
    }
    public Topic getTopicById(String topicId) {

        return topicMap.get(topicId);
    }

    public List<String> getAllTopicIds() {
        return new ArrayList<>(topicMap.keySet());
    }

}
