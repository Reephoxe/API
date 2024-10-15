package com.capgemini.polytech;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationMapper {


    public static ReservationDTO toDTO(Reservation reservation) {
        if (reservation == null) {
            return null;
        }

        ReservationDTO dto = new ReservationDTO();
        dto.setJeuxId(reservation.getReservation());
        dto.setUtilisateurId(reservation.getUtilisateur_id());
        return dto;
    }


    public static Reservation toEntity(ReservationDTO dto) {
        if (dto == null) {
            return null;
        }

        Reservation reservation = new Reservation();
        reservation.setReservation(dto.getJeuxId());
        reservation.setUtilisateur_id(dto.getUtilisateurId());


        return reservation;
    }


    public static List<ReservationDTO> toDTOList(List<Reservation> reservations) {
        return reservations.stream()
                .map(ReservationMapper::toDTO)
                .collect(Collectors.toList());
    }


    public static List<Reservation> toEntityList(List<ReservationDTO> dtos) {
        return dtos.stream()
                .map(ReservationMapper::toEntity)
                .collect(Collectors.toList());
    }
}
