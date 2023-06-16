package com.labspecimen.controller;

import com.labspecimen.model.Specimen;
import com.labspecimen.service.SpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SpecimenController{

    @Autowired
    private SpecimenService specimenService;

    @GetMapping("/addSpecimen")
    public ModelAndView addSpecimen() {
        return specimenService.addSpecimen();
    }

    @PostMapping("/saveSpecimen")
    public ModelAndView saveSpecimen(Specimen specimen) {
        return specimenService.saveSpecimen(specimen);
    }

    @GetMapping("/updateSpecimen")
    public ModelAndView updatePatient() {
        return specimenService.updateSpecimen();
    }

    @PostMapping("/updateSpecimenBySpecimenId")
    public ModelAndView updateSpecimenByPatientId(int specimenId, int patientId, String specimenType, String collectionDate, String collectionLocation, String preservationMethod, String storageLocation) {
        return specimenService.updateSpecimenBySpecimenId(specimenId, patientId, specimenType, collectionDate, collectionLocation, preservationMethod, storageLocation);
    }

    @GetMapping("/deleteSpecimen")
    public ModelAndView deleteSpecimen() {
        return specimenService.deleteSpecimen();
    }

    @PostMapping("/deleteSpecimenBySpecimenId")
    public ModelAndView deleteSpecimenBySpecimenId(int specimenId) {
        return specimenService.deleteSpecimenBySpecimenId(specimenId);
    }

    @GetMapping("/findSpecimen")
    public ModelAndView findSpecimen() {
        return specimenService.findSpecimen();
    }

    @GetMapping("/findSpecimenBySpecimenId")
    public ModelAndView findSpecimenBySpecimenId(int specimenId, Model model) {
        return specimenService.findSpecimenBySpecimenId(specimenId, model);
    }

}
