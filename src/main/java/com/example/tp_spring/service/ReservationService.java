package com.example.tp_spring.service;

import com.example.tp_spring.modele.Reservation;
import com.example.tp_spring.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> listsAll() {
        return reservationRepository.findAll();
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public Reservation get(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }


    public List<Reservation> findByStartDate(Date startDate) {
        return reservationRepository.findByStartDate(startDate);
    }

    public List<Reservation> findByEndDate(Date endDate) {
        return reservationRepository.findByEndDate(endDate);
    }



}
