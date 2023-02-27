package com.example.tp_spring;

import com.example.tp_spring.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TpSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpSpringApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the client to delete:");
        Long clientId = scanner.nextLong();

        ClientService clientService = new ClientService();
        clientService.delete(clientId);

        System.out.println("Client with id " + clientId + " deleted successfully.");
    }
}
