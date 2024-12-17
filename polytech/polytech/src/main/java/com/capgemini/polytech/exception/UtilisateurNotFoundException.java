package com.capgemini.polytech.exception;

/**
 * Exception levée lorsque l'utilisateur avec un identifiant spécifique n'est pas trouvé.
 * Cette exception est utilisée pour indiquer qu'un utilisateur recherché par son ID n'existe pas dans la base de données.
 */
public class UtilisateurNotFoundException extends RuntimeException {

    /**
     * Constructeur de l'exception avec un identifiant d'utilisateur.
     * Génère un message d'erreur indiquant que l'utilisateur avec l'ID fourni n'a pas été trouvé.
     *
     * @param id L'identifiant de l'utilisateur qui n'a pas été trouvé.
     */
    public UtilisateurNotFoundException(Integer id) {
        super("Utilisateur avec l'ID " + id + " pas trouvé");
    }
}
