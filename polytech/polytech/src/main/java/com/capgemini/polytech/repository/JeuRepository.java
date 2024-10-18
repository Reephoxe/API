package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeuRepository extends JpaRepository<Jeu, Integer> {
}
