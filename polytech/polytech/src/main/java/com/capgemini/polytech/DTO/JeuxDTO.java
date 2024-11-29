package com.capgemini.polytech.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Data
public class JeuxDTO {
    private Integer id;
    private String nom;
    private int quantite;
    private String description;
    private String point_geo;
}
