package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
