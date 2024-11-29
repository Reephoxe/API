package com.capgemini.polytech.controller;

import com.capgemini.polytech.DTO.JeuDTO;
import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.DTO.UtilisateurDTO;
import com.capgemini.polytech.Mapper.ReservationMapper;
import com.capgemini.polytech.entity.Jeu;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //GET localhost:8080/reservation/1
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO getByIdReservation(@PathVariable Integer id) {
        return this.reservationMapper.toDTO(this.reservationService.getById(id));
    }

    //POST localhost:8080/reservation avec JSON body
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO){
        Reservation reservationCreate = this.reservationService.createReservation(this.reservationMapper.toEntity(reservationDTO));
        return new ResponseEntity<>(reservationMapper.toDTO(reservationCreate), HttpStatus.CREATED);
    }

    //
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservationDTO){
        Reservation reservationUpdate = this.reservationService.updateReservation(id, this.reservationMapper.toEntity(reservationDTO));
        return new ResponseEntity<>(reservationMapper.toDTO(reservationUpdate), HttpStatus.OK);
    }

    //DELETE localhost:8080/reservation/1
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteJeu(@PathVariable Integer id){
        this.reservationService.deleteReservation(id);
    }

}
