package com.capgemini.polytech.controller;

import com.capgemini.polytech.DTO.UtilisateurCreationDTO;
import com.capgemini.polytech.DTO.UtilisateurDTO;
import com.capgemini.polytech.Mapper.UtilisateurMapper;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur REST pour la gestion des utilisateurs.
 * Fournit des méthodes pour effectuer des opérations CRUD sur les utilisateurs.
 *
 * Accessible via l'URL de base : http://localhost:8080/utilisateur
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private UtilisateurService utilisateurService;
    private UtilisateurMapper utilisateurMapper;

    /**
     * Constructeur du contrôleur UtilisateurController.
     *
     * @param utilisateurService Service gérant la logique métier pour les utilisateurs.
     * @param utilisateurMapper  Mapper pour convertir entre entité Utilisateur et DTO.
     */
    public UtilisateurController(UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper) {
        this.utilisateurMapper = utilisateurMapper;
        this.utilisateurService = utilisateurService;
    }

    /**
     * Récupère la liste de tous les utilisateurs.
     *
     * @return Une liste d'UtilisateurDTO au format JSON.
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UtilisateurDTO> getListUtilisateur() {
        List<Utilisateur> liste = this.utilisateurService.getList();
        List<UtilisateurDTO> listeDTO = new ArrayList<>();
        for (Utilisateur utilisateur : liste) {
            listeDTO.add(this.utilisateurMapper.toDTO(utilisateur));
        }
        return listeDTO;
    }

    /**
     * Récupère un utilisateur spécifique par son identifiant.
     *
     * @param id L'identifiant unique de l'utilisateur.
     * @return L'UtilisateurDTO correspondant.
     */
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO getByIdUtilisateur(@PathVariable Integer id) {
        return this.utilisateurMapper.toDTO(this.utilisateurService.getById(id));
    }

    /**
     * Crée un nouvel utilisateur.
     *
     * @param utilisateurCreationDTO DTO contenant les informations nécessaires à la création d'un utilisateur.
     * @return L'UtilisateurDTO correspondant avec un code HTTP 201 (CREATED).
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@RequestBody UtilisateurCreationDTO utilisateurCreationDTO) {
        Utilisateur utilisateurCreate = this.utilisateurService.createUtilisateur(this.utilisateurMapper.toEntity(utilisateurCreationDTO));
        return new ResponseEntity<>(utilisateurMapper.toDTO(utilisateurCreate), HttpStatus.CREATED);
    }

    /**
     * Met à jour un utilisateur existant identifié par son ID.
     *
     * @param id                   L'identifiant unique de l'utilisateur à mettre à jour.
     * @param utilisateurCreationDTO DTO contenant les nouvelles informations pour l'utilisateur.
     * @return L'UtilisateurDTO mis à jour avec un code HTTP 200 (OK).
     */
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UtilisateurDTO> updateUtilisateur(@PathVariable Integer id, @RequestBody UtilisateurCreationDTO utilisateurCreationDTO) {
        Utilisateur utilisateurUpdate = this.utilisateurService.updateUtilisateur(id, this.utilisateurMapper.toEntity(utilisateurCreationDTO));
        return new ResponseEntity<>(utilisateurMapper.toDTO(utilisateurUpdate), HttpStatus.OK);
    }

    /**
     * Supprime un utilisateur identifié par son ID.
     *
     * @param id L'identifiant unique de l'utilisateur à supprimer.
     */
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteUtilisateur(@PathVariable Integer id) {
        this.utilisateurService.deleteUtilisateur(id);
    }
}
