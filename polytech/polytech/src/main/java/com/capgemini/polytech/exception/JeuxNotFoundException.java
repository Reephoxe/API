package com.capgemini.polytech.exception;

/**
 * Exception levée lorsque le jeu avec un identifiant spécifique n'est pas trouvé.
 * Cette exception est utilisée pour indiquer qu'un jeu recherché par son ID n'existe pas dans la base de données.
 */
public class JeuxNotFoundException extends RuntimeException {

    /**
     * Constructeur de l'exception avec un identifiant de jeu.
     * Génère un message d'erreur indiquant que le jeu avec l'ID fourni n'a pas été trouvé.
     *
     * @param id L'identifiant du jeu qui n'a pas été trouvé.
     */
    public JeuxNotFoundException(Integer id) {
        super("Jeu avec l'ID " + id + " pas trouvé");
    }
}
