package com.bridgelabz.controller;

import java.util.LinkedList;
import java.util.List;

import com.bridegelabz.model.Appointment;
import com.bridegelabz.model.Doctor;
import com.bridegelabz.model.Patient;
import com.bridgelabz.serviceimplementation.DoctorServiceImplementation;
import com.bridgelabz.serviceimplementation.ManagerServiceImplementation;
import com.bridgelabz.serviceimplementation.PatientServiceImplementation;
import com.bridgelabz.uitlity.Utility;

public class ClinicManager {

	public static void main(String[] args) {
		
		ManagerServiceImplementation manager = new ManagerServiceImplementation();
		DoctorServiceImplementation doctorService = new DoctorServiceImplementation();
		PatientServiceImplementation patientService = new PatientServiceImplementation();
		List<Doctor> listOfDoctors = new LinkedList<>();
		listOfDoctors = manager.getListOfDoctors();
		List<Patient> listOfPatients = new LinkedList<>();
		listOfPatients = manager.getListOfPatients();
		List<Appointment> listOfAppointment = new LinkedList<>();
		listOfAppointment = manager.getListOfAppointments();

		System.out.println("Welcome to the clinic");
		System.out.println();
		int choice = 0;
		
		while(choice <= 10) {
			System.out.println("1. Add Doctor                        7. Search a doctor");
			System.out.println("2. Delete Doctor                     8. Search a patient");
			System.out.println("3. Update Doctor Details             9. Take appointment");
			System.out.println("4. Add Patient                       10. Search popular Doctor");
			System.out.println("5. Delete Patient                    11. Search popular Specialization");
			System.out.println("6. Update Patient Details            12. Exit");
			System.out.println("Enter your choice:-");
			choice = Utility.integerInput();
			
			switch(choice) {
			case 1:
				doctorService.showDoctorsList(listOfDoctors);
				manager.setListOfDoctors(manager.addDoctor(listOfDoctors));
				doctorService.showDoctorsList(listOfDoctors);
				break;
				
			case 2:
				doctorService.showDoctorsList(listOfDoctors);
				System.out.println("Enter the id of the doctor to delete:-");
				int index = Utility.integerInput();
				manager.setListOfDoctors(manager.deleteDoctor(index, listOfDoctors));
				doctorService.showDoctorsList(listOfDoctors);
				break;
				
			case 3:
				doctorService.showDoctorsList(listOfDoctors);
				System.out.println("Enter the id of the doctor to update the details:-");
				int id = Utility.integerInput();
				manager.setListOfDoctors(manager.updateDoctorsDetails(id, listOfDoctors));
				doctorService.showDoctorsList(listOfDoctors);
				break;
				
			case 4:
				patientService.showPatientList(listOfPatients);
				manager.setListOfPatients(manager.addPatient(listOfPatients));
				patientService.showPatientList(listOfPatients);
				break;
				
			case 5:
				patientService.showPatientList(listOfPatients);
				System.out.println("Enter the id of the patient to delete:-");
				int patientIndex = Utility.integerInput();
				manager.setListOfPatients(manager.deletePatient(listOfPatients, patientIndex));
				patientService.showPatientList(listOfPatients);
				break;
				
			case 6:
				patientService.showPatientList(listOfPatients);
				System.out.println("Enter the id of the patient to update the details:-");
				int patientId = Utility.integerInput();
				manager.setListOfPatients(manager.updatePatientsDetails(listOfPatients, patientId));
				patientService.showPatientList(listOfPatients);
				break;
				
			case 7:
				System.out.println("1. Search doctor by Id");
				System.out.println("2. Search doctor by Name");
				System.out.println("3. Search doctor by Specialization");
				System.out.println("4. Search doctor by Availability");
				System.out.println("Enter your choice");
				int doctorSearchOption = Utility.integerInput();
				Utility.stringInput();
				switch(doctorSearchOption) {
				case 1:
					Doctor doctor = new Doctor();
					System.out.println("Enter doctor's Id:-");
					int doctorId = Utility.integerInput();
					doctor = doctorService.searchDoctorById(doctorId, listOfDoctors);
					if(doctor != null)
						System.out.println(doctor);
					else
						System.out.println("No doctor found with such Id");
					break;
					
				case 2:
					System.out.println("Enter doctor's name:-");
					String doctorName = Utility.stringInput();
					System.out.println(doctorService.searchDoctorByName(doctorName, listOfDoctors));
					break;
					
				case 3:
					System.out.println("Enter doctor's specialization:-");
					String specialization = Utility.stringInput();
					List<Doctor>  specializationList = doctorService.searchDoctorBySpecialization(specialization, listOfDoctors);
					for(int i=0; i<specializationList.size(); i++) {
						System.out.println(specializationList.get(i));
					}
					break;
					
				case 4:
					System.out.println("Enter doctor's Availability:-");
					String availability = Utility.stringInput();
					List<Doctor> availabilityList = doctorService.searchDoctorByAvailability(availability, listOfDoctors);
					for(int i=0; i<availabilityList.size(); i++) {
						System.out.println(availabilityList.get(i));
					}
					break;
					
				default:
					System.out.println("Wrong choice");
					break;
				}
				break;
				
			case 8:
				System.out.println("1. Search by Name");
				System.out.println("2. Search by Mobile Number");
				System.out.println("3. Search by Id");
				System.out.println("Enter choice:-");
				int searchPatientOption = Utility.integerInput();
				switch(searchPatientOption){
				case 1:
					System.out.println("Enter name:-");
					Utility.stringInput();
					String patientName = Utility.stringInput();
					patientService.searchPatientByName(patientName, listOfPatients);
					break;
					
				case 2:
					System.out.println("Enter Mobile Number:-");
					long mobileNumber = Utility.longIntegerInput();
					System.out.println(patientService.searchPatientByMobileNumber(mobileNumber, listOfPatients));
					break;
					
				case 3:
					System.out.println("Enter Patient Id:-");
					int serachId = Utility.integerInput();
					System.out.println(patientService.searchPatientById(serachId, listOfPatients));
					break;
					
				default :
					System.out.println("Wrong choice");
					break;
				}
				break;
				
			case 9:
				Doctor doctor = new Doctor();
				Patient patient = new Patient();
				Appointment appointment = new Appointment();
				Utility.stringInput();
				System.out.println("Enter doctor's specialization:-");
				String specialization = Utility.stringInput();
				System.out.println("Enter doctor's availability");
				String availability = Utility.stringInput();
				LinkedList<Doctor>  specializationList = (LinkedList<Doctor>) doctorService.searchDoctorBySpecialization(specialization, listOfDoctors);
				LinkedList<Doctor> listOfAvailability = (LinkedList<Doctor>)doctorService.searchDoctorByAvailability(availability, specializationList);
				if(listOfAvailability.isEmpty()) {
					System.out.println("No doctors available");
					break;
				}
				doctorService.showDoctorsList(listOfAvailability);
				System.out.println("Enter the doctor's id to book the appointment");
				int appointmentDoctorId = Utility.integerInput();
				System.out.println("Enter patient's name:-");
				Utility.stringInput();
				String name = Utility.stringInput();
				patient = patientService.searchPatientByName(name, listOfPatients);
				if(patient.getName() == null) {
					manager.setListOfPatients(manager.addPatient(listOfPatients));
					patient = patientService.searchPatientByName(name, listOfPatients);
				}
				doctor = doctorService.searchDoctorById(appointmentDoctorId, listOfAvailability);
				if(doctor.getPatientCount() < 5) {
					appointment = patientService.takeAppointment(patient, doctor);
					manager.setListOfAppointments(manager.fixAppointment(listOfAppointment, appointment));
					manager.setListOfDoctors(manager.updateDoctorsDetails(doctor.getId(), listOfDoctors));
					manager.saveChanges();
				}
				else {
					System.out.println("Patient's slot is full");
				}
				break;
				
			case 10:
				LinkedList<Doctor> listOfPopularDoctors = (LinkedList<Doctor>) doctorService.searchPopularDoctors(listOfDoctors);
				for(int i=0; i<listOfPopularDoctors.size(); i++) {
					System.out.println(listOfPopularDoctors.get(i).getName());
				}
				break;
				
			case 11:
				doctorService.searchPopularSpecialization(listOfDoctors);
				break;
				
			case 12:
				System.exit(0);
				break;
				
			default:
				System.out.println("Wrong choice");
				choice = Utility.integerInput();
			}
		}
		
	}

}
