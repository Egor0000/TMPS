package lab2.main.java.user;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance;
    private final UserRepository userRepository = UserRepository.getInstance();

    private UserServiceImpl() {
    }

    protected static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public void addNewUser(User user) {
        System.out.println("Adding new user to database...");
        userRepository.create(user);
    }

    @Override
    public User getUserById(Long id) throws Exception {
        User user = userRepository.get(id);
        if (user == null) {
            throw new Exception("No user with id " + id + " found");
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws Exception {
        User dbUser = userRepository.get(user.getId());
        if (dbUser == null) {
            throw new Exception("No user with id " + user.getId() + " found");
        }
        userRepository.update(user);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User dbUser = userRepository.get(id);
        if (dbUser == null) {
            throw new Exception("No user with id " + id + " found");
        }
        userRepository.delete(id);
    }
}
