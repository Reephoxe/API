package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.UtilisateurCreationDTO;
import com.capgemini.polytech.DTO.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurDTO toDTO(Utilisateur utilisateur);

    UtilisateurCreationDTO toDTOCreation(Utilisateur utilisateur);

    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);

    Utilisateur toEntity(UtilisateurCreationDTO utilisateurCreationDTO);
}