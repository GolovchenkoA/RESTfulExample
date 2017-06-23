package ua.golovchenko.artem.DAO;

import ua.golovchenko.artem.User;

import java.util.Collection;

/**
 * Created by artem on 23.06.17.
 */
public interface UserDAO {

    public void update(User user);
    public User get(Integer userId);
    public Collection<User> findAll();

    public void remove(Integer id);
}
