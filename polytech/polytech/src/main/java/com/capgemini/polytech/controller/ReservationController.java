package com.capgemini.polytech.controller;

import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.Mapper.ReservationMapper;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/Reservation")
public class ReservationController {

    private ReservationService reservationService;
    private ReservationMapper reservationMapper;

    public ReservationController( ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    //GET localhost:8080/Controller
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ReservationDTO> getListReservation() {
    List<ReservationDTO> listReservationDTO = new ArrayList<>();
    List<Reservation> listReservations = this.reservationService.getList();
    for (Reservation reservation : listReservations) {
        listReservationDTO.add(this.reservationMapper.toDTO(reservation));
    }
    return listReservationDTO;
    }

    //GET localhost:8080/Controller/1
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO getByIdReservation(@PathVariable Integer id) {
        return this.reservationMapper.toDTO(this.reservationService.getById(id));
    }

    //
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void createReservation(ReservationDTO newReservation) {
        this.reservationService.createReservation(this.reservationMapper.toEntity(newReservation));
    }

    //
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateReservation(@PathVariable Integer id, ReservationDTO newReservation) {
        this.reservationService.updateReservation(id, this.reservationMapper.toEntity(newReservation));
    }

    //DELETE localhost:8080/Controller?id=1
    @DeleteMapping
    public void deleteReservation(Integer id) {
        this.reservationService.deleteReservation(id);
    }



}
