package com.bridgelabz.service;

import java.util.List;

import com.bridegelabz.model.Doctor;
import com.bridegelabz.model.Patient;

public interface ManagerService {
	
	public List<Doctor> addDoctor(List<Doctor> listOfDoctors);
	public List<Doctor> deleteDoctor(int index, List<Doctor> listOfDoctors);
	public List<Doctor> updateDoctorsDetails(int index, List<Doctor> listOfDoctors);
	public List<Patient> addPatient(List<Patient> listOfPatients);
	public List<Patient> deletePatient(List<Patient> listOfPatient, int index);
	public List<Patient> updatePatientsDetails(List<Patient> listOfPatient, int index);
	
}
