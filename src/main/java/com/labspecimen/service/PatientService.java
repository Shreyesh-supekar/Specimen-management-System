package com.labspecimen.service;

import com.labspecimen.model.Patient;
import com.labspecimen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    public ModelAndView addPatient() {
        return new ModelAndView("add-patient.html");
    }

    public ModelAndView savePatient(Patient patient) {
        patientRepo.save(patient);
        return new ModelAndView("add-patient.html");
    }

    public ModelAndView updatePatient() {
        ModelAndView mv = new ModelAndView("update-patient.html");
        return mv;
    }

    public ModelAndView updatePatientByPatientId(int patientId, String patientName, int patientAge, double patientHeight, double patientWeight, String patientBlood, String patientAddress, long patientPhone) {
        Optional<Patient> optionalPatient = Optional.ofNullable(patientRepo.findPatientByPatientId(patientId));
        try {
            if (optionalPatient.isPresent()) {
                Patient patient = optionalPatient.get();
                patient.setPatientName(patientName);
                patient.setPatientAge(patientAge);
                patient.setPatientHeight(patientHeight);
                patient.setPatientWeight(patientWeight);
                patient.setPatientBlood(patientBlood);
                patient.setPatientAddress(patientAddress);
                patient.setPatientPhone(patientPhone);
                patientRepo.save(patient);
            } else {
                throw new IllegalArgumentException("Patient with id " + patientId + " not found.");
            }
        } catch (Exception e) {
            return new ModelAndView("error.html");
        }

        return new ModelAndView("update-patient.html");
    }

    public ModelAndView deletePatient() {
        return new ModelAndView("delete-patient.html");
    }

    @Transactional

    public ModelAndView deletePatientByPatientId(int patientId) {
        Optional<Patient> optionalPatient = Optional.ofNullable(patientRepo.findPatientByPatientId(patientId));
        System.out.println(optionalPatient);
        try {
            if (optionalPatient.isPresent()) {
                patientRepo.deletePatientByPatientId(patientId);
                return new ModelAndView("delete-patient.html");
            } else {
                throw new IllegalArgumentException("Patient with id " + patientId + " not found.");
            }
        } catch (Exception e) {
            return new ModelAndView("error.html");
        }
    }

    public ModelAndView findPatient() {
        return new ModelAndView("find-patient.html");
    }

    public ModelAndView findPatientByPatientId(int patientId, Model model) {
        Optional<Patient> optionalPatient = Optional.ofNullable(patientRepo.findPatientByPatientId(patientId));
        try {
            if (patientId == 0) {
                model.addAttribute("findPatientByPatientId", patientRepo.findAll());
            } else if (optionalPatient.isPresent()) {
                model.addAttribute("findPatientByPatientId", patientRepo.findPatientByPatientId(patientId));
            } else {
                throw new IllegalArgumentException("Patient with id " + patientId + " not found.");
            }
        } catch (Exception e) {
            return new ModelAndView("error.html");
        }
        return new ModelAndView("find-patient.html");
    }


}
