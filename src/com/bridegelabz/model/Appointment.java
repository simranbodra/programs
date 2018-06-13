package com.bridegelabz.model;

import java.sql.Timestamp;

public class Appointment {
	
	private String doctorName;
	private int doctorId;
	private String patientName;
	private int patientId;
	private String time;
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Appointment [doctorName=" + doctorName + ", doctorId=" + doctorId + ", patientName=" + patientName
				+ ", patientId=" + patientId + ", time=" + time + "]";
	}
}
