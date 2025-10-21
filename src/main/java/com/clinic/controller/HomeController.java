package com.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("content", "dashboard :: content");
        return "layout";
    }

    // Trang quản lý bệnh nhân
    @GetMapping("/patients")
    public String patientPage(Model model) {
        model.addAttribute("content", "patient :: content");
        return "layout";
    }

    // Trang quản lý bác sĩ
    @GetMapping("/doctors")
    public String doctorPage(Model model) {
        model.addAttribute("content", "doctor :: content");
        return "layout";
    }

    // Trang quản lý lịch hẹn
    @GetMapping("/appointments")
    public String appointmentPage(Model model) {
        model.addAttribute("content", "appointment :: content");
        return "layout";
    }
}
