package com.capgemini.polytech.controller;


import com.capgemini.polytech.DTO.JeuDTO;
import com.capgemini.polytech.Mapper.JeuMapper;
import com.capgemini.polytech.entity.Jeu;
import com.capgemini.polytech.service.JeuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public List<JeuDTO> getList(){
        List<JeuDTO> listJeuDTO = new ArrayList<>();
        List<Jeu> listJeu = this.jeuService.getList();
        for(Jeu jeu : listJeu){
            listJeuDTO.add(jeuMapper.toDTO(jeu));
        }
        return listJeuDTO;
    }

    public JeuDTO getById(int id){
        return this.jeuMapper.toDTO(this.jeuService.getById(id));
    }

    public void createJeu(JeuDTO jeuDTO){
        this.jeuService.createJeu(this.jeuMapper.toEntity(jeuDTO));
    }

    public void updateJeu(int id, JeuDTO jeuDTO){
        this.jeuService.updateJeu(id, this.jeuMapper.toEntity(jeuDTO));

    }
    public void deleteJeu(int id){
        this.jeuService.deleteJeu(id);
    }

}
