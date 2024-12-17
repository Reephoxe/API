package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Entité représentant un utilisateur dans la base de données.
 * Contient les informations relatives à un utilisateur, y compris son nom, prénom, email, mot de passe, et ses réservations.
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "utilisateur")
public class Utilisateur {

    /**
     * Identifiant unique de l'utilisateur.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nom de l'utilisateur.
     * Ne peut pas être nul.
     */
    @Column(name="nom", length=50, nullable=false, unique=false)
    private String nom;

    /**
     * Prénom de l'utilisateur.
     * Ne peut pas être nul.
     */
    @Column(name="prenom", length=50, nullable=false, unique=false)
    private String prenom;

    /**
     * Adresse email de l'utilisateur.
     * Ne peut pas être nulle.
     */
    @Column(name="mail", length=50, nullable=false, unique=false)
    private String mail;

    /**
     * Mot de passe de l'utilisateur.
     * Ne peut pas être nul.
     */
    @Column(name="password", length=50, nullable=false, unique=false)
    private String password;

    /**
     * Nom d'utilisateur choisi par l'utilisateur.
     * Ne peut pas être nul.
     */
    @Column(name="username", length=50, nullable=false, unique=false)
    private String username;

    /**
     * Liste des réservations associées à l'utilisateur.
     * Relation one-to-many avec la table "reservation".
     */
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
}
