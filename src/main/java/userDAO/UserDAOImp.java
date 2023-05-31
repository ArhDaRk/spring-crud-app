package userDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.close();
    }
    @Override
    @Transactional
    public void removeUserById(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
    @Override
    @Transactional
    public void replaceUser(User updateuser) {
        entityManager.merge(updateuser);
    }
}
