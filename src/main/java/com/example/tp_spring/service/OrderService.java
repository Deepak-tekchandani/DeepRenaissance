package com.example.tp_spring.service;

import com.example.tp_spring.modele.Client;
import com.example.tp_spring.modele.Order;
import com.example.tp_spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // Récupérer la liste de toutes les commandes
    public List<Order> listsAll() {
        return orderRepository.findAll();
    }

    // Enregistrer une nouvelle commande
    public void save(Order order) {
        orderRepository.save(order);
    }

    // Récupérer une commande par son identifiant
    public Order get(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Supprimer une commande par son identifiant
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    // Récupérer les commandes d'un client
    public List<Order> getOrdersByClient(Long clientId) {
        Client client = new Client();
        client.setId(clientId);
        return orderRepository.findByClient(client);
    }


    public List<Order> findByClient(Client client) {
        return orderRepository.findByClient(client);
    }



}
