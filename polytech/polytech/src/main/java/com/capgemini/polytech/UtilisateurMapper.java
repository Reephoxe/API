package com.capgemini.polytech;

import com.capgemini.polytech.Utilisateur;
import com.capgemini.polytech.UtilisateurDTO;
import com.capgemini.polytech.ReservationDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UtilisateurMapper {

    // Convertir un Utilisateur en UtilisateurDTO
    public static UtilisateurDTO toDTO(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(utilisateur.getUtilisateurId());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setMail(utilisateur.getMail());
        dto.setUsername(utilisateur.getUsername());

        // Convertir la liste de réservations en DTO
        dto.setReservations(utilisateur.getReservations().stream().map(ReservationMapper::toDTO).collect(Collectors.toList()));

        return dto;
    }

    // Convertir un UtilisateurDTO en Utilisateur
    public static Utilisateur toEntity(UtilisateurDTO dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setMail(dto.getMail());
        utilisateur.setUsername(dto.getUsername());

        // Convertir la liste de ReservationDTO en entités Reservation
        utilisateur.setReservations(dto.getReservations().stream()
                .map(ReservationMapper::toEntity) // Utilise un Mapper pour les réservations
                .collect(Collectors.toList()));

        return utilisateur;
    }
}
