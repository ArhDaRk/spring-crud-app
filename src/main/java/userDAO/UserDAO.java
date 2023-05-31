package userDAO;

import model.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserDAO {
    void addUser(User user);

    @Transactional
    void removeUserById(int id);

    @Transactional
    void replaceUser(User updateUser);
}
