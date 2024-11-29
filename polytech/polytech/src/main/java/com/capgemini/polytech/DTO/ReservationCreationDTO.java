package com.capgemini.polytech.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Data
public class ReservationCreationDTO {
    private Integer utilisateur_id;
    private Integer jeux_id;
    private Integer reservation;
}
