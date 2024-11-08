package com.capgemini.polytech.controller;


import com.capgemini.polytech.DTO.JeuDTO;
import com.capgemini.polytech.Mapper.JeuMapper;
import com.capgemini.polytech.entity.Jeu;
import com.capgemini.polytech.service.JeuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<JeuDTO> getList(){
        List<JeuDTO> listJeuDTO = new ArrayList<>();
        List<Jeu> listJeu = this.jeuService.getList();
        for(Jeu jeu : listJeu){
            listJeuDTO.add(jeuMapper.toDTO(jeu));
        }
        return listJeuDTO;
    }

    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public JeuDTO getById(int id){
        return this.jeuMapper.toDTO(this.jeuService.getById(id));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void createJeu(JeuDTO jeuDTO){
        this.jeuService.createJeu(this.jeuMapper.toEntity(jeuDTO));
    }

    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateJeu(int id, JeuDTO jeuDTO){
        this.jeuService.updateJeu(id, this.jeuMapper.toEntity(jeuDTO));
    }

    @DeleteMapping
    public void deleteJeu(int id){
        this.jeuService.deleteJeu(id);
    }

}
