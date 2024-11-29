package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.JeuxDTO;
import com.capgemini.polytech.entity.Jeux;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface JeuxMapper {

    JeuxDTO toDTO(Jeux jeux);

    Jeux toEntity(JeuxDTO jeuxDTO);
}
