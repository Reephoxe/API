package com.capgemini.polytech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class Reservation {
    @EmbeddedId
    private ReservationId reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false, insertable=false, updatable=false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jeux_id", nullable = false, insertable=false, updatable=false)//jeux_id
    private Jeux jeux;

    @Column(name="reservation", length=50, nullable=false, unique=false)
    private int reservation;
}
