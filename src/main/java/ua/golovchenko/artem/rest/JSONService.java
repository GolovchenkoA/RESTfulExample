package ua.golovchenko.artem.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ua.golovchenko.artem.User;

@Path("/user")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public User getTrackInJSON() {

		User user = new User();
		user.setName("UserName");
		user.setSurname("UserSurname");

		return user;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(User user) {

		String result = "User saved : " + user;
		return Response.status(201).entity(result).build();
		
	}
	
}