package com.capgemini.polytech.DTO;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Data
public class UtilisateurDTO {

    private Integer id;

    private String nom;

    private String prenom;

    private String mail;

    private String username;

    private List<ReservationDTO> reservations;
}

