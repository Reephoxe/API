package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.exception.JeuNotFoundException;
import com.capgemini.polytech.exception.ReservationNotFoundException;
import com.capgemini.polytech.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getList() {
        return reservationRepository.findAll();
    }

    public Reservation getById(Integer id) {
        return reservationRepository.findById(id).orElseThrow(() -> new JeuNotFoundException(id));
    }

    public Reservation createReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Integer id, Reservation reservation) {
        return this.reservationRepository.findById(id).map(
                e -> this.reservationRepository.save(reservation)
        ).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    public void deleteReservation(Integer id) {
        this.reservationRepository.findById(id).map(
                e -> {
                    this.reservationRepository.delete(e);
                    return e;
                }
        ).orElseThrow(() -> new JeuNotFoundException(id));
    }


}