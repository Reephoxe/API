package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getList() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getById(Integer id) {
        return utilisateurRepository.findById(id).orElseThrow();
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return this.utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUtilisateur(Integer id, Utilisateur utilisateur) {
        return this.utilisateurRepository.findById(id).map(
                e -> this.utilisateurRepository.save(utilisateur)
        ).orElseThrow();
    }

    public void deleteUtilisateur(Integer id) {
        this.utilisateurRepository.findById(id).map(
                e -> {
                    this.utilisateurRepository.delete(e);
                    return e;
                }
        ).orElseThrow();
    }


}