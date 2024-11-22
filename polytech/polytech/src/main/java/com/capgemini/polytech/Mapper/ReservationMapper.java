package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.entity.Reservation;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationDTO toDTO(Reservation reservation);

    Reservation toEntity(ReservationDTO reservationDTO);
}

