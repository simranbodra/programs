package com.bridgelabz.service;

import java.util.List;

import com.bridegelabz.model.Doctor;

public interface DoctorService {
	
	public void showDoctorsList(List<Doctor> listOfDoctors);
	public Doctor searchDoctorById(int id, List<Doctor> listOfDoctors);
	public Doctor searchDoctorByName(String name, List<Doctor> listOfDoctors);
	public List<Doctor> searchDoctorBySpecialization(String specialization, List<Doctor> listOfDoctors);
	public List<Doctor> searchDoctorByAvailability(String availability, List<Doctor> listOfDoctors);
	public List<Doctor> searchPopularDoctors(List<Doctor> listOfDoctors);
	
}
