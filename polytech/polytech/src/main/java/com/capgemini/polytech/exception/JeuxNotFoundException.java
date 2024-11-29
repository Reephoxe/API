package com.capgemini.polytech.exception;

public class JeuxNotFoundException extends RuntimeException{

    public JeuxNotFoundException(Integer id) {
        super("Jeu avec l'ID "+id+ " pas trouvé");
    }
}
