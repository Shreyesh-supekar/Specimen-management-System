package com.labspecimen.service;

import com.labspecimen.model.Specimen;
import com.labspecimen.repository.SpecimenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SpecimenService {

    @Autowired
    private SpecimenRepository specimenRepo;

    public ModelAndView addSpecimen() {
        return new ModelAndView("add-specimen.html");
    }

    public ModelAndView saveSpecimen(Specimen specimen) {
        specimenRepo.save(specimen);
        return new ModelAndView("add-specimen.html");
    }

    public ModelAndView updateSpecimen() {
        return new ModelAndView("update-specimen.html");
    }

    public ModelAndView updateSpecimenBySpecimenId(int specimenId, int patientId, String specimenType, String collectionDate, String collectionLocation, String preservationMethod, String storageLocation) {
        Optional<Specimen> optionalSpecimen = Optional.ofNullable(specimenRepo.findSpecimenBySpecimenId(specimenId));
        try {
            if (optionalSpecimen.isPresent()) {
                Specimen specimen = optionalSpecimen.get();
                specimen.setPatientId(patientId);
                specimen.setSpecimenType(specimenType);
                specimen.setCollectionDate(collectionDate);
                specimen.setCollectionLocation(collectionLocation);
                specimen.setPreservationMethod(preservationMethod);
                specimen.setStorageLocation(storageLocation);

            } else{
                throw new IllegalArgumentException("Specimen with specimen id " + specimenId + " not found.");
            }
        } catch (Exception e) {
            return new ModelAndView("error.html");
        }
        return new ModelAndView("update-specimen.html");
    }

    public ModelAndView deleteSpecimen() {
        ModelAndView mv = new ModelAndView("delete-specimen.html");
        return mv;
    }

    @Transactional
    public ModelAndView deleteSpecimenBySpecimenId(int specimenId) {
        Optional<Specimen> optionalSpecimen = Optional.ofNullable(specimenRepo.findSpecimenBySpecimenId(specimenId));
        try {
            if (optionalSpecimen.isPresent()) {
                specimenRepo.deleteSpecimenBySpecimenId(specimenId);
                return new ModelAndView("delete-specimen.html");
            } else {
                throw new IllegalArgumentException("Specimen with specimen id " + specimenId + " not found.");
            }
        } catch (Exception e) {
            return new ModelAndView("error.html");
        }
    }

    public ModelAndView findSpecimen() {
        return new ModelAndView("find-specimen.html");
    }

    public ModelAndView findSpecimenBySpecimenId(int specimenId, Model model) {
        Optional<Specimen> optionalSpecimen = Optional.ofNullable(specimenRepo.findSpecimenBySpecimenId(specimenId));
        try {
            if (specimenId == 0) {
                model.addAttribute("findSpecimenBySpecimenId", specimenRepo.findAll());
            } else if (optionalSpecimen.isPresent()) {
                model.addAttribute("findSpecimenBySpecimenId", specimenRepo.findSpecimenBySpecimenId(specimenId));
            } else {
                throw new IllegalArgumentException("Specimen with specimen id " + specimenId + " not found.");
            }
        } catch (Exception e) {
            return new ModelAndView("error.html");
        }
        return new ModelAndView("find-specimen.html");
    }

}
