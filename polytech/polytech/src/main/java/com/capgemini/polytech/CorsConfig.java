package com.capgemini.polytech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration CORS pour l'application.
 * Permet de configurer les règles CORS pour autoriser les requêtes
 * entre différentes origines, en particulier pour autoriser l'accès à l'API depuis le front
 * hébergée à l'adresse http://localhost:4200.
 */
@Configuration
public class CorsConfig {

    /**
     * Configure les règles CORS pour l'application.
     * Permet toutes les méthodes HTTP (GET, POST, PUT, DELETE, OPTIONS)
     * http://localhost:4200, et autorise tous les en-têtes dans les requêtes.
     *
     * @return Un objet {@link WebMvcConfigurer} configuré avec les règles CORS.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permettre tous les chemins
                        .allowedOrigins("http://localhost:4200") // Permettre cette origine
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes autorisées
                        .allowedHeaders("*"); // Tous les en-têtes sont autorisés
            }
        };
    }
}
