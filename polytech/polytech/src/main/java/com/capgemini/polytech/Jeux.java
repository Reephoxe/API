package com.capgemini.polytech;

import jakarta.persistence.*;

@Entity
@Table(name = "jeux")
public class Jeux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jeuxId ;

    @Column(name="NOM", length=50, nullable=false, unique=false)
    private String nom;

    @Column(name="QUANTITE", length=50, nullable=false, unique=false)
    private int quantite;

    @Column(name="DESCRIPTION", length=50, nullable=false, unique=false)
    private String description;

    @Column(name="POINT_GEO", length=50, nullable=false, unique=false)
    private String point_geo;

    public int getJeuxId() {
        return jeuxId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setJeuxId(int jeuxId) {
        this.jeuxId = jeuxId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoint_geo() {
        return point_geo;
    }

    public void setPoint_geo(String point_geo) {
        this.point_geo = point_geo;
    }
}
