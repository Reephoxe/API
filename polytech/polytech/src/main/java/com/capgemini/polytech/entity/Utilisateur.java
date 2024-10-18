package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer utilisateurId;

    @Column(name="nom", length=50, nullable=false, unique=false)
    private String nom;

    @Column(name="prenom", length=50, nullable=false, unique=false)
    private String prenom;

    @Column(name="mail", length=50, nullable=false, unique=false)
    private String mail;

    @Column(name="password", length=50, nullable=false, unique=false)
    private String password;

    @Column(name="username", length=50, nullable=false, unique=false)
    private String username;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
}

