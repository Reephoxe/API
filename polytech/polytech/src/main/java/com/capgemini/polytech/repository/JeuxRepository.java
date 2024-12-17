package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour accéder aux données de l'entité {@link Jeux}.
 * Fournit des opérations CRUD (Create, Read, Update, Delete) sur l'entité {@link Jeux}.
 */
@Repository
public interface JeuxRepository extends JpaRepository<Jeux, Integer> {
}
