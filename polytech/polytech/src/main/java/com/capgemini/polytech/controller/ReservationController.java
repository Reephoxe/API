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

    public List<ReservationDTO> getList() {
    List<ReservationDTO> listReservationDTO = new ArrayList<>();
    List<Reservation> listReservations = this.reservationService.getList();
    for (Reservation reservation : listReservations) {
        listReservationDTO.add(this.reservationMapper.toDTO(reservation));
    }
    return listReservationDTO;
    }

    public ReservationDTO getById(int id) {
        return this.reservationMapper.toDTO(this.reservationService.getById(id));
    }

    public void create(ReservationDTO newReservation) {
        this.reservationService.createReservation(this.reservationMapper.toEntity(newReservation));
    }

    public void update(int id, ReservationDTO newReservation) {
        this.reservationService.updateReservation(id, this.reservationMapper.toEntity(newReservation));
    }

    public void delete(int id) {
        this.reservationService.deleteReservation(id);
    }



}
