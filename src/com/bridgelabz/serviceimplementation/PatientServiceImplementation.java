package com.bridgelabz.serviceimplementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bridegelabz.model.Appointment;
import com.bridegelabz.model.Doctor;
import com.bridegelabz.model.Patient;
import com.bridgelabz.service.PatientService;

public class PatientServiceImplementation implements PatientService {

	/**
	 * Function to display the patient list
	 * 
	 * @param list of the patient
	 */
	@Override
	public void showPatientList(List<Patient> listOfPatient) {
		System.out.println("--------------------");
		System.out.println("List of patients");
		System.out.println("--------------------");
		System.out.println();
		for(int i=0; i<listOfPatient.size(); i++) {
			System.out.println(listOfPatient.get(i));
			System.out.println();
		}		
	}

	/**
	 * Function to search a patient by name
	 * 
	 * @param name of the particular patient to be searched
	 * @param listOfPatient contains the list from where the patient is to be searched
	 * @return Patient object 
	 */
	@Override
	public Patient searchPatientByName(String name, List<Patient> listOfPatient) {
		Patient patient = new Patient();
		for(int i=0; i<listOfPatient.size(); i++) {
			if(listOfPatient.get(i).getName().equalsIgnoreCase(name)) {
				patient = listOfPatient.get(i);
				break;
			}
		}
		if(patient.getName() == null) {
			System.out.println("Patient is not in the list");
		}
		else{
			System.out.println(patient);
		}
		return patient;
	}

	/**
	 * Function to search patient by id 
	 * 
	 * @param id of the patient to be searched
	 * @param listOfPatient contains the list of patient from where the patient is to be searched
	 * @return patient object
	 */
	@Override
	public Patient searchPatientById(int id, List<Patient> listOfPatient) {
		Patient patient = new Patient();
		for(int i=0; i<listOfPatient.size(); i++) {
			if(listOfPatient.get(i).getId() == id) {
				patient = listOfPatient.get(i);
			}
		}
		System.out.println(patient);
		return patient;
	}

	/**
	 * Function to search patient by mobile number
	 * 
	 * @param mobileNUmber contains the mobile number to be searched
	 * @param listOfPatient contains the list of the patient from where to be searched
	 * @return patient object
	 */
	@Override
	public Patient searchPatientByMobileNumber(long mobileNumber, List<Patient> listOfPatient) {
		Patient patient  = new Patient();
		for(int i=0; i<listOfPatient.size(); i++) {
			if(listOfPatient.get(i).getMobileNumber() == mobileNumber) {
				patient =  listOfPatient.get(i);
			}
		}
		System.out.println(patient);
		return patient;
	}

	/**
	 * Function to take appointment 
	 * 
	 * @param patient object to get the particular patient information
	 * @param doctor object to get the particular doctor information
	 * @return Appointment object
	 */
	@Override
	public Appointment takeAppointment(Patient patient, Doctor doctor) {
		Appointment appointment = new Appointment();
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //System.out.println(timestamp);
		appointment.setDoctorName(doctor.getName());
		appointment.setDoctorId(doctor.getId());
		appointment.setPatientName(patient.getName());
		appointment.setPatientId(patient.getId());
		appointment.setTime(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
			return appointment;
	}

}
