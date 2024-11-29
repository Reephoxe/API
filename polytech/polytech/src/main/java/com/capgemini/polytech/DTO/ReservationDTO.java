package com.capgemini.polytech.DTO;

import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.exception.JeuxNotFoundException;
import com.capgemini.polytech.exception.UtilisateurNotFoundException;
import com.capgemini.polytech.repository.JeuxRepository;
import com.capgemini.polytech.repository.UtilisateurRepository;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Data
public class ReservationDTO {
    private Integer utilisateur_id;
    private String utilisateur_nom;
    private Integer jeux_id;
    private String jeux_nom;
    private Integer reservation;

    ReservationDTO(JeuxRepository jeuxRepository, UtilisateurRepository utilisateurRepository, ReservationCreationDTO reservationCreationDTO) {
        this.jeux_id = reservationCreationDTO.getJeux_id();
        this.jeux_nom = jeuxRepository.findById(this.jeux_id).orElseThrow(() -> new JeuxNotFoundException(this.jeux_id)).getNom();
        this.utilisateur_id = reservationCreationDTO.getUtilisateur_id();

        Utilisateur utilisateur = utilisateurRepository.findById(this.utilisateur_id).orElseThrow(() -> new UtilisateurNotFoundException(this.utilisateur_id));
        this.utilisateur_nom = utilisateur.getNom()+" "+utilisateur.getPrenom();
        this.reservation = reservationCreationDTO.getReservation();
    }
}
