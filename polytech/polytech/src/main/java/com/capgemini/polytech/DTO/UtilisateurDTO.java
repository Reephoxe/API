package com.capgemini.polytech.DTO;

import lombok.*;

import java.util.List;

/**
 * DTO représentant un utilisateur.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Data
public class UtilisateurDTO {

    /**
     * Identifiant unique de l'utilisateur.
     */
    private Integer id;

    /**
     * Nom de l'utilisateur.
     */
    private String nom;

    /**
     * Prénom de l'utilisateur.
     */
    private String prenom;

    /**
     * Adresse email de l'utilisateur.
     */
    private String mail;

    /**
     * Nom d'utilisateur choisi par l'utilisateur.
     */
    private String username;

    /**
     * Liste des réservations associées à l'utilisateur.
     */
    private List<ReservationDTO> reservations;
}
