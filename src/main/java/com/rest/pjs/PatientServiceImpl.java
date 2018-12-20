package com.rest.pjs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientSe{
	
	List<Patient> patients = new ArrayList<>();
	
	public PatientServiceImpl() {
		Patient p = new Patient();
		p.setId(1);p.setAge(50);p.setName("raja");
		patients.add(p);
		Patient p1 = new Patient();
		p1.setId(2);p1.setAge(50);p1.setName("pat");
		patients.add(p1);
		System.out.println(patients);
	}

	@Override
	public List<Patient> processPatients() {
		return patients;
	}
	

	@Override
	public Patient getOnePatient(int id) {
		Optional<Patient> findAny = patients.stream().filter(a -> a.getId() == id).findAny();
		return findAny.get();
	}

	@Override
	public Response postAPatient(Patient patient) {
		System.out.println(patient);
		System.out.println(patient.getAge());
		patients.add(patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response editPatient(Patient patient, int id) {
		boolean anyMatch = patients.stream().anyMatch(a1 -> a1.getId() == id);
		if(anyMatch) {
			patients.get(id).setAge(patient.getAge());
			patients.get(id).setName(patient.getName());
		}
		return Response.ok(patient).build();
	}
	
	

}
