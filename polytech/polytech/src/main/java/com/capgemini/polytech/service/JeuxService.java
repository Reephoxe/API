package com.capgemini.polytech.service;

import com.capgemini.polytech.entity.Jeux;
import com.capgemini.polytech.exception.JeuxNotFoundException;
import com.capgemini.polytech.repository.JeuxRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JeuxService {
    private final JeuxRepository jeuxRepository;

    public JeuxService(JeuxRepository jeuxRepository) {
        this.jeuxRepository = jeuxRepository;
    }

    public List<Jeux> getList() {
        return jeuxRepository.findAll();
    }

    public Jeux getById(Integer id) {
        return jeuxRepository.findById(id).orElseThrow(() -> new JeuxNotFoundException(id));
    }

    public Jeux createJeux(Jeux jeux) {
        return this.jeuxRepository.save(jeux);
    }

    public Jeux updateJeux(Integer id, Jeux updatedJeux) {
        Jeux existingJeux = jeuxRepository.findById(id).orElseThrow(() -> new JeuxNotFoundException(id));;
            existingJeux.setNom(updatedJeux.getNom());
            existingJeux.setDescription(updatedJeux.getDescription());
            existingJeux.setQuantite(updatedJeux.getQuantite());
            existingJeux.setPoint_geo(updatedJeux.getPoint_geo());
            return this.jeuxRepository.save(existingJeux);
    }


    public void deleteJeux(Integer id) {
        this.jeuxRepository.findById(id).map(
                e -> {
                    this.jeuxRepository.delete(e);
                    return e;
                }
        ).orElseThrow(() -> new JeuxNotFoundException(id));
    }


}