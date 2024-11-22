package com.capgemini.polytech.service;

import com.capgemini.polytech.DTO.JeuDTO;
import com.capgemini.polytech.exception.JeuNotFoundException;
import com.capgemini.polytech.repository.JeuRepository;
import com.capgemini.polytech.entity.Jeu;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        return jeuRepository.findById(id).orElseThrow(() -> new JeuNotFoundException(id));
    }

    public Jeu createJeu(Jeu jeu) {
        return this.jeuRepository.save(jeu);
    }

    public Jeu updateJeu(Integer id, Jeu updatedJeu) {
        Jeu existingJeu = jeuRepository.findById(id).orElseThrow(() -> new JeuNotFoundException(id));;
            existingJeu.setNom(updatedJeu.getNom());
            existingJeu.setDescription(updatedJeu.getDescription());
            existingJeu.setQuantite(updatedJeu.getQuantite());
            existingJeu.setPoint_geo(updatedJeu.getPoint_geo());
            return this.jeuRepository.save(existingJeu);
    }


    public void deleteJeu(Integer id) {
        this.jeuRepository.findById(id).map(
                e -> {
                    this.jeuRepository.delete(e);
                    return e;
                }
        ).orElseThrow(() -> new JeuNotFoundException(id));
    }


}