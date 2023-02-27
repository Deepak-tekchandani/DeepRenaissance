package com.example.tp_spring.modele;


import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

    @Transient
    private Product product;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    public Reservation() {
    }

    public Reservation(Long id, Client client, Product product, Date startDate, Date endDate) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Reservation(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;

    }
    // other fields and methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", client=" + client +
                ", product=" + product +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
