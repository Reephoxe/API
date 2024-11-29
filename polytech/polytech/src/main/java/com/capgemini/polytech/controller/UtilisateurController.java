package com.capgemini.polytech.controller;

import com.capgemini.polytech.DTO.UtilisateurCreationDTO;
import com.capgemini.polytech.DTO.UtilisateurDTO;
import com.capgemini.polytech.Mapper.UtilisateurMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.polytech.service.UtilisateurService;
import com.capgemini.polytech.entity.Utilisateur;
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private UtilisateurService utilisateurService;
    private UtilisateurMapper utilisateurMapper;

    public UtilisateurController (UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper)  //Constructeur
    {
        this.utilisateurMapper = utilisateurMapper;
        this.utilisateurService = utilisateurService;
    }

    //GET localhost:8080/utilisateur
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UtilisateurDTO> getListUtilisateur() {
        List<Utilisateur> liste = this.utilisateurService.getList();
        List<UtilisateurDTO> listeDTO = new ArrayList<UtilisateurDTO>();
        for (Utilisateur utilisateur : liste) {
            listeDTO.add(this.utilisateurMapper.toDTO(utilisateur));
        }
        return listeDTO;
    }

    //GET localhost:8080/utilisateur/1
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO getByIdUtilisateur(@PathVariable Integer id) {
        return this.utilisateurMapper.toDTO(this.utilisateurService.getById(id));
    }

    //POST localhost:8080/utilisateur avec JSON body (dont le mdp)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@RequestBody UtilisateurCreationDTO utilisateurCreationDTO){
        Utilisateur utilisateurCreate = this.utilisateurService.createUtilisateur(this.utilisateurMapper.toEntity(utilisateurCreationDTO));
        return new ResponseEntity<>(utilisateurMapper.toDTO(utilisateurCreate), HttpStatus.CREATED);
    }

    //PUT localhost:8080/utilisateur/1 avec JSON body (dont le mdp)
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UtilisateurDTO> updateUtilisateur(@PathVariable Integer id,@RequestBody UtilisateurCreationDTO utilisateurCreationDTO){
        Utilisateur utilisateurUpdate = this.utilisateurService.updateUtilisateur(id, this.utilisateurMapper.toEntity(utilisateurCreationDTO));
        return new ResponseEntity<>(utilisateurMapper.toDTO(utilisateurUpdate), HttpStatus.OK);
    }

    //DELETE localhost:8080/utilisateur/1
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteUtilisateur(@PathVariable Integer id) {
        this.utilisateurService.deleteUtilisateur(id);
    }
}