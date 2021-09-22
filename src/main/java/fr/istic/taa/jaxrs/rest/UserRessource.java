package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.ObjetsMetier.User;
import fr.istic.taa.jaxrs.dao.UserDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/User")
@Produces({"application/json", "application/xml"})
public class UserRessource {
	
	  @GET
	  @Path("/{UserId}")
	  public User getUserById(@PathParam("userId") Long userId)  {
	      return new User("john","rambo");
	  }
	  
	  @GET
	  @Path("/ListUsers")
	  public List<User> ListUser(){
		  UserDao uDao=new UserDao();
		  List<User> LU=uDao.findAll();
		  return LU;
	  }

	  @POST
	  @Consumes("application/json")
	  public Response addUser(@Parameter(description = "User object that needs to be added to the store", required = true) User user) {
		  return Response.ok().entity("SUCCESS").build();
	  }

}
