package PP_3_1_2.dao;


import PP_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class UserDaoimp implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoimp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User showUser(long id) {
        return entityManager.find(User.class, id);

    }

    @Transactional
    @Override
    public void update(Long id, User updateUser) {
        User udateUserId = showUser(id);
        udateUserId.setName(updateUser.getName());
        udateUserId.setLastName(updateUser.getLastName());
        udateUserId.setAge(updateUser.getAge());

    }

    @Transactional
    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}
