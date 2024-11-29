package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.exception.ReservationNotFoundException;
import com.capgemini.polytech.repository.JeuxRepository;
import com.capgemini.polytech.repository.ReservationRepository;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final JeuxRepository jeuxRepository;
    private final UtilisateurRepository utilisateurRepository;

    public ReservationService(ReservationRepository reservationRepository, JeuxRepository jeuxRepository, UtilisateurRepository utilisateurRepository) {
        this.reservationRepository = reservationRepository;
        this.jeuxRepository = jeuxRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Reservation> getList() {
        return reservationRepository.findAll();
    }

    public Reservation getById(ReservationId id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    public Reservation createReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    public Reservation updateReservation(ReservationId id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));;
            existingReservation.setJeux(updatedReservation.getJeux());
            existingReservation.setUtilisateur(updatedReservation.getUtilisateur());
            existingReservation.setReservation(updatedReservation.getReservation());
            existingReservation.setReservationId(updatedReservation.getReservationId());
            return this.reservationRepository.save(existingReservation);
    }

    public void deleteReservation(ReservationId id) {
        this.reservationRepository.findById(id).map(
                e -> {
                    this.reservationRepository.delete(e);
                    return e;
                }
        ).orElseThrow(() -> new ReservationNotFoundException(id));
    }


}