package com.capgemini.polytech.controller;


import com.capgemini.polytech.DTO.JeuDTO;
import com.capgemini.polytech.Mapper.JeuMapper;
import com.capgemini.polytech.entity.Jeu;
import com.capgemini.polytech.service.JeuService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/jeu")
public class JeuController  {

    private JeuMapper jeuMapper;
    private JeuService jeuService;

    public JeuController(JeuMapper jeuMapper, JeuService jeuService) {
        this.jeuMapper = jeuMapper;
        this.jeuService = jeuService;
    }

    //GET localhost:8080/jeu
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<JeuDTO> getListJeu(){
        List<JeuDTO> listJeuDTO = new ArrayList<>();
        List<Jeu> listJeu = this.jeuService.getList();
        for(Jeu jeu : listJeu){
            listJeuDTO.add(jeuMapper.toDTO(jeu));
        }
        return listJeuDTO;
    }

    //GET localhost:8080/jeu/39
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public JeuDTO getByIdJeu(@PathVariable Integer id){
        return this.jeuMapper.toDTO(this.jeuService.getById(id));
    }

    //POST localhost:8080/jeu avec JSON body
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JeuDTO> createJeu(@RequestBody JeuDTO jeuDTO){
        Jeu jeuCreate = this.jeuService.createJeu(this.jeuMapper.toEntity(jeuDTO));
        return new ResponseEntity<>(jeuMapper.toDTO(jeuCreate), HttpStatus.CREATED);
    }

    //PUT localhost:8080/jeu/160
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JeuDTO> updateJeu(@PathVariable Integer id, @RequestBody JeuDTO jeuDTO){
        Jeu jeuUpdate = this.jeuService.updateJeu(id, this.jeuMapper.toEntity(jeuDTO));
        return new ResponseEntity<>(jeuMapper.toDTO(jeuUpdate), HttpStatus.OK);
    }

    //DELETE localhost:8080/jeu/38
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteJeu(@PathVariable Integer id){
        this.jeuService.deleteJeu(id);
    }

}
