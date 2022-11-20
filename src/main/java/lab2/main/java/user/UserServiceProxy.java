package lab2.main.java.user;

import java.time.Instant;
import java.util.HashMap;

public class UserServiceProxy implements UserService {
    private static UserServiceProxy instance;

    private final UserServiceImpl userService = UserServiceImpl.getInstance();
    private final HashMap<Long, User> userCache = new HashMap<>();

    private UserServiceProxy() {
    }

    public static UserServiceProxy getInstance() {
        if (instance == null) {
            instance = new UserServiceProxy();
        }

        return instance;
    }

    @Override
    public void addNewUser(User user) {
        userService.addNewUser(user);
    }

    @Override
    public User getUserById(Long id) throws Exception {
        User cachedUser = userCache.get(id);

        if (cachedUser != null) {
            return cachedUser;
        }

        User user = null;
        try {
            user = userService.getUserById(id);
            userCache.put(user.getId(), user);
        } catch (Exception ex) {

        }


        return user;
    }

    @Override
    public void updateUser(User user) throws Exception {
        userService.updateUser(user);
        userCache.remove(user.getId());
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        userService.deleteUser(id);
        userCache.remove(id);
    }
}
