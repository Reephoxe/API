package com.capgemini.polytech.exception;

public class ReservationNotFoundException extends RuntimeException{

    public ReservationNotFoundException(Integer id) {
        super("Réservation avec l'ID "+id+ " pas trouvé");
    }
}
