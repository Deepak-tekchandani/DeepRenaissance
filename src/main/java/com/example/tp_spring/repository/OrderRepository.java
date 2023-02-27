package com.example.tp_spring.repository;
import com.example.tp_spring.modele.Client;
import com.example.tp_spring.modele.Order;
import com.example.tp_spring.modele.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> {
        @Override
    Order save(Order order);
    @Override
    void deleteById(Long id);
    @Override
    Order getOne(Long id);
    @Override
    List<Order> findAll();
    List<Order> findOrderByOrderNumber(String orderNumber);
    List<Order> findByClient(Client client);




}