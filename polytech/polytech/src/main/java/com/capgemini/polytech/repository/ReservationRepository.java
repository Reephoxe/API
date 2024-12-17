package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour accéder aux données de l'entité {@link Reservation}.
 * Fournit des opérations CRUD (Create, Read, Update, Delete) sur l'entité {@link Reservation}.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
