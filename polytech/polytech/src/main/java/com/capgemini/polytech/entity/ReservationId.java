package com.capgemini.polytech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ReservationId {
    @Column(name="jeux_id", length=50, nullable=false, unique=false)
    private Integer jeux_id;

    @Column(name="utilisateur_id", length=50, nullable=false, unique=false)
    private Integer utilisateur_id;

    public ReservationId(Integer utilisateurId, Integer jeuxId) {
        this.utilisateur_id = utilisateurId;
        this.jeux_id = jeuxId;
    }

    public ReservationId() {
    }
}
