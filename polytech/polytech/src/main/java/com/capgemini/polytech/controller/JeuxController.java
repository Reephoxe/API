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


@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/jeux")
public class JeuxController {

    private JeuxMapper jeuxMapper;
    private JeuxService jeuxService;

    public JeuxController(JeuxMapper jeuxMapper, JeuxService jeuxService) {
        this.jeuxMapper = jeuxMapper;
        this.jeuxService = jeuxService;
    }

    //GET localhost:8080/jeu
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<JeuxDTO> getListJeu(){
        List<JeuxDTO> listJeuxDTO = new ArrayList<>();
        List<Jeux> listJeux = this.jeuxService.getList();
        for(Jeux jeux : listJeux){
            listJeuxDTO.add(jeuxMapper.toDTO(jeux));
        }
        return listJeuxDTO;
    }

    //GET localhost:8080/jeux/39
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public JeuxDTO getByIdJeux(@PathVariable Integer id){
        return this.jeuxMapper.toDTO(this.jeuxService.getById(id));
    }

    //POST localhost:8080/jeux avec JSON body
    /*{
      "nom": "Test",
      "quantite": 10,
      "description": "Ceci est un test",
      "point_geo": "Tours"
    }*/
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JeuxDTO> createJeux(@RequestBody JeuxDTO jeuxDTO){
        Jeux jeuxCreate = this.jeuxService.createJeux(this.jeuxMapper.toEntity(jeuxDTO));
        return new ResponseEntity<>(jeuxMapper.toDTO(jeuxCreate), HttpStatus.CREATED);
    }

    //PUT localhost:8080/jeux/160
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JeuxDTO> updateJeux(@PathVariable Integer id, @RequestBody JeuxDTO jeuxDTO){
        Jeux jeuxUpdate = this.jeuxService.updateJeux(id, this.jeuxMapper.toEntity(jeuxDTO));
        return new ResponseEntity<>(jeuxMapper.toDTO(jeuxUpdate), HttpStatus.OK);
    }

    //DELETE localhost:8080/jeux/38
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteJeux(@PathVariable Integer id){
        this.jeuxService.deleteJeux(id);
    }

}
