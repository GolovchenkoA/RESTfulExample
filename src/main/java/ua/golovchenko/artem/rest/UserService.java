package ua.golovchenko.artem.rest;

import ua.golovchenko.artem.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by artem on 15.06.17.
 */

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {

    UserDAO userDAO = new UserDAO();

    @GET
    public Collection<User> getAllUsers() {

        return userDAO.findAll();
    }

/*    @GET
    @Path("{userid}")
    public User getUser(@PathParam("userId") Integer userId) {
        return UserDAO.getUser(userId);
    }*/

    @GET
    @Path("{id}")
    public Collection<User> getUser(@PathParam("id") Integer id) {
        Collection<User> users = new LinkedList<>();
        users.add(userDAO.getUser(id));
        return users;
    }


/*    @POST
    public Response addUser(User user) {

        userDAO.addUser(user);
        return Response.ok(user).build();
    }*/


    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {
        return "UserService class TEXT_PLAIN";
    }



    // Database stab
    class UserDAO{

        private Map<Integer,User> users = new HashMap<Integer, User>();

        UserDAO(){
            users.put(1,new User(10,"UserName10","UserSurname10"));
            users.put(2,new User(20,"UserName20","UserSurname20"));
            users.put(3,new User(30,"UserName30","UserSurname30"));
        }



        public void addUser(User user){
            users.put(user.getId(), user);
        }

        public User getUser(Integer userId){

            return (User) users.get(userId);
        }

        public Collection<User> findAll(){
            return users.values();
        }
    }




}

