package com.capgemini.polytech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.polytech.service.UtilisateurService;
import com.capgemini.polytech.entity.Utilisateur;
@Slf4j
@RestController
@RequestMapping("/Utilisateur")
public class UtilisateurController {
    private UtilisateurService utilisateurService;
    private UtilisateurMapper utilisateurMapper;

    public UtilisateurController (UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper)  //Constructeur
    {
        this.utilisateurMapper = utilisateurMapper;
        this.utilisateurService = utilisateurService;
    }

    //GET localhost:8080/Utilisateur
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UtilisateurDTO> getListUtilisateur() {
        List<Utilisateur> liste = this.utilisateurService.getList();
        List<UtilisateurDTO> listeDTO = new ArrayList<UtilisateurDTO>();
        for (Utilisateur utilisateur : liste) {
            listeDTO.add(this.utilisateurMapper.toDTO(utilisateur));
        }
        return listeDTO;
    }

    //GET localhost:8080/Utilisateur/1
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO getByIdUtilisateur(@PathVariable Integer id) {
        return this.utilisateurMapper.toDTO(this.utilisateurService.getById(id));
    }

    //
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void createUtilisateur(Utilisateur NewUtilisateur){
        this.utilisateurService.createUtilisateur(NewUtilisateur);
    }

    //
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateUtilisateur(@PathVariable Integer id, UtilisateurDTO NewValue){
        this.utilisateurService.updateUtilisateur(id, this.utilisateurMapper.toEntity(NewValue));
    }

    //DELETE localhost:8080/Utilisateur?id=1
    @DeleteMapping
    public void deleteUtilisateur(Integer id) {
        this.utilisateurService.deleteUtilisateur(id);
    }

}