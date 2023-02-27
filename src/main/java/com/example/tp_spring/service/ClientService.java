package com.example.tp_spring.service;

import com.example.tp_spring.modele.Client;
import com.example.tp_spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> listsAll() {

        return clientRepository.findAll();
    }



    public Client get(Long id) {
        return clientRepository.findById(id).get();
    }


    public Client save(Client client) {
        clientRepository.save(client);
        return client;
    }


    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> findByLastName(String lastName) {
        return clientRepository.findByLastName(lastName);
    }

    public List<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public List<Client> findByLastNameAndEmail(String lastName, String email) {
        return clientRepository.findByLastNameAndEmail(lastName, email);
    }
}
