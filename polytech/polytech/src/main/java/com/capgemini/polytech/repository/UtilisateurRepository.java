package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour accéder aux données de l'entité {@link Utilisateur}.
 * Fournit des opérations CRUD (Create, Read, Update, Delete) sur l'entité {@link Utilisateur}.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
