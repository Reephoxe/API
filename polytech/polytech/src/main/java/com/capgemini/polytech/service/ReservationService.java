package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.exception.ReservationNotFoundException;
import com.capgemini.polytech.repository.JeuxRepository;
import com.capgemini.polytech.repository.ReservationRepository;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service pour la gestion des réservations dans l'application.
 * Fournit des méthodes pour récupérer, créer, mettre à jour et supprimer des réservations.
 */
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    /**
     * Constructeur pour initialiser le service avec les repositories nécessaires.
     *
     * @param reservationRepository Le repository pour accéder aux données des réservations.
     */
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * Récupère la liste de toutes les réservations.
     *
     * @return Une liste de {@link Reservation}.
     */
    public List<Reservation> getList() {
        return reservationRepository.findAll();
    }

    /**
     * Récupère une réservation par son ID.
     * Si la réservation n'est pas trouvée, une exception {@link ReservationNotFoundException} est levée.
     *
     * @param id L'ID de la réservation à récupérer.
     * @return La réservation correspondant à l'ID.
     * @throws ReservationNotFoundException Si la réservation n'est pas trouvée.
     */
    public Reservation getById(ReservationId id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    /**
     * Crée une nouvelle réservation dans la base de données.
     *
     * @param reservation L'objet {@link Reservation} à créer.
     * @return La réservation créée.
     */
    public Reservation createReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    /**
     * Met à jour les informations d'une réservation existante.
     * Si la réservation n'est pas trouvée, une exception {@link ReservationNotFoundException} est levée.
     *
     * @param id L'ID de la réservation à mettre à jour.
     * @param updatedReservation L'objet {@link Reservation} contenant les nouvelles informations.
     * @return La réservation mise à jour.
     * @throws ReservationNotFoundException Si la réservation n'est pas trouvée.
     */
    public Reservation updateReservation(ReservationId id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));

        // Mise à jour des informations de la réservation existante
        existingReservation.setJeux(updatedReservation.getJeux());
        existingReservation.setUtilisateur(updatedReservation.getUtilisateur());
        existingReservation.setReservation(updatedReservation.getReservation());
        existingReservation.setReservationId(updatedReservation.getReservationId());

        // Sauvegarde des changements dans la base de données
        return this.reservationRepository.save(existingReservation);
    }

    /**
     * Supprime une réservation de la base de données.
     * Si la réservation n'est pas trouvée, une exception {@link ReservationNotFoundException} est levée.
     *
     * @param id L'ID de la réservation à supprimer.
     * @throws ReservationNotFoundException Si la réservation n'est pas trouvée.
     */
    public void deleteReservation(ReservationId id) {
        this.reservationRepository.findById(id).map(
                e -> {
                    // Suppression de la réservation
                    this.reservationRepository.delete(e);
                    return e;
                }
        ).orElseThrow(() -> new ReservationNotFoundException(id));
    }
}
