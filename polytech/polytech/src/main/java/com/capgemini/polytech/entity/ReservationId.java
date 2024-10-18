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
    private Integer jeuxId;

    @Column(name="utilisateur_id", length=50, nullable=false, unique=false)
    private Integer utilisateurId;
}
