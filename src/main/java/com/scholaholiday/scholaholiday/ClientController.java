package com.scholaholiday.scholaholiday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/addclient")
    public String addClient(Client client, Model model) {
        model.addAttribute("clients",clientRepository.findAll());
        return "add-reservationClient";
    }

    @PostMapping("/addclient")
    public String addingClient(Client client, BindingResult result) {
        clientRepository.save(client);
        return "redirect:/addclient";
    }

    @GetMapping("/client/{id}")
    public String getClientById(@PathVariable int id, Model model) {
        model.addAttribute("reservation", clientRepository.findById(id).get());
        return "editClient";
    }

    @PostMapping("/editclient/{id}")
    public String editReservation(Client client, @PathVariable int id) {
        client.setId(id);
        clientRepository.save(client);
        return "redirect:/addclient";
    }

    @PostMapping("/deleteclient/{id}")
    public String deleteClient(@PathVariable int id) {
        clientRepository.deleteById(id);
        return "redirect:/addclient";

    }

}
