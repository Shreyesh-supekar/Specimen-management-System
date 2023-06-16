package com.labspecimen.service;

import com.labspecimen.model.Patient;
import com.labspecimen.repository.PatientRepository;
import com.labspecimen.repository.SpecimenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Service
public class MiscellaneousService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private SpecimenRepository specimenRepo;

    public ModelAndView homePage(Model model) {

        model.addAttribute("patientCount", patientRepo.count());
        model.addAttribute("specimenCount", specimenRepo.count());

        return new ModelAndView("homepage.html");
    }

    public ModelAndView findRecord() {
        return new ModelAndView("find-record.html");
    }

    public ModelAndView findRecordByPatientId(int patientId, Model model) {
        Optional<Patient> optionalPatient = Optional.ofNullable(patientRepo.findPatientByPatientId(patientId));
        System.out.println(optionalPatient);
        try {
            if(optionalPatient.isPresent() || patientId == 0) {
                if (patientId == 0) {
                    model.addAttribute("findPatientByPatientId", patientRepo.findAll());
                    model.addAttribute("findSpecimenByPatientId", specimenRepo.findAll());
                } else if (patientId > 0) {
                    model.addAttribute("findPatientByPatientId", patientRepo.findRecordByPatientId(patientId));
                    model.addAttribute("findSpecimenByPatientId", specimenRepo.findRecordByPatientId(patientId));
                }
                return new ModelAndView("record.html");
            }
            else
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            return new ModelAndView("error.html");
        }

    }
    public ModelAndView login() {
        return new ModelAndView("login.html");
    }

}
