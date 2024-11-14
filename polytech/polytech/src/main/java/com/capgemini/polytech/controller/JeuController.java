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
@RequestMapping("/Jeu")
public class JeuController  {

    private JeuMapper jeuMapper;
    private JeuService jeuService;

    public JeuController(JeuMapper jeuMapper, JeuService jeuService) {
        this.jeuMapper = jeuMapper;
        this.jeuService = jeuService;
    }

    //GET localhost:8080/Jeu
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<JeuDTO> getListJeu(){
        List<JeuDTO> listJeuDTO = new ArrayList<>();
        List<Jeu> listJeu = this.jeuService.getList();
        for(Jeu jeu : listJeu){
            listJeuDTO.add(jeuMapper.toDTO(jeu));
        }
        return listJeuDTO;
    }

    //GET localhost:8080/Jeu/39
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public JeuDTO getByIdJeu(@PathVariable Integer id){
        return this.jeuMapper.toDTO(this.jeuService.getById(id));
    }

    //
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JeuDTO> createJeu(@RequestBody JeuDTO jeuDTO){
        this.jeuService.createJeu(this.jeuMapper.toEntity(jeuDTO));
        return new ResponseEntity<>(jeuDTO, HttpStatus.CREATED);
    }

    //
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JeuDTO> updateJeu(@PathVariable Integer id, JeuDTO jeuDTO){
        this.jeuService.updateJeu(id, this.jeuMapper.toEntity(jeuDTO));
        return new ResponseEntity<>(jeuDTO, HttpStatus.OK);
    }

    //DELETE localhost:8080/Jeu?id=38
    @DeleteMapping
    public void deleteJeu(@RequestParam Integer id){
        this.jeuService.deleteJeu(id);
    }

}
