package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.UtilisateurDTO;
import com.capgemini.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurDTO toDTO(Utilisateur utilisateur);


    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);
}