package com.capgemini.polytech.service;

import com.capgemini.polytech.repository.JeuRepository;
import com.capgemini.polytech.entity.Jeu;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JeuService {
    private final JeuRepository jeuRepository;

    public JeuService(JeuRepository jeuRepository) {
        this.jeuRepository = jeuRepository;
    }

    public List<Jeu> getList() {
        return jeuRepository.findAll();
    }

    public Jeu getById(Integer id) {
        return jeuRepository.findById(id).orElseThrow();
    }

    public Jeu createJeu(Jeu jeu) {
        return this.jeuRepository.save(jeu);
    }

    public Jeu updateJeu(Integer id, Jeu jeu) {
        return this.jeuRepository.findById(id).map(
                e -> this.jeuRepository.save(jeu)
        ).orElseThrow();
    }

    public void deleteJeu(Integer id) {
        this.jeuRepository.findById(id).map(
                e -> {
                    this.jeuRepository.delete(e);
                    return e;
                }
        ).orElseThrow();
    }


}