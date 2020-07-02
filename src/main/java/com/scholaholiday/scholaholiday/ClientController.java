package com.scholaholiday.scholaholiday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/addclient")
    public String addClient(Client client) {
        return "add-reservationClient";
    }

    @PostMapping("/addclient")
    public String addingClient(Client client, BindingResult result) {
        clientRepository.save(client);
        return "redirect:/addreservation";
    }

}
