package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.JeuxDTO;
import com.capgemini.polytech.entity.Jeux;
import org.mapstruct.Mapper;

/**
 * Mapper pour convertir entre l'entité {@link Jeux} et le DTO {@link JeuxDTO}.
 */
@Mapper(componentModel = "spring")
public interface JeuxMapper {

    /**
     * Convertit une entité {@link Jeux} en un objet {@link JeuxDTO}.
     *
     * @param jeux L'entité {@link Jeux} à convertir.
     * @return Le DTO {@link JeuxDTO} représentant l'entité {@link Jeux}.
     */
    JeuxDTO toDTO(Jeux jeux);

    /**
     * Convertit un objet {@link JeuxDTO} en une entité {@link Jeux}.
     *
     * @param jeuxDTO Le DTO {@link JeuxDTO} à convertir.
     * @return L'entité {@link Jeux} représentant le DTO {@link JeuxDTO}.
     */
    Jeux toEntity(JeuxDTO jeuxDTO);
}
