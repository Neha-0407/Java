package LLD.Messaging.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import LLD.Messaging.exception.UserNotFoundException;
import LLD.Messaging.model.User;

public class UserRepository {
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user.getUserId(), user);
    }

    public User findUserById(String userId) {
        return Optional.ofNullable(users.get(userId)).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
    }
}
