package com.bridgelabz.serviceimplementation;

import java.util.LinkedList;
import java.util.List;

import com.bridegelabz.model.Appointment;
import com.bridegelabz.model.Doctor;
import com.bridegelabz.model.Patient;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.uitlity.Utility;

public class ManagerServiceImplementation implements ManagerService{
	
	List<Doctor> listOfDoctors;
	List<Patient> listOfPatients;
	List<Appointment> listOfAppointments;
	
	private  static final String DOCTORS_FILE_NAME = "/home/administrator/javaprograms/clinicmanagement/src/com/bridgelabz/files/Doctors.json";
	private static final String PATIENTS_FILE_NAME = "/home/administrator/javaprograms/clinicmanagement/src/com/bridgelabz/files/Patients.json";
	private static final String APPOINTMENTS_FILE_NAME = "/home/administrator/javaprograms/clinicmanagement/src/com/bridgelabz/files/Appointments.json";
	
	public ManagerServiceImplementation() {
		if(listOfDoctors == null && listOfPatients == null && listOfAppointments == null) {
			try {
				listOfDoctors = Utility.jsonToJavaDoctor(DOCTORS_FILE_NAME);
				listOfPatients = Utility.jsonToJavaPatient(PATIENTS_FILE_NAME);
				listOfAppointments = Utility.jsonToJavaAppointment(APPOINTMENTS_FILE_NAME);
			}
			catch(Exception e) {
				System.out.println("List not initialized");
			}
		}
	}
	
	public List<Doctor> getListOfDoctors() {
		return listOfDoctors;
	}

	public void setListOfDoctors(List<Doctor> listOfDoctors) {
		this.listOfDoctors = listOfDoctors;
	}

	public List<Patient> getListOfPatients() {
		return listOfPatients;
	}

	public void setListOfPatients(List<Patient> listOfPatients) {
		this.listOfPatients = listOfPatients;
	}

	public List<Appointment> getListOfAppointments() {
		return listOfAppointments;
	}

