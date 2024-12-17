package com.capgemini.polytech.controller;

import com.capgemini.polytech.DTO.ReservationCreationDTO;
import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.Mapper.ReservationMapper;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur REST pour la gestion des réservations.
 * Fournit des méthodes pour effectuer des opérations CRUD sur les réservations.
 *
 * Accessible via l'URL de base : http://localhost:8080/reservation
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;
    private ReservationMapper reservationMapper;

    /**
     * Constructeur du contrôleur ReservationController.
     *
     * @param reservationService Service gérant la logique métier pour les réservations.
     * @param reservationMapper  Mapper pour convertir entre entité Reservation et DTO.
     */
    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    /**
     * Récupère la liste de toutes les réservations.
     *
     * @return Une liste de ReservationDTO au format JSON.
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ReservationDTO> getListReservation() {
        List<ReservationDTO> listReservationDTO = new ArrayList<>();
        List<Reservation> listReservations = this.reservationService.getList();
        for (Reservation reservation : listReservations) {
            listReservationDTO.add(this.reservationMapper.toDTO(reservation));
        }
        return listReservationDTO;
    }

    /**
     * Récupère une réservation spécifique par son identifiant composé.
     *
     * @param id Identifiant composé de la réservation (utilisateur_id et jeux_id).
     * @return Le ReservationDTO correspondant.
     */
    @GetMapping(value = "id", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO getByIdReservation(@RequestBody ReservationId id) {
        return this.reservationMapper.toDTO(this.reservationService.getById(id));
    }

    /**
     * Crée une nouvelle réservation.
     *
     * @param reservationCreationDTO DTO contenant les informations nécessaires à la création d'une réservation.
     * @return Le ReservationDTO correspondant avec un code HTTP 201 (CREATED).
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationCreationDTO reservationCreationDTO) {
        Reservation reservationCreate = this.reservationService.createReservation(this.reservationMapper.toEntity(reservationCreationDTO));
        return new ResponseEntity<>(reservationMapper.toDTO(reservationCreate), HttpStatus.CREATED);
    }

    /**
     * Met à jour une réservation existante identifiée par son ID composé.
     *
     * @param reservationCreationDTO DTO contenant les nouvelles informations pour la réservation.
     * @return Le ReservationDTO mis à jour avec un code HTTP 200 (OK).
     */
    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationCreationDTO reservationCreationDTO) {
        ReservationId id = new ReservationId(reservationCreationDTO.getUtilisateur_id(), reservationCreationDTO.getJeux_id());
        Reservation reservationUpdate = this.reservationService.updateReservation(id, this.reservationMapper.toEntity(reservationCreationDTO));
        return new ResponseEntity<>(reservationMapper.toDTO(reservationUpdate), HttpStatus.OK);
    }

    /**
     * Supprime une réservation identifiée par son ID composé.
     *
     * @param id Identifiant composé de la réservation à supprimer.
     */
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteReservation(@RequestBody ReservationId id) {
        this.reservationService.deleteReservation(id);
    }
}
