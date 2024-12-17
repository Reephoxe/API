package com.capgemini.polytech.DTO;

import lombok.*;

/**
 * DTO représentant les informations essentielles d'un jeu.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Data
public class JeuxDTO {
    /**
     * Identifiant unique du jeu.
     */
    private Integer id;

    /**
     * Nom du jeu.
     */
    private String nom;

    /**
     * Quantité disponible pour le jeu.
     */
    private int quantite;

    /**
     * Description détaillée du jeu.
     */
    private String description;

    /**
     * Position géographique ou localisation associée au jeu.
     */
    private String point_geo;
}
