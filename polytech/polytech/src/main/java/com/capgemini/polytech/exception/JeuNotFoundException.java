package com.capgemini.polytech.exception;

public class JeuNotFoundException extends RuntimeException{

    public JeuNotFoundException(Integer id) {
        super("Jeu avec l'ID "+id+ " pas trouvé");
    }
}
