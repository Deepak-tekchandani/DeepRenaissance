package com.example.tp_spring.repository;

import com.example.tp_spring.modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findProductByLastName(String last_name);
    List<Client> findByLastName(String lastName);
    List<Client> findByEmail(String email);
    List<Client> findByLastNameAndEmail(String lastName, String email);
}
