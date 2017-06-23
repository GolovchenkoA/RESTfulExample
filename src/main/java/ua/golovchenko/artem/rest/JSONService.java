package ua.golovchenko.artem.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ua.golovchenko.artem.User;

import java.util.LinkedList;
import java.util.List;

/*@Path("/users")*/
public class JSONService {

	private static List<User> users = new LinkedList();

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {

		users.add(1,new User(1,"ManyUserName","ManyUserSurname"));

		return users;

	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {



		User user = new User();
		user.setName("OneUserName");
		user.setSurname("OneUserSurname");

		return user;

	}

	@POST
	@Path("/post")
	//@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {

		String result = "User saved : " + user;
		users.add(user.getId(), user);

		return Response.status(201).entity(result).build();
		
	}
	
}