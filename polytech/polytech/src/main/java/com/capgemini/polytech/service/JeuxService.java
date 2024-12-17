package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Jeux;
import com.capgemini.polytech.exception.JeuxNotFoundException;
import com.capgemini.polytech.repository.JeuxRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service pour la gestion des jeux dans l'application.
 * Fournit des méthodes pour récupérer, créer, mettre à jour et supprimer des jeux.
 */
@Service
public class JeuxService {
    private final JeuxRepository jeuxRepository;

    /**
     * Constructeur pour initialiser le service avec le {@link JeuxRepository}.
     *
     * @param jeuxRepository Le repository pour accéder aux données des jeux.
     */
    public JeuxService(JeuxRepository jeuxRepository) {
        this.jeuxRepository = jeuxRepository;
    }

    /**
     * Récupère la liste de tous les jeux.
     *
     * @return Une liste de {@link Jeux}.
     */
    public List<Jeux> getList() {
        return jeuxRepository.findAll();
    }

    /**
     * Récupère un jeu par son ID.
     * Si le jeu n'est pas trouvé, une exception {@link JeuxNotFoundException} est levée.
     *
     * @param id L'ID du jeu à récupérer.
     * @return Le jeu correspondant à l'ID.
     * @throws JeuxNotFoundException Si le jeu n'est pas trouvé.
     */
    public Jeux getById(Integer id) {
        return jeuxRepository.findById(id).orElseThrow(() -> new JeuxNotFoundException(id));
    }

    /**
     * Crée un nouveau jeu dans la base de données.
     *
     * @param jeux L'objet {@link Jeux} à créer.
     * @return Le jeu créé.
     */
    public Jeux createJeux(Jeux jeux) {
        return this.jeuxRepository.save(jeux);
    }

    /**
     * Met à jour les informations d'un jeu existant.
     * Si le jeu n'est pas trouvé, une exception {@link JeuxNotFoundException} est levée.
     *
     * @param id L'ID du jeu à mettre à jour.
     * @param updatedJeux L'objet {@link Jeux} contenant les nouvelles informations.
     * @return Le jeu mis à jour.
     * @throws JeuxNotFoundException Si le jeu n'est pas trouvé.
     */
    public Jeux updateJeux(Integer id, Jeux updatedJeux) {
        Jeux existingJeux = jeuxRepository.findById(id).orElseThrow(() -> new JeuxNotFoundException(id));

        // Mise à jour des informations du jeu existant
        existingJeux.setNom(updatedJeux.getNom());
        existingJeux.setDescription(updatedJeux.getDescription());
        existingJeux.setQuantite(updatedJeux.getQuantite());
        existingJeux.setPoint_geo(updatedJeux.getPoint_geo());

        // Sauvegarde des changements dans la base de données
        return this.jeuxRepository.save(existingJeux);
    }

    /**
     * Supprime un jeu de la base de données.
     * Si le jeu n'est pas trouvé, une exception {@link JeuxNotFoundException} est levée.
     *
     * @param id L'ID du jeu à supprimer.
     * @throws JeuxNotFoundException Si le jeu n'est pas trouvé.
     */
    public void deleteJeux(Integer id) {
        this.jeuxRepository.findById(id).map(
                e -> {
                    // Suppression du jeu
                    this.jeuxRepository.delete(e);
                    return e;
                }
        ).orElseThrow(() -> new JeuxNotFoundException(id));
    }
}
