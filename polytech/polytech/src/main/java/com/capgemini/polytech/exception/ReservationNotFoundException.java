package com.capgemini.polytech.exception;

import com.capgemini.polytech.entity.ReservationId;

/**
 * Exception levée lorsque la réservation avec un identifiant spécifique n'est pas trouvée.
 * Cette exception est utilisée pour indiquer qu'une réservation, identifiée par l'ID de l'utilisateur et l'ID du jeu, n'existe pas dans la base de données.
 */
public class ReservationNotFoundException extends RuntimeException {

    /**
     * Constructeur de l'exception avec un identifiant de réservation.
     * Génère un message d'erreur indiquant que la réservation avec les IDs fournis n'a pas été trouvée.
     *
     * @param id L'identifiant composite de la réservation, contenant les IDs de l'utilisateur et du jeu.
     */
    public ReservationNotFoundException(ReservationId id) {
        super("Réservation avec l'ID de l'utilisateur " + id.getUtilisateur_id() +
                " et l'ID du jeu " + id.getJeux_id() + " n'ont pas été trouvé");
    }
}
