package com.bridgelabz.serviceimplementation;

import java.util.LinkedList;
import java.util.List;

import com.bridegelabz.model.Doctor;
import com.bridgelabz.service.DoctorService;

public class DoctorServiceImplementation implements DoctorService{

	@Override
	public void showDoctorsList(List<Doctor> listOfDoctors) {
		System.out.println("List of doctors in the hospital");
		System.out.println("-------------------------------");
		System.out.println();
		for(int i=0; i<listOfDoctors.size(); i++) {
			System.out.println(listOfDoctors.get(i));
			System.out.println();
		}		
	}
	
	@Override
	public Doctor searchDoctorById(int id, List<Doctor> listOfDoctors) {
		Doctor doctor = new Doctor();
		for(int i=0; i<listOfDoctors.size(); i++) {
			if(listOfDoctors.get(i).getId() == id) {
				doctor = listOfDoctors.get(i);
				break;
			}
		}
		return doctor;
	}

	@Override
	public Doctor searchDoctorByName(String name, List<Doctor> listOfDoctors) {
		Doctor doctor = new Doctor();
		for(int i=0; i<listOfDoctors.size(); i++) {
			if(listOfDoctors.get(i).getName().equalsIgnoreCase(name)) {
				doctor = listOfDoctors.get(i);
				break;
			}
		}
		return doctor;
	}

	@Override
	public List<Doctor> searchDoctorBySpecialization(String specialization, List<Doctor> listOfDoctors) {
		List<Doctor> newList = new LinkedList<>();	
		for(int i=0; i<listOfDoctors.size(); i++) {
			if(listOfDoctors.get(i).getSpecialization().equalsIgnoreCase(specialization)) {
				newList.add(listOfDoctors.get(i));
			}
		}
		return newList;
	}

	@Override
	public List<Doctor> searchDoctorByAvailability(String availability, List<Doctor> listOfDoctors) {
		List<Doctor> newList = new LinkedList<>();
		for(int i=0; i<listOfDoctors.size(); i++) {
			if(listOfDoctors.get(i).getAvailability().equalsIgnoreCase(availability)) {
				newList.add(listOfDoctors.get(i));
			}
		}
		return newList;
	}
	
	public List<Doctor> searchPopularDoctors(List<Doctor> listOfDoctors){
		List<Doctor> listOfPopularDoctors = new LinkedList<>();
		int max = listOfDoctors.get(0).getPatientCount();
		for(int i=0; i<listOfDoctors.size(); i++) {
			if(max < listOfDoctors.get(i).getPatientCount()) {
				max = listOfDoctors.get(i).getPatientCount();
			}
		}
		for(int i=0; i<listOfDoctors.size(); i++) {
			if(listOfDoctors.get(i).getPatientCount() == max) {
				listOfPopularDoctors.add(listOfDoctors.get(i));
			}
		}
		return listOfPopularDoctors;
	}
	
	public void searchPopularSpecialization(List<Doctor> listOfDoctors){
		List<Doctor> listOfPopularDoctors = searchPopularDoctors(listOfDoctors);
		List<String> listOfPopularSpecialization = new LinkedList<>();
		for(int i=0; i<listOfPopularDoctors.size(); i++) {
			listOfPopularSpecialization.add(listOfPopularDoctors.get(i).getSpecialization());
		}
		for(int i=0; i<listOfPopularSpecialization.size(); i++) {
			System.out.println(listOfPopularSpecialization.get(i));
		}
	}
	
	
}
