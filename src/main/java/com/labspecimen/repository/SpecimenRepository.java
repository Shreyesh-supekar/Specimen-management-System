package com.labspecimen.repository;


import com.labspecimen.model.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen,Long> {

	Specimen findSpecimenBySpecimenId(int specimenId);

	void deleteSpecimenBySpecimenId(int specimenId);

	Specimen findRecordByPatientId(int patientId);

}
