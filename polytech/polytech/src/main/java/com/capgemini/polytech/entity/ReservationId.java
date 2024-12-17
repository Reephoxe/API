package com.capgemini.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * Clé composite pour l'entité {@link Reservation}.
 * Utilisée pour identifier de manière unique une réservation, en combinant l'ID de l'utilisateur et l'ID du jeu réservé.
 */
@Getter
@Setter
@Embeddable
public class ReservationId {

    /**
     * Identifiant du jeu réservé.
     * Ne peut pas être nul.
     */
    @Column(name="jeux_id", length=50, nullable=false, unique=false)
    private Integer jeux_id;

    /**
     * Identifiant de l'utilisateur ayant effectué la réservation.
     * Ne peut pas être nul.
     */
    @Column(name="utilisateur_id", length=50, nullable=false, unique=false)
    private Integer utilisateur_id;

    /**
     * Constructeur avec paramètres pour initialiser la clé composite.
     *
     * @param utilisateurId L'identifiant de l'utilisateur.
     * @param jeuxId L'identifiant du jeu réservé.
     */
    public ReservationId(Integer utilisateurId, Integer jeuxId) {
        this.utilisateur_id = utilisateurId;
        this.jeux_id = jeuxId;
    }

    /**
     * Constructeur sans paramètres.
     * Nécessaire pour la persistance de l'entité dans la base de données.
     */
    public ReservationId() {
    }
}
