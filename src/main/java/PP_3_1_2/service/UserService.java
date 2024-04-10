package PP_3_1_2.service;



import PP_3_1_2.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User showUser(long id);

    void update(Long id, User user);

    void delete(Long id);
}
