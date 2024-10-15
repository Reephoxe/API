package com.capgemini.polytech;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name="UTILISATEUR_ID", length=50, nullable=false, unique=false)
    private int utilisateur_id;

    @Id
    @Column(name="JEUX_ID", length=50, nullable=false, unique=false)
    private int jeux_id;

    @Column(name="RESERVATION", length=50, nullable=false, unique=false)
    private int reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateurId", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jeuxId", nullable = false)//jeux_id
    private Utilisateur jeux;

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getJeux_id() {
        return jeux_id;
    }

    public void setJeux_id(int jeux_id) {
        this.jeux_id = jeux_id;
    }

    public int getReservation() {
        return reservation;
    }

    public void setReservation(int reservation) {
        this.reservation = reservation;
    }
}
