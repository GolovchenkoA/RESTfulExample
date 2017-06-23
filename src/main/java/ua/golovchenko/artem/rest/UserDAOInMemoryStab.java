package ua.golovchenko.artem.rest;

import ua.golovchenko.artem.DAO.UserDAO;
import ua.golovchenko.artem.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by artem on 23.06.17.
 */ // Database stab
class UserDAOInMemoryStab implements UserDAO {

    private static UserDAOInMemoryStab instance;

    private Map<Integer, User> users;


    private UserDAOInMemoryStab() {
            users = new HashMap<Integer,User>();
            users.put(10, new User(10, "UserName10", "UserSurname10"));
            users.put(20, new User(20, "UserName20", "UserSurname20"));
            users.put(30, new User(30, "UserName30", "UserSurname30"));

    }

    public static UserDAOInMemoryStab getInstanhce(){
        if(instance == null){
            instance = new UserDAOInMemoryStab();
        }
        return instance;
    }


    public void update(User user) {
        users.put(user.getId(), user);
    }

    public User get(Integer userId) {

        return (User) users.get(userId);
    }

    public Collection<User> findAll() {
        return users.values();
    }

    public void remove(Integer id) {
        users.remove(id);
    }

}
