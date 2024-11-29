package com.capgemini.polytech.exception;

import com.capgemini.polytech.entity.ReservationId;

public class ReservationNotFoundException extends RuntimeException{

    public ReservationNotFoundException(ReservationId id) {
        super("Réservation avec l'ID de l'utilisateur "+id.getUtilisateur_id()+ " et l'ID du jeu "+id.getJeux_id()+" n'ont pas été trouvé");
    }
}
