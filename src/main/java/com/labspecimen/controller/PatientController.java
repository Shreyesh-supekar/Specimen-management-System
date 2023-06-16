package com.labspecimen.controller;

import com.labspecimen.model.Patient;
import com.labspecimen.repository.PatientRepository;
import com.labspecimen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private PatientService patientService;

    @GetMapping("/addPatient")
    public ModelAndView addPatient() {
        return patientService.addPatient();
    }

    @PostMapping("/savePatient")
    public ModelAndView savePatient(Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/updatePatient")
    public ModelAndView updatePatient() {
        return patientService.updatePatient();
    }

    @PostMapping("/updatePatientByPatientId")
    public ModelAndView updatePatientByPatientId(int patientId, String patientName, int patientAge, double patientWeight, double patientHeight, String patientBlood, String patientAddress, long patientPhone) {
        return patientService.updatePatientByPatientId(patientId, patientName, patientAge, patientHeight, patientWeight, patientBlood, patientAddress, patientPhone);
    }

    @GetMapping("/deletePatient")
    public ModelAndView deletePatient() {
        return patientService.deletePatient();
    }

    @PostMapping("/deletePatientByPatientId")
    public ModelAndView deletePatientByPatientId(int patientId) {
        return patientService.deletePatientByPatientId(patientId);
    }

    @GetMapping("/findPatient")
    public ModelAndView findPatient() {
        return patientService.findPatient();
    }

    @GetMapping("/findPatientByPatientId")
    public ModelAndView findPatientByPatientId(int patientId, Model model) {
        return patientService.findPatientByPatientId(patientId, model);
    }
}
