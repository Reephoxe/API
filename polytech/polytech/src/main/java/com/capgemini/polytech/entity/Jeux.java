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
@Table(name = "jeux")
public class Jeux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name="nom", length=50, nullable=false, unique=false)
    private String nom;

    @NonNull
    @Column(name="quantite", length=50, nullable=false, unique=false)
    private int quantite;

    @NonNull
    @Column(name="description", length=50, nullable=false, unique=false)
    private String description;

    @NonNull
    @Column(name="point_geo", length=50, nullable=false, unique=false)
    private String point_geo;
}
