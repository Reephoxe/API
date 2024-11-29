package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Jeu;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.exception.JeuNotFoundException;
import com.capgemini.polytech.exception.UtilisateurNotFoundException;
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
        return utilisateurRepository.findById(id).orElseThrow(() -> new UtilisateurNotFoundException(id));
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return this.utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUtilisateur(Integer id, Utilisateur updatedUtilisateur) {
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new UtilisateurNotFoundException(id));;
            existingUtilisateur.setNom(updatedUtilisateur.getNom());
            existingUtilisateur.setPrenom(updatedUtilisateur.getPrenom());
            existingUtilisateur.setMail(updatedUtilisateur.getMail());
            existingUtilisateur.setPassword(updatedUtilisateur.getPassword());
            existingUtilisateur.setUsername(updatedUtilisateur.getUsername());
            return this.utilisateurRepository.save(updatedUtilisateur);
    }

    public void deleteUtilisateur(Integer id) {
        this.utilisateurRepository.findById(id).map(
                e -> {
                    this.utilisateurRepository.delete(e);
                    return e;
                }
        ).orElseThrow(() -> new UtilisateurNotFoundException(id));
    }


}