package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.ReservationCreationDTO;
import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.entity.Jeux;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.service.JeuxService;
import com.capgemini.polytech.service.UtilisateurService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ReservationMapper {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private JeuxService jeuxService;

    @Mapping(target = "utilisateur_id", expression = "java(getUtilisateurId(entity))")
    @Mapping(target = "jeux_id", expression = "java(getJeuxId(entity))")
    @Mapping(target = "utilisateur_nom", expression = "java(getUtilisateurNom(entity))")
    @Mapping(target = "jeux_nom", expression = "java(getJeuxNom(entity))")
    public abstract ReservationDTO toDTO(Reservation entity);

    @Mapping(target = "reservationId", expression = "java(createReservationId(dto))")
    public abstract Reservation toEntity(ReservationDTO dto);

    @Mapping(target = "reservationId", expression = "java(createReservationId(dto))")
    @Mapping(target = "jeux", expression = "java(getJeux(dto))")
    @Mapping(target = "utilisateur", expression = "java(getUtilisateur(dto))")
    public abstract Reservation toEntity(ReservationCreationDTO dto);

    protected ReservationId createReservationId(ReservationDTO dto) {
        return new ReservationId(dto.getUtilisateur_id(), dto.getJeux_id());
    }

    protected ReservationId createReservationId(ReservationCreationDTO dto) {
        return new ReservationId(dto.getUtilisateur_id(), dto.getJeux_id());
    }

    protected Utilisateur getUtilisateur(ReservationCreationDTO dto) {
        return utilisateurService.getById(dto.getUtilisateur_id());
    }

    protected Jeux getJeux(ReservationCreationDTO dto) {
        return jeuxService.getById(dto.getJeux_id());
    }

    protected int getUtilisateurId(Reservation entity) {
        return entity.getReservationId().getUtilisateur_id();
    }

    protected int getJeuxId(Reservation entity) {
        return entity.getReservationId().getJeux_id();
    }

    protected String getUtilisateurNom(Reservation entity) {
        return entity.getUtilisateur().getNom() + " " + entity.getUtilisateur().getPrenom();
    }

    protected String getJeuxNom(Reservation entity) {
        return entity.getJeux().getNom();
    }
}
