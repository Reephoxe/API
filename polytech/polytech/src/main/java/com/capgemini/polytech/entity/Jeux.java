package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité représentant un jeu dans la base de données.
 * Contient les informations relatives à un jeu, y compris son nom, sa quantité, sa description et ses points géographiques.
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "jeux")
public class Jeux {

    /**
     * Identifiant unique du jeu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nom du jeu.
     * Ne peut pas être nul.
     */
    @NonNull
    @Column(name="nom", length=50, nullable=false, unique=false)
    private String nom;

    /**
     * Quantité disponible du jeu.
     * Ne peut pas être nulle.
     */
    @NonNull
    @Column(name="quantite", length=50, nullable=false, unique=false)
    private int quantite;

    /**
     * Description du jeu.
     * Ne peut pas être nulle.
     */
    @NonNull
    @Column(name="description", length=50, nullable=false, unique=false)
    private String description;

    /**
     * Point géographique associé au jeu.
     * Ne peut pas être nul.
     */
    @NonNull
    @Column(name="point_geo", length=50, nullable=false, unique=false)
    private String point_geo;
}
