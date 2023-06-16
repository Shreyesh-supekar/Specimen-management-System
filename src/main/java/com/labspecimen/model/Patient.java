package com.labspecimen.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	@Column(name = "patientId")
	private int patientId;

	@Column(name = "patientName")
	private String patientName;

	@Column(name = "patientAge")
	private int patientAge;

	@Column(name = "patientWeight")
	private double patientWeight;

	@Column(name = "patientHeight")
	private double patientHeight;

	@Column(name = "patientBloodType")
	private String patientBlood;

	@Column(name = "patientAddress")
	private String patientAddress;

	@Column(name = "patientPhone")
	private long patientPhone;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public double getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(double patientWeight) {
		this.patientWeight = patientWeight;
	}

	public double getPatientHeight() {
		return patientHeight;
	}

	public void setPatientHeight(double patientHeight) {
		this.patientHeight = patientHeight;
	}

	public String getPatientBlood() {
		return patientBlood;
	}

	public void setPatientBlood(String patientBlood) {
		this.patientBlood = patientBlood;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public long getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(long patientPhone) {
		this.patientPhone = patientPhone;
	}

	public Patient() {
	}

	public Patient(int patientId, String patientName, int patientAge, double patientWeight, double patientHeight, String patientBlood, String patientAddress, long patientPhone) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientWeight = patientWeight;
		this.patientHeight = patientHeight;
		this.patientBlood = patientBlood;
		this.patientAddress = patientAddress;
		this.patientPhone = patientPhone;
	}

	@Override
	public String toString() {
		return "Patient{" +
				"patientId=" + patientId +
				", patientName='" + patientName + '\'' +
				", patientAge=" + patientAge +
				", patientWeight=" + patientWeight +
				", patientHeight=" + patientHeight +
				", patientBlood='" + patientBlood + '\'' +
				", patientAddress='" + patientAddress + '\'' +
				", patientPhone=" + patientPhone +
				'}';
	}
}
