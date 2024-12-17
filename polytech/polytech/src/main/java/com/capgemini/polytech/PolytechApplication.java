package com.capgemini.polytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Point d'entrée de l'application Spring Boot.
 * Cette classe contient la méthode {@link #main(String[])} qui lance l'application Spring Boot.
 */
@SpringBootApplication
public class PolytechApplication {

	/**
	 * Méthode principale pour démarrer l'application Spring Boot.
	 *
	 * @param args Les arguments de ligne de commande passés à l'application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(PolytechApplication.class, args);
	}
}
