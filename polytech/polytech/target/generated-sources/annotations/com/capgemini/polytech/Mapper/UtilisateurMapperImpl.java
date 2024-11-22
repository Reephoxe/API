package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.DTO.UtilisateurDTO;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public UtilisateurDTO toDTO(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDTO.UtilisateurDTOBuilder utilisateurDTO = UtilisateurDTO.builder();

        utilisateurDTO.id( utilisateur.getId() );
        utilisateurDTO.nom( utilisateur.getNom() );
        utilisateurDTO.prenom( utilisateur.getPrenom() );
        utilisateurDTO.mail( utilisateur.getMail() );
        utilisateurDTO.username( utilisateur.getUsername() );
        utilisateurDTO.reservations( reservationListToReservationDTOList( utilisateur.getReservations() ) );

        return utilisateurDTO.build();
    }

    @Override
    public Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {
        if ( utilisateurDTO == null ) {
            return null;
        }

        Utilisateur.UtilisateurBuilder utilisateur = Utilisateur.builder();

        utilisateur.id( utilisateurDTO.getId() );
        utilisateur.nom( utilisateurDTO.getNom() );
        utilisateur.prenom( utilisateurDTO.getPrenom() );
        utilisateur.mail( utilisateurDTO.getMail() );
        utilisateur.username( utilisateurDTO.getUsername() );
        utilisateur.reservations( reservationDTOListToReservationList( utilisateurDTO.getReservations() ) );

        return utilisateur.build();
    }

    protected ReservationDTO reservationToReservationDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTO.ReservationDTOBuilder reservationDTO = ReservationDTO.builder();

        return reservationDTO.build();
    }

    protected List<ReservationDTO> reservationListToReservationDTOList(List<Reservation> list) {
        if ( list == null ) {
            return null;
        }

        List<ReservationDTO> list1 = new ArrayList<ReservationDTO>( list.size() );
        for ( Reservation reservation : list ) {
            list1.add( reservationToReservationDTO( reservation ) );
        }

        return list1;
    }

    protected Reservation reservationDTOToReservation(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        return reservation.build();
    }

    protected List<Reservation> reservationDTOListToReservationList(List<ReservationDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Reservation> list1 = new ArrayList<Reservation>( list.size() );
        for ( ReservationDTO reservationDTO : list ) {
            list1.add( reservationDTOToReservation( reservationDTO ) );
        }

        return list1;
    }
}
