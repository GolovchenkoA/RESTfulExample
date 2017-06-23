package ua.golovchenko.artem.rest;

import ua.golovchenko.artem.DAO.UserDAO;
import ua.golovchenko.artem.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by artem on 15.06.17.
 */

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {

    UserDAO userDAO = UserDAOInMemoryStab.getInstanhce();

    @GET
    public Collection<User> getAllUsers() {

        System.out.println("findAll() query. /users");
        return userDAO.findAll();
    }

/*    @GET
    @Path("{userid}")
    public User get(@PathParam("userId") Integer userId) {
        return UserDAO.get(userId);
    }*/

    @GET
    @Path("{id}")
    public Collection<User> getUser(@PathParam("id") Integer id) {
        Collection<User> users = new LinkedList<>();
        users.add(userDAO.get(id));
        System.out.println("Get user : " + userDAO.get(id));
        return users;
    }



    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {
        return "UserService class TEXT_PLAIN";
    }


    @POST
    public void add(User user) {

        userDAO.update(user);
        System.out.println("New user : " + user + " created");
        //return Response.ok(user).build();
    }

    @PUT
    @Path("{id}")
    public Response updateUser(User user) {

        userDAO.update(user);
        System.out.println("User updated : " + user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeUser(@PathParam("id") Integer id) {
        userDAO.remove(id);
        System.out.println("Deleted. User id: " + id);
        return Response.noContent().build();

    }
/**/


}

