package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.UtilisateurCreationDTO;
import com.capgemini.polytech.DTO.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;

/**
 * Mapper pour convertir entre l'entité {@link Utilisateur} et ses différents DTOs {@link UtilisateurDTO} et {@link UtilisateurCreationDTO}.
 */
@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    /**
     * Convertit une entité {@link Utilisateur} en un objet {@link UtilisateurDTO}.
     *
     * @param utilisateur L'entité {@link Utilisateur} à convertir.
     * @return Le DTO {@link UtilisateurDTO} représentant l'entité {@link Utilisateur}.
     */
    UtilisateurDTO toDTO(Utilisateur utilisateur);

    /**
     * Convertit une entité {@link Utilisateur} en un objet {@link UtilisateurCreationDTO}.
     *
     * @param utilisateur L'entité {@link Utilisateur} à convertir.
     * @return Le DTO {@link UtilisateurCreationDTO} représentant l'entité {@link Utilisateur}.
     */
    UtilisateurCreationDTO toDTOCreation(Utilisateur utilisateur);

    /**
     * Convertit un objet {@link UtilisateurDTO} en une entité {@link Utilisateur}.
     *
     * @param utilisateurDTO Le DTO {@link UtilisateurDTO} à convertir.
     * @return L'entité {@link Utilisateur} représentant le DTO {@link UtilisateurDTO}.
     */
    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);

    /**
     * Convertit un objet {@link UtilisateurCreationDTO} en une entité {@link Utilisateur}.
     *
     * @param utilisateurCreationDTO Le DTO {@link UtilisateurCreationDTO} à convertir.
     * @return L'entité {@link Utilisateur} représentant le DTO {@link UtilisateurCreationDTO}.
     */
    Utilisateur toEntity(UtilisateurCreationDTO utilisateurCreationDTO);
}
