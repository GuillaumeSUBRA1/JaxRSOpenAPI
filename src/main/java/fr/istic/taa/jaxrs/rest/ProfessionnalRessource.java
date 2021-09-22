package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.ObjetsMetier.Professionnal;
import fr.istic.taa.jaxrs.dao.ProfessionnalDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/Professionnal")
@Produces({"application/json", "application/xml"})
public class ProfessionnalRessource {

	  @GET
	  @Path("/{ProfessionnalId}")
	  public Professionnal getUserById(@PathParam("userId") Long userId)  {
	      return new Professionnal("john","rambo","pompier");
	  }
	  
	  @GET
	  @Path("/ListProfessionnal")
	  public List<Professionnal> ListProfessionnal(){
		  ProfessionnalDao pDao=new ProfessionnalDao();
		  List<Professionnal> LP=pDao.findAll();
		  return LP;
	  }

	  @POST
	  @Consumes("application/json")
	  public Response addProfessionnal(@Parameter(description = "User object that needs to be added to the store", required = true) Professionnal p) {
		  return Response.ok().entity("SUCCESS").build();
	  }

}
