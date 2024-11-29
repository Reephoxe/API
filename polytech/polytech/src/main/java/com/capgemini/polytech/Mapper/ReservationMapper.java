package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.entity.Jeu;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "utilisateur_id", expression = "java(getUtilisateurId(entity))")
    @Mapping(target = "jeux_id", expression = "java(getJeuId(entity))")
    ReservationDTO toDTO(Reservation entity);

    @Mapping(target = "reservationId", expression = "java(createReservationId(dto))")
    Reservation toEntity(ReservationDTO dto);

    default ReservationId createReservationId(ReservationDTO dto) {
        return new ReservationId(dto.getUtilisateur_id(), dto.getJeux_id());
    }

    default int getUtilisateurId(Reservation entity) {
        return entity.getReservationId().getUtilisateur_id();
    }

    default int getJeuId(Reservation entity){
        return entity.getReservationId().getJeux_id();
    }
}

