package com.bridgelabz.service;

import java.util.List;

import com.bridegelabz.model.Appointment;
import com.bridegelabz.model.Doctor;
import com.bridegelabz.model.Patient;

public interface PatientService {
	
	public void showPatientList(List<Patient> listOfPatient);
	public Patient searchPatientByName(String name, List<Patient> listOfPatient);
	public Patient searchPatientById(int id, List<Patient> listOfPatient);
	public Patient searchPatientByMobileNumber(long mobileNumber, List<Patient> listOfPatient);
	public Appointment takeAppointment(Patient patient, Doctor doctor);
	
}
