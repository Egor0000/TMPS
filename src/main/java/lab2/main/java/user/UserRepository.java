package lab2.main.java.user;

import java.util.HashMap;

public class UserRepository {
    private static UserRepository instance;

    private final HashMap<Long, User> realUserDatabase = new HashMap<>();
    private Long nextId = 0L;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {

    }

    public void create(User user) {
        user.setId(nextId);
        realUserDatabase.put(nextId++, user);
    }

    public User get(Long id) {
        return realUserDatabase.get(id);
    }

    public void update(User user) {
        if (user.getId() == null || !realUserDatabase.containsKey(user.getId())) {
            return;
        }
        realUserDatabase.put(user.getId(), user);
    }

    public void delete(Long id) {
        realUserDatabase.remove(id);
    }
}
