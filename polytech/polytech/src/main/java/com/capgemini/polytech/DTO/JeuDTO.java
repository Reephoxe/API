package com.capgemini.polytech.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Data
public class JeuDTO {
    private Integer id;
    private String nom;
    private int quantite;
    private String description;
    private String point_geo;
}
