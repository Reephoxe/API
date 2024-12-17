package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité représentant une réservation dans la base de données.
 * Contient les informations relatives à une réservation, y compris les relations avec un utilisateur et un jeu.
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class Reservation {

    /**
     * Identifiant composite de la réservation, composé de plusieurs clés primaires (utilisateur_id et jeux_id).
     */
    @EmbeddedId
    private ReservationId reservationId;

    /**
     * Utilisateur ayant effectué la réservation.
     * Relation many-to-one avec la table "utilisateur".
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false, insertable=false, updatable=false)
    private Utilisateur utilisateur;

    /**
     * Jeu réservé par l'utilisateur.
     * Relation many-to-one avec la table "jeux".
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jeux_id", nullable = false, insertable=false, updatable=false)
    private Jeux jeux;

    /**
     * Quantité réservée du jeu.
     * Ne peut pas être nulle.
     */
    @Column(name="reservation", length=50, nullable=false, unique=false)
    private int reservation;
}
