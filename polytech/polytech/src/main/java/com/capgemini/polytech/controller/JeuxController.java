package com.capgemini.polytech.controller;

import com.capgemini.polytech.DTO.JeuxDTO;
import com.capgemini.polytech.Mapper.JeuxMapper;
import com.capgemini.polytech.entity.Jeux;
import com.capgemini.polytech.service.JeuxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur REST pour la gestion des entités Jeux.
 * Fournit des méthodes pour effectuer des opérations CRUD sur les jeux.
 *
 * Accessible via l'URL de base : http://localhost:8080/jeux
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/jeux")
public class JeuxController {

    private JeuxMapper jeuxMapper;
    private JeuxService jeuxService;

    /**
     * Constructeur du contrôleur JeuxController.
     *
     * @param jeuxMapper  Instance du mapper pour convertir entre l'entité Jeux et le DTO JeuxDTO.
     * @param jeuxService Instance du service pour la logique métier des jeux.
     */
    public JeuxController(JeuxMapper jeuxMapper, JeuxService jeuxService) {
        this.jeuxMapper = jeuxMapper;
        this.jeuxService = jeuxService;
    }

    /**
     * Récupère la liste de tous les jeux disponibles.
     *
     * @return Une liste de JeuxDTO au format JSON.
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<JeuxDTO> getListJeu() {
        List<JeuxDTO> listJeuxDTO = new ArrayList<>();
        List<Jeux> listJeux = this.jeuxService.getList();
        for (Jeux jeux : listJeux) {
            listJeuxDTO.add(jeuxMapper.toDTO(jeux));
        }
        return listJeuxDTO;
    }

    /**
     * Récupère un jeu en fonction de son identifiant.
     *
     * @param id L'identifiant unique du jeu.
     * @return Le JeuxDTO correspondant au jeu trouvé.
     */
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public JeuxDTO getByIdJeux(@PathVariable Integer id) {
        return this.jeuxMapper.toDTO(this.jeuxService.getById(id));
    }

    /**
     * Crée un nouveau jeu à partir des informations fournies dans le corps de la requête.
     *
     * @param jeuxDTO Le DTO contenant les informations du jeu à créer.
     * @return Le JeuxDTO du jeu créé avec un code HTTP 201 (CREATED).
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JeuxDTO> createJeux(@RequestBody JeuxDTO jeuxDTO) {
        Jeux jeuxCreate = this.jeuxService.createJeux(this.jeuxMapper.toEntity(jeuxDTO));
        return new ResponseEntity<>(jeuxMapper.toDTO(jeuxCreate), HttpStatus.CREATED);
    }

    /**
     * Met à jour un jeu existant identifié par son ID.
     *
     * @param id      L'identifiant unique du jeu à mettre à jour.
     * @param jeuxDTO Le DTO contenant les nouvelles informations du jeu.
     * @return Le JeuxDTO mis à jour avec un code HTTP 200 (OK).
     */
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JeuxDTO> updateJeux(@PathVariable Integer id, @RequestBody JeuxDTO jeuxDTO) {
        Jeux jeuxUpdate = this.jeuxService.updateJeux(id, this.jeuxMapper.toEntity(jeuxDTO));
        return new ResponseEntity<>(jeuxMapper.toDTO(jeuxUpdate), HttpStatus.OK);
    }

    /**
     * Supprime un jeu identifié par son ID.
     *
     * @param id L'identifiant unique du jeu à supprimer.
     */
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteJeux(@PathVariable Integer id) {
        this.jeuxService.deleteJeux(id);
    }
}
