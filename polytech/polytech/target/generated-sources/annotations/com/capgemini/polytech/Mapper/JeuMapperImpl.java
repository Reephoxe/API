package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.JeuDTO;
import com.capgemini.polytech.entity.Jeu;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class JeuMapperImpl implements JeuMapper {

    @Override
    public JeuDTO toDTO(Jeu jeu) {
        if ( jeu == null ) {
            return null;
        }

        JeuDTO.JeuDTOBuilder jeuDTO = JeuDTO.builder();

        jeuDTO.id( jeu.getId() );
        jeuDTO.nom( jeu.getNom() );
        jeuDTO.quantite( jeu.getQuantite() );
        jeuDTO.description( jeu.getDescription() );
        jeuDTO.point_geo( jeu.getPoint_geo() );

        return jeuDTO.build();
    }

    @Override
    public Jeu toEntity(JeuDTO jeuDTO) {
        if ( jeuDTO == null ) {
            return null;
        }

        Jeu.JeuBuilder jeu = Jeu.builder();

        if ( jeuDTO.getId() != null ) {
            jeu.id( jeuDTO.getId() );
        }
        jeu.nom( jeuDTO.getNom() );
        jeu.quantite( jeuDTO.getQuantite() );
        jeu.description( jeuDTO.getDescription() );
        jeu.point_geo( jeuDTO.getPoint_geo() );

        return jeu.build();
    }
}
