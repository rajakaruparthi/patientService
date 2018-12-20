package com.rest.pjs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/patientservice")
public interface PatientSe {
	
	@GET
	@Path("/patients")
	public List<Patient> processPatients();
	
	@GET
	@Path("/patients/{id}")
	public Patient getOnePatient(@PathParam(value = "id") int id);

	@POST
	@Path("/patients")
	public Response postAPatient(Patient patient);
	
	@PUT
	@Path("/patients/id")
	public Response editPatient(Patient patient, @PathParam(value = "id") int id);
	
}