	public void setListOfAppointments(List<Appointment> listOfAppointments) {
		this.listOfAppointments = listOfAppointments;
	}
	
	
	@Override
	public List<Doctor> addDoctor(List<Doctor> doctorsList) {
		List<Doctor> newDoctorsList = new LinkedList<>();
		newDoctorsList = doctorsList;
		System.out.println("Enter the number of doctors to be added:-");
		int noOfDoctors = Utility.integerInput();
		Utility.stringInput();
		for(int i=0; i<noOfDoctors; i++) {
			Doctor doctor = new Doctor();
			System.out.println("Enter name of the doctor:-");
			doctor.setName(Utility.stringInput());
			System.out.println("Enter specialization:-");
			doctor.setSpecialization(Utility.stringInput());
			System.out.println("Enter Avaliability:-");
			doctor.setAvailability(Utility.stringInput());
			doctor.setPatientCount(0);
			doctor.setId(listOfDoctors.size());
			System.out.println("New Doctor added..");
			newDoctorsList.add(doctor);
		}
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")) {
			Utility.javaObjectToJson(DOCTORS_FILE_NAME, newDoctorsList);
			return newDoctorsList;
		}
		else {
			System.out.println("Changes not saved");
			return doctorsList;
		}		
	}
	
	@Override
	public List<Doctor> deleteDoctor(int index, List<Doctor> doctorsList) {
		List<Doctor> newDoctorsList = new LinkedList<>();
		newDoctorsList = (List<Doctor>) doctorsList.remove(index);
		System.out.println("Removed the doctor");
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")) {
			Utility.javaObjectToJson(DOCTORS_FILE_NAME, newDoctorsList);
			return newDoctorsList;
		}
		else {
			System.out.println("Changes not saved");
			return doctorsList;
		}
	}
	
	@Override
	public List<Doctor> updateDoctorsDetails(int index, List<Doctor> doctorsList){
		List<Doctor> newDoctorsList = new LinkedList<>();
		Doctor doctor = new Doctor();
		for(int i=0; i<doctorsList.size(); i++) {
			if(doctorsList.get(i).getId() == index) {
				doctor = doctorsList.get(i);
				doctorsList.remove(i);
				break;
			}
		}
		Doctor updateDoctor = new Doctor();
		updateDoctor.setName(doctor.getName());
		updateDoctor.setId(doctor.getId());
		System.out.println("1. Update specializatin");
		System.out.println("2. Upadte availability");
		System.out.println("3. Update patient count");
		System.out.println("Enter your choice:-");
		int choice = Utility.integerInput();
		Utility.stringInput();
		switch(choice) {
		case 1:
			System.out.println("Enter the information");
			updateDoctor.setSpecialization(Utility.stringInput());
			updateDoctor.setAvailability(doctor.getAvailability());
			break;
			
		case 2:
			System.out.println("Enter the information");
			updateDoctor.setAvailability(Utility.stringInput());
			updateDoctor.setSpecialization(doctor.getSpecialization());
			break;
			
		case 3:
			System.out.println("Enter the information");
			updateDoctor.setAvailability(doctor.getAvailability());
			updateDoctor.setSpecialization(doctor.getSpecialization());
			updateDoctor.setPatientCount(doctor.getPatientCount() + 1);
			
		}
		newDoctorsList = doctorsList;
		newDoctorsList.add(updateDoctor);
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String option = Utility.stringInput();
		if(option.equalsIgnoreCase("Y")) {
			Utility.javaObjectToJson(DOCTORS_FILE_NAME, newDoctorsList);
			return newDoctorsList;
		}
		else {
			System.out.println("Changes not saved");
			return doctorsList;
		}
		
	}
	
	@Override
	public List<Patient> addPatient(List<Patient> patientsList){
		List<Patient> newPatientsList = new LinkedList<>();
		newPatientsList = patientsList;
		System.out.println("Enter the number of patients to be added:-");
		int noOfPatients = Utility.integerInput();
		
		for(int i=0; i<noOfPatients; i++) {
			Patient patient = new Patient();
			System.out.println("Enter patient details:-");
			System.out.println("Enter name:-");
			Utility.stringInput();
			patient.setName(Utility.stringInput());
			System.out.println("Enter mobile number:-");
			patient.setMobileNumber(Utility.longIntegerInput());
			System.out.println("Enter age:-");
			patient.setAge(Utility.integerInput());
			patient.setId(patientsList.size());
			patientsList.add(patient);
			System.out.println("New patient added");
		}
		Utility.stringInput();
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")) {
			Utility.javaObjectToJson(PATIENTS_FILE_NAME, newPatientsList);
			return newPatientsList;
		}
		else {
			System.out.println("Changes not saved");
			return patientsList;
		}
	}
	
	@Override
	public List<Patient> deletePatient(List<Patient> patientList, int index){
		List<Patient> newPatientsList = new LinkedList<>();
		patientList.remove(index);
		newPatientsList = patientList;
		System.out.println("Patient removed");
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")) {
			Utility.javaObjectToJson(PATIENTS_FILE_NAME, newPatientsList);
			return newPatientsList;
		}
		else {
			System.out.println("Changes not saved");
			return patientList;
		}
	}
	
	@Override
	public List<Patient> updatePatientsDetails(List<Patient> patientList, int index){
		List<Patient> newPatientsList = new LinkedList<>();
		Patient patient = new Patient();
		Patient updatePatient = new Patient();
		for(int i=0; i<patientList.size(); i++) {
			if(patientList.get(i).getId() == index) {
				patient = patientList.get(index);
				patientList.remove(i);
			}
		}
		newPatientsList = patientList;
		if(patient.getName() == null) {
			System.out.println("Patient is not in the list");
			return patientList;
		}
		else {
			updatePatient.setName(patient.getName());
			updatePatient.setId(patient.getId());
			System.out.println("1. Update mobile number");
			System.out.println("2. Update age");
			System.out.println("Enter your choice:-");
			int choice = Utility.integerInput();
			System.out.println("Enter the information");
			if(choice == 1) {
				updatePatient.setMobileNumber(Utility.longIntegerInput());
				updatePatient.setAge(patient.getAge());
			}
			else {
				updatePatient.setAge(Utility.integerInput());
				updatePatient.setMobileNumber(patient.getMobileNumber());
			}
			patientList.add(updatePatient);
			System.out.println("Updated patient details..");
		}
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")) {
			Utility.javaObjectToJson(PATIENTS_FILE_NAME, newPatientsList);
			return newPatientsList;
		}
		else {
			System.out.println("Changes not saved");
			return patientList;
		}
	}
	
	public void saveChanges() {
		Utility.javaObjectToJson(DOCTORS_FILE_NAME, listOfDoctors);
		Utility.javaObjectToJson(PATIENTS_FILE_NAME, listOfPatients);
		Utility.javaObjectToJson(APPOINTMENTS_FILE_NAME, listOfAppointments);
	}

	public List<Appointment> fixAppointment(List<Appointment> listOfAppointment, Appointment appointment) {
		List<Appointment> newAppointmentList = new LinkedList<>();
		newAppointmentList = listOfAppointment;
		newAppointmentList.add(appointment);
		return newAppointmentList;
	}
}















