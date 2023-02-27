package com.example.tp_spring.modele;


import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order() {}

    public Order(String orderNumber, Client client) {
        this.orderNumber = orderNumber;
        this.client = client;
    }

    public Order(Long id, String orderNumber, Client client) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.client = client;
    }

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", client=" + client +
                '}';
    }
}
