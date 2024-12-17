package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.exception.UtilisateurNotFoundException;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service pour la gestion des utilisateurs dans l'application.
 * Fournit des méthodes pour récupérer, créer, mettre à jour et supprimer des utilisateurs.
 */
@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    /**
     * Constructeur pour initialiser le service avec le {@link UtilisateurRepository}.
     *
     * @param utilisateurRepository Le repository pour accéder aux données des utilisateurs.
     */
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * Récupère la liste de tous les utilisateurs.
     *
     * @return Une liste de {@link Utilisateur}.
     */
    public List<Utilisateur> getList() {
        return utilisateurRepository.findAll();
    }

    /**
     * Récupère un utilisateur par son ID.
     * Si l'utilisateur n'est pas trouvé, une exception {@link UtilisateurNotFoundException} est levée.
     *
     * @param id L'ID de l'utilisateur à récupérer.
     * @return L'utilisateur correspondant à l'ID.
     * @throws UtilisateurNotFoundException Si l'utilisateur n'est pas trouvé.
     */
    public Utilisateur getById(Integer id) {
        return utilisateurRepository.findById(id).orElseThrow(() -> new UtilisateurNotFoundException(id));
    }

    /**
     * Crée un nouvel utilisateur dans la base de données.
     *
     * @param utilisateur L'objet {@link Utilisateur} à créer.
     * @return L'utilisateur créé.
     */
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return this.utilisateurRepository.save(utilisateur);
    }

    /**
     * Met à jour les informations d'un utilisateur existant.
     * Si l'utilisateur n'est pas trouvé, une exception {@link UtilisateurNotFoundException} est levée.
     *
     * @param id L'ID de l'utilisateur à mettre à jour.
     * @param updatedUtilisateur L'objet {@link Utilisateur} contenant les nouvelles informations.
     * @return L'utilisateur mis à jour.
     * @throws UtilisateurNotFoundException Si l'utilisateur n'est pas trouvé.
     */
    public Utilisateur updateUtilisateur(Integer id, Utilisateur updatedUtilisateur) {
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new UtilisateurNotFoundException(id));

        // Mise à jour des informations de l'utilisateur existant
        existingUtilisateur.setNom(updatedUtilisateur.getNom());
        existingUtilisateur.setPrenom(updatedUtilisateur.getPrenom());
        existingUtilisateur.setMail(updatedUtilisateur.getMail());
        existingUtilisateur.setPassword(updatedUtilisateur.getPassword());
        existingUtilisateur.setUsername(updatedUtilisateur.getUsername());

        // Sauvegarde des changements dans la base de données
        return this.utilisateurRepository.save(existingUtilisateur);
    }

    /**
     * Supprime un utilisateur de la base de données.
     * Si l'utilisateur n'est pas trouvé, une exception {@link UtilisateurNotFoundException} est levée.
     *
     * @param id L'ID de l'utilisateur à supprimer.
     * @throws UtilisateurNotFoundException Si l'utilisateur n'est pas trouvé.
     */
    public void deleteUtilisateur(Integer id) {
        this.utilisateurRepository.findById(id).map(
                e -> {
                    // Suppression de l'utilisateur
                    this.utilisateurRepository.delete(e);
                    return e;
                }
        ).orElseThrow(() -> new UtilisateurNotFoundException(id));
    }
}
