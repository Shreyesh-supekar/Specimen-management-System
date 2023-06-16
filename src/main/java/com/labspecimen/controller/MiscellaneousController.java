package com.labspecimen.controller;

import com.labspecimen.service.MiscellaneousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MiscellaneousController {

    @Autowired
    private MiscellaneousService miscellaneousService;

    @GetMapping("/homepage")
    public ModelAndView homepage(Model model) {
        return miscellaneousService.homePage(model);
    }

    @GetMapping("/findRecord")
    public ModelAndView findRecord() {
        return miscellaneousService.findRecord();
    }

    @GetMapping("/findRecordByPatientId")
    public ModelAndView findRecordByPatientId(int patientId, Model model) {
        return miscellaneousService.findRecordByPatientId(patientId, model);
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return miscellaneousService.login();
    }


}
