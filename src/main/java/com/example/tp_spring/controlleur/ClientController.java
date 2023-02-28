package com.example.tp_spring.controlleur;

import com.example.tp_spring.modele.Client;
import com.example.tp_spring.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping("/clients")
    public String list(Model model) {
        model.addAttribute("listClients", clientService.listsAll());

        return "client";
    }

    @GetMapping("/clients/{id}")
    public Client get(@PathVariable Long id , Model model) {
        return clientService.get(id);
    }
    @GetMapping("/clients/filter1")
    public String getBYId(@RequestParam(name="cID", defaultValue="") Long id , Model model) {
        try {
            Client client = clientService.get(id);
            if (client != null) {
                model.addAttribute("listClients",client );
                model.addAttribute("filter1", id);
                System.out.println("==============By ID ==============");
//        return clientService.get(id);
                return "client";
            }
        }catch (Exception e){
            return "client";
        }
        return "client";
    }
    @GetMapping("/clients/getForUpdate/{id}")
    public String getForUpdate(@PathVariable Long id , Model model) {

        Client client =  clientService.get(id);
        model.addAttribute("client", client);
        return "update_client";
    }
    @GetMapping("/clients/new")
    public String showNewRoomForm(Model model)
    {
        //create model attribute to bind Form data
        Client client = new Client();
        model.addAttribute("client", client);
        return "add_client";
    }

    @PostMapping("/clients/save")
    public String createClient(@ModelAttribute("client") @Valid Client client , Errors errors) {
        if (errors.hasErrors())
        {
            return "add_client";
        }
        clientService.save(client);
        return "redirect:/clients";
    }

    @PostMapping("/clients/update")
    public String updateClient(@ModelAttribute("client") @Valid Client updatedClient) {

        Client existingClient = clientService.get(updatedClient.getId());

        existingClient.setFirstName(updatedClient.getFirstName());
        existingClient.setLastName(updatedClient.getLastName());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setTel(updatedClient.getTel());

        clientService.save(existingClient);
        return "redirect:/clients";
    }

    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        try {
            clientService.delete(id);
            return "redirect:/clients";
        }catch (Exception e){
            return "redirect:/clients";

        }
    }

    @GetMapping("/search")
    public List<Client> searchByLastNameAndEmail(@RequestParam String lastName, @RequestParam String email) {
        return clientService.findByLastNameAndEmail(lastName, email);
    }

    @GetMapping("/clients/lastname/filter2")
    public String getByLastName(@RequestParam(name="lastName", defaultValue="") String lastName, Model model) {

//        return clientService.findByLastName(lastName);

        model.addAttribute("listClients", clientService.findByLastName(lastName));
        model.addAttribute("filter2", lastName);
        System.out.println("===========Find By Name==========");
        return "client";
    }
}
