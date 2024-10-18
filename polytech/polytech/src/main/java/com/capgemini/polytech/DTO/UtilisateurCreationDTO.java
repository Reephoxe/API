package com.capgemini.polytech.DTO;

import com.capgemini.polytech.entity.Reservation;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Data
public class UtilisateurCreationDTO {

    private Integer id;

    private String nom;

    private String prenom;

    private String mail;

    private String username;

    private List<Reservation> reservations;

    private String password;
}
