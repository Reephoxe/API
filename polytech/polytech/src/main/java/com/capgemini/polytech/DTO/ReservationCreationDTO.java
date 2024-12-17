package com.capgemini.polytech.DTO;

import lombok.*;

/**
 * DTO utilisé pour la création d'une réservation.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Data
public class ReservationCreationDTO {
    /**
     * Identifiant de l'utilisateur qui effectue la réservation.
     */
    private Integer utilisateur_id;

    /**
     * Identifiant du jeu associé à la réservation.
     */
    private Integer jeux_id;

    /**
     * Valeur représentant le nombre de quantités réservées.
     */
    private Integer reservation;
}
