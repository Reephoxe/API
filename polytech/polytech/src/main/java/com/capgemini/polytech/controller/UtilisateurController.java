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

    public UtilisateurController (UtilisateurService CopieUtilisateurService, UtilisateurMapper CopieUtilisateurMapper)  //Constructeur
    {
        utilisateurMapper = CopieUtilisateurMapper;
        utilisateurService = CopieUtilisateurService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UtilisateurDTO> getList() {
        List<Utilisateur> liste = this.utilisateurService.getList();
        List<UtilisateurDTO> listeDTO = new ArrayList<UtilisateurDTO>();
        for (Utilisateur utilisateur : liste) {
            listeDTO.add(this.utilisateurMapper.toDTO(utilisateur));
        }
        return listeDTO;
    }

    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO getById(Integer id) {
        return this.utilisateurMapper.toDTO(this.utilisateurService.getById(id));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void create(Utilisateur NewUtilisateur){
        this.utilisateurService.createUtilisateur(NewUtilisateur);
    }

    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void update(Integer id, UtilisateurDTO NewValue){
        this.utilisateurService.updateUtilisateur(id, this.utilisateurMapper.toEntity(NewValue));
    }

    @DeleteMapping
    public void delete(Integer id) {
        this.utilisateurService.deleteUtilisateur(id);
    }

}