package lab2.main.java.user;

public interface UserService {
    void addNewUser(User user);
    User getUserById(Long id) throws Exception;
    void updateUser(User user) throws Exception;
    void deleteUser(Long id) throws Exception;
}
