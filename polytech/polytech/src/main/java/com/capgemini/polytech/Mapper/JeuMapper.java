package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.JeuDTO;
import com.capgemini.polytech.entity.Jeu;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface JeuMapper {

    JeuDTO toDTO(Jeu jeu);

    Jeu toEntity(JeuDTO jeuDTO);
}
