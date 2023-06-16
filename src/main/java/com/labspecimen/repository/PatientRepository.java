package com.labspecimen.repository;

import com.labspecimen.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    void deletePatientByPatientId(int patientId);

    Patient findPatientByPatientId(int patientId);


    Patient findRecordByPatientId(int patientId);
}
