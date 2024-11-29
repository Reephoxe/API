package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Jeu;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.exception.JeuNotFoundException;
import com.capgemini.polytech.exception.ReservationNotFoundException;
import com.capgemini.polytech.repository.JeuRepository;
import com.capgemini.polytech.repository.ReservationRepository;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final JeuRepository jeuRepository;
    private final UtilisateurRepository utilisateurRepository;

    public ReservationService(ReservationRepository reservationRepository, JeuRepository jeuRepository, UtilisateurRepository utilisateurRepository) {
        this.reservationRepository = reservationRepository;
        this.jeuRepository = jeuRepository;
        this.utilisateurRepository = utilisateurRepository;
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

    public Reservation updateReservation(Integer id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));;
            //existingReservation.setJeux(jeuRepository.getById());
            //existingReservation.setUtilisateur(utilisateurRepository.getById(updatedReservation.getUtilisateur().getId()));
            return this.reservationRepository.save(existingReservation);
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