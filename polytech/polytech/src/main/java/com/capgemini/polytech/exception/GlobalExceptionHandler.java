package com.capgemini.polytech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Gestionnaire global des exceptions pour l'application.
 * Cette classe capture les exceptions spécifiques et renvoie une réponse appropriée avec le code HTTP correspondant.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Gère les exceptions {@link JeuxNotFoundException}.
     * Retourne une réponse avec le message d'erreur et un code HTTP 404 (NOT_FOUND).
     *
     * @param ex L'exception déclenchée.
     * @return La réponse avec le message d'erreur et le code HTTP.
     */
    @ExceptionHandler(JeuxNotFoundException.class)
    public ResponseEntity<String> handleJeuNotFoundException(JeuxNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Gère les exceptions {@link ReservationNotFoundException}.
     * Retourne une réponse avec le message d'erreur et un code HTTP 404 (NOT_FOUND).
     *
     * @param ex L'exception déclenchée.
     * @return La réponse avec le message d'erreur et le code HTTP.
     */
    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<String> handleReservationNotFoundException(ReservationNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Gère les exceptions {@link UtilisateurNotFoundException}.
     * Retourne une réponse avec le message d'erreur et un code HTTP 404 (NOT_FOUND).
     *
     * @param ex L'exception déclenchée.
     * @return La réponse avec le message d'erreur et le code HTTP.
     */
    @ExceptionHandler(UtilisateurNotFoundException.class)
    public ResponseEntity<String> handleUtilisateurNotFoundException(UtilisateurNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Gère toutes les autres exceptions générales.
     * Retourne une réponse avec un message d'erreur générique et un code HTTP 500 (INTERNAL_SERVER_ERROR).
     *
     * @param ex L'exception générale déclenchée.
     * @return La réponse avec un message d'erreur générique et le code HTTP.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("Une erreur a eu lieu : " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
