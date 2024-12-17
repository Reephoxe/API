package com.capgemini.polytech.DTO;

import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.exception.JeuxNotFoundException;
import com.capgemini.polytech.exception.UtilisateurNotFoundException;
import com.capgemini.polytech.repository.JeuxRepository;
import com.capgemini.polytech.repository.UtilisateurRepository;
import lombok.*;

/**
 * DTO pour les informations des réservations.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Data
public class ReservationDTO {

    /**
     * Identifiant de l'utilisateur qui a effectué la réservation.
     */
    private Integer utilisateur_id;

    /**
     * Nom complet de l'utilisateur (nom et prénom).
     */
    private String utilisateur_nom;

    /**
     * Identifiant du jeu associé à la réservation.
     */
    private Integer jeux_id;

    /**
     * Nom du jeu associé à la réservation.
     */
    private String jeux_nom;

    /**
     * Quantité réservés.
     */
    private Integer reservation;

    /**
     * Constructeur qui permet d'initialiser un {@link ReservationDTO} à partir des entités et du {@link ReservationCreationDTO}.
     *
     * @param jeuxRepository           Le repository pour accéder aux informations des jeux.
     * @param utilisateurRepository    Le repository pour accéder aux informations des utilisateurs.
     * @param reservationCreationDTO   Le DTO contenant les données de création de réservation.
     * @throws JeuxNotFoundException         Si le jeu avec l'ID fourni n'existe pas.
     * @throws UtilisateurNotFoundException  Si l'utilisateur avec l'ID fourni n'existe pas.
     */
    public ReservationDTO(JeuxRepository jeuxRepository,
                          UtilisateurRepository utilisateurRepository,
                          ReservationCreationDTO reservationCreationDTO) {
        this.jeux_id = reservationCreationDTO.getJeux_id();

        //On récupere le nom du jeu grâce à l'id
        this.jeux_nom = jeuxRepository.findById(this.jeux_id)
                .orElseThrow(() -> new JeuxNotFoundException(this.jeux_id))
                .getNom();

        this.utilisateur_id = reservationCreationDTO.getUtilisateur_id();
        Utilisateur utilisateur = utilisateurRepository.findById(this.utilisateur_id)
                .orElseThrow(() -> new UtilisateurNotFoundException(this.utilisateur_id));

        //On récupere le nom de l'utilisateur en concaténant le nom et le prénom
        this.utilisateur_nom = utilisateur.getNom() + " " + utilisateur.getPrenom();

        this.reservation = reservationCreationDTO.getReservation();
    }
}
