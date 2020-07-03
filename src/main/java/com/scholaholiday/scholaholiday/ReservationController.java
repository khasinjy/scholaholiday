package com.scholaholiday.scholaholiday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private HebergementRepository hebergementRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/addreservation")
    public String addReservation(Reservation reservation,Model model) {
        model.addAttribute("hebergements",hebergementRepository.findAll());
        model.addAttribute("clients",clientRepository.findAll());
        model.addAttribute("reservations",reservationRepository.findAll());
        return "add-reservationInfos";
    }

    @PostMapping("/addreservation")
    public String addingReservation(Reservation reservation, BindingResult result) {
        reservationRepository.save(reservation);
        return "redirect:/addreservation";
    }

    @GetMapping("/viewallreservations")
    public String allReservations(Reservation reservation,Model model) {
        model.addAttribute("reservations",reservationRepository.findAll());
        return "ListeReservations";
    }

    @GetMapping("/reservation/{id}")
    public String getReservationById(@PathVariable int id, Model model) {
        model.addAttribute("hebergements",hebergementRepository.findAll());
        model.addAttribute("clients",clientRepository.findAll());
        model.addAttribute("reservation", reservationRepository.findById(id).get());
        return "editReservation";
    }

    @PostMapping("/editreservation/{id}")
    public String editReservation(Reservation reservation, @PathVariable int id) {
        reservation.setId(id);
        reservationRepository.save(reservation);
        return "redirect:/reservation/"+id;
    }

    @PostMapping("/deletereservation/{id}")
    public String deleteReservation(@PathVariable int id) {
        reservationRepository.deleteById(id);
        return "redirect:/viewallreservations";

    }
}