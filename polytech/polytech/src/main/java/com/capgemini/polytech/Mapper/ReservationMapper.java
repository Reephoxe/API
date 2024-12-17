package com.capgemini.polytech.Mapper;

import com.capgemini.polytech.DTO.ReservationCreationDTO;
import com.capgemini.polytech.DTO.ReservationDTO;
import com.capgemini.polytech.entity.Jeux;
import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.entity.Utilisateur;
import com.capgemini.polytech.service.JeuxService;
import com.capgemini.polytech.service.UtilisateurService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Mapper pour convertir entre l'entité {@link Reservation} et ses DTOs {@link ReservationDTO} et {@link ReservationCreationDTO}.
 * Ce mapper utilise des services pour récupérer des entités {@link Utilisateur} et {@link Jeux}.
 */
@Mapper(componentModel = "spring")
public abstract class ReservationMapper {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private JeuxService jeuxService;

    /**
     * Convertit une entité {@link Reservation} en un objet {@link ReservationDTO}.
     *
     * @param entity L'entité {@link Reservation} à convertir.
     * @return Le DTO {@link ReservationDTO} représentant l'entité {@link Reservation}.
     */
    @Mapping(target = "utilisateur_id", expression = "java(getUtilisateurId(entity))")
    @Mapping(target = "jeux_id", expression = "java(getJeuxId(entity))")
    @Mapping(target = "utilisateur_nom", expression = "java(getUtilisateurNom(entity))")
    @Mapping(target = "jeux_nom", expression = "java(getJeuxNom(entity))")
    public abstract ReservationDTO toDTO(Reservation entity);

    /**
     * Convertit un objet {@link ReservationDTO} en une entité {@link Reservation}.
     *
     * @param dto Le DTO {@link ReservationDTO} à convertir.
     * @return L'entité {@link Reservation} représentant le DTO {@link ReservationDTO}.
     */
    @Mapping(target = "reservationId", expression = "java(createReservationId(dto))")
    public abstract Reservation toEntity(ReservationDTO dto);

    /**
     * Convertit un objet {@link ReservationCreationDTO} en une entité {@link Reservation}.
     *
     * @param dto Le DTO {@link ReservationCreationDTO} à convertir.
     * @return L'entité {@link Reservation} représentant le DTO {@link ReservationCreationDTO}.
     */
    @Mapping(target = "reservationId", expression = "java(createReservationId(dto))")
    @Mapping(target = "jeux", expression = "java(getJeux(dto))")
    @Mapping(target = "utilisateur", expression = "java(getUtilisateur(dto))")
    public abstract Reservation toEntity(ReservationCreationDTO dto);

    /**
     * Crée un {@link ReservationId} à partir du DTO {@link ReservationDTO}.
     *
     * @param dto Le DTO {@link ReservationDTO}.
     * @return Un {@link ReservationId} construit à partir des IDs utilisateur et jeu.
     */
    protected ReservationId createReservationId(ReservationDTO dto) {
        return new ReservationId(dto.getUtilisateur_id(), dto.getJeux_id());
    }

    /**
     * Crée un {@link ReservationId} à partir du DTO {@link ReservationCreationDTO}.
     *
     * @param dto Le DTO {@link ReservationCreationDTO}.
     * @return Un {@link ReservationId} construit à partir des IDs utilisateur et jeu.
     */
    protected ReservationId createReservationId(ReservationCreationDTO dto) {
        return new ReservationId(dto.getUtilisateur_id(), dto.getJeux_id());
    }

    /**
     * Récupère un {@link Utilisateur} à partir de l'ID utilisateur du DTO {@link ReservationCreationDTO}.
     *
     * @param dto Le DTO {@link ReservationCreationDTO}.
     * @return L'entité {@link Utilisateur} correspondant à l'ID utilisateur dans le DTO.
     */
    protected Utilisateur getUtilisateur(ReservationCreationDTO dto) {
        return utilisateurService.getById(dto.getUtilisateur_id());
    }

    /**
     * Récupère un {@link Jeux} à partir de l'ID du jeu du DTO {@link ReservationCreationDTO}.
     *
     * @param dto Le DTO {@link ReservationCreationDTO}.
     * @return L'entité {@link Jeux} correspondant à l'ID du jeu dans le DTO.
     */
    protected Jeux getJeux(ReservationCreationDTO dto) {
        return jeuxService.getById(dto.getJeux_id());
    }

    /**
     * Récupère l'ID de l'utilisateur à partir de l'entité {@link Reservation}.
     *
     * @param entity L'entité {@link Reservation}.
     * @return L'ID de l'utilisateur.
     */
    protected int getUtilisateurId(Reservation entity) {
        return entity.getReservationId().getUtilisateur_id();
    }

    /**
     * Récupère l'ID du jeu à partir de l'entité {@link Reservation}.
     *
     * @param entity L'entité {@link Reservation}.
     * @return L'ID du jeu.
     */
    protected int getJeuxId(Reservation entity) {
        return entity.getReservationId().getJeux_id();
    }

    /**
     * Récupère le nom de l'utilisateur à partir de l'entité {@link Reservation}.
     *
     * @param entity L'entité {@link Reservation}.
     * @return Le nom complet de l'utilisateur sous forme de chaîne.
     */
    protected String getUtilisateurNom(Reservation entity) {
        return entity.getUtilisateur().getNom() + " " + entity.getUtilisateur().getPrenom();
    }

    /**
     * Récupère le nom du jeu à partir de l'entité {@link Reservation}.
     *
     * @param entity L'entité {@link Reservation}.
     * @return Le nom du jeu.
     */
    protected String getJeuxNom(Reservation entity) {
        return entity.getJeux().getNom();
    }
}
