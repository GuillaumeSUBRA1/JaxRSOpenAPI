package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.ObjetsMetier.Agenda;
import fr.istic.taa.ObjetsMetier.Appointment;
import fr.istic.taa.jaxrs.dao.AppointmentDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/Agenda")
@Produces({"application/json", "application/xml"})
public class AgendaRessource {
		  
	  
	  @GET
	  @Path("/ListAppointment")
	  public List<Appointment> getAppointment(){
		  AppointmentDao apDao=new AppointmentDao(); 
		  return apDao.findAll();
		  
	  }

	  @POST
	  @Consumes("application/json")
	  public Response addAgenda(@Parameter(description = "User object that needs to be added to the store", required = true) Agenda agenda) {
		  return Response.ok().entity("SUCCESS").build();
	  }

}
