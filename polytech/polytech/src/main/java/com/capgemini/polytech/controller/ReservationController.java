package com.capgemini.polytech.controller;

import com.capgemini.polytech.DTO.ReservationCreationDTO;
import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.Mapper.ReservationMapper;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.service.ReservationService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;
    private ReservationMapper reservationMapper;

    public ReservationController( ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    //GET localhost:8080/reservation
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ReservationDTO> getListReservation() {
        List<ReservationDTO> listReservationDTO = new ArrayList<>();
        List<Reservation> listReservations = this.reservationService.getList();
        for (Reservation reservation : listReservations) {
            listReservationDTO.add(this.reservationMapper.toDTO(reservation));
    }
    return listReservationDTO;
    }

    //GET localhost:8080/reservation/id avec JSON body
    /*{
        "utilisateur_id" : "4",
        "jeux_id" : "124"
    }*/
    @GetMapping(value="id", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO getByIdReservation(@RequestBody ReservationId id) {
        return this.reservationMapper.toDTO(this.reservationService.getById(id));
    }

    //POST localhost:8080/reservation avec JSON body
    /*{
        "utilisateur_id" : "4",
        "jeux_id" : "124",
        "reservation" : 4
    }*/
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationCreationDTO reservationCreationDTO){
        Reservation reservationCreate = this.reservationService.createReservation(this.reservationMapper.toEntity(reservationCreationDTO));
        return new ResponseEntity<>(reservationMapper.toDTO(reservationCreate), HttpStatus.CREATED);
    }

    //PUT localhost:8080/reservation avec JSON body
    /*{
        "utilisateur_id": 2,
        "jeux_id": 46,
        "reservation" : 8
    }*/
    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationCreationDTO reservationCreationDTO){

        ReservationId id = new ReservationId(reservationCreationDTO.getUtilisateur_id(), reservationCreationDTO.getJeux_id());

        Reservation reservationUpdate = this.reservationService.updateReservation(id, this.reservationMapper.toEntity(reservationCreationDTO));
        return new ResponseEntity<>(reservationMapper.toDTO(reservationUpdate), HttpStatus.OK);
    }

    //DELETE localhost:8080/reservation avec JSON body
    /*{
        "utilisateur_id" : "4",
        "jeux_id" : "124"
    }*/
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteReservation(@RequestBody ReservationId id){
        this.reservationService.deleteReservation(id);
    }

}
