package com.capgemini.polytech.exception;

public class UtilisateurNotFoundException extends RuntimeException{

    public UtilisateurNotFoundException(Integer id) {
        super("Utilisateur avec l'ID "+id+ " pas trouvé");
    }
}
