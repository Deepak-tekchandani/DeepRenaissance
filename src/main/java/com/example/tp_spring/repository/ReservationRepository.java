package com.example.tp_spring.repository;

import com.example.tp_spring.modele.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationById(Long id);
    List<Reservation> findByStartDate(Date startDate);
    List<Reservation> findByEndDate(Date endDate);
}
