package com.capgemini.polytech;

import lombok.Data;

@Data
public class ReservationDTO {
    private Integer utilisateurId;
    private Integer jeuxId;

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Integer getJeuxId() {
        return jeuxId;
    }

    public void setJeuxId(Integer jeuxId) {
        this.jeuxId = jeuxId;
    }
}
