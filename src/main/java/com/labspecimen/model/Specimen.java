package com.labspecimen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Specimen {

	@Id
	@GeneratedValue
	@Column(name = "SpecimenId")
	private int specimenId;

	@Column(name = "PatientId")
	private int patientId;

	@Column(name = "SpecimenType")
	private String specimenType;

	@Column(name = "CollectionDate")
	private String collectionDate;

	@Column(name = "CollectionLocation")
	private String collectionLocation;

	@Column(name = "PreservationMethod")
	private String preservationMethod;

	@Column(name = "StorageLocation")
	private String storageLocation;

	public int getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(int specimenId) {
		this.specimenId = specimenId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getSpecimenType() {
		return specimenType;
	}

	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}

	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getCollectionLocation() {
		return collectionLocation;
	}

	public void setCollectionLocation(String collectionLocation) {
		this.collectionLocation = collectionLocation;
	}

	public String getPreservationMethod() {
		return preservationMethod;
	}

	public void setPreservationMethod(String preservationMethod) {
		this.preservationMethod = preservationMethod;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public Specimen() {
	}

	public Specimen(int specimenId, int patientId, String specimenType, String collectionDate, String collectionLocation, String preservationMethod, String storageLocation) {
		this.specimenId = specimenId;
		this.patientId = patientId;
		this.specimenType = specimenType;
		this.collectionDate = collectionDate;
		this.collectionLocation = collectionLocation;
		this.preservationMethod = preservationMethod;
		this.storageLocation = storageLocation;
	}

	@Override
	public String toString() {
		return "Specimen{" +
				"specimenId=" + specimenId +
				", patientId=" + patientId +
				", specimenType='" + specimenType + '\'' +
				", collectionDate='" + collectionDate + '\'' +
				", collectionLocation='" + collectionLocation + '\'' +
				", preservationMethod='" + preservationMethod + '\'' +
				", storageLocation='" + storageLocation + '\'' +
				'}';
	}
}
