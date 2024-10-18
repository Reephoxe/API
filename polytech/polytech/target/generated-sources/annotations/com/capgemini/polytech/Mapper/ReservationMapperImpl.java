package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.entity.Reservation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationDTO toDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTO.ReservationDTOBuilder reservationDTO = ReservationDTO.builder();

        return reservationDTO.build();
    }

    @Override
    public Reservation toEntity(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        return reservation.build();
    }
}
