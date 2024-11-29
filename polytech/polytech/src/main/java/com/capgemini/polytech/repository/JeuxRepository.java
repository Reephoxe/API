package com.capgemini.polytech.repository;

import com.capgemini.polytech.entity.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeuxRepository extends JpaRepository<Jeux, Integer> {
}
