package com.scholaholiday.scholaholiday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HebergementController {

    @Autowired
    private HebergementRepository hebergementRepository;

    @GetMapping("/addhebergement")
    public String addHebergement(Hebergement hebergement) {
        return "add-hebergement";
    }

    @GetMapping("/viewallhebergements")
    public String allReservations(Reservation reservation, Model model) {
        model.addAttribute("hebergements",hebergementRepository.findAll());
        return "ListeHebergements";
    }

    @PostMapping("/addhebergement")
    public String addingHebergement(Hebergement hebergement, BindingResult result) {
        hebergementRepository.save(hebergement);
        return "redirect:/addhebergement";
    }

}