package fr.hb.color_run.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDto {

     Long id;
    private String nom;
    private String description;
    private LocalDateTime dateHeure;
    private String lieu;
    private float distance;
    private int nbParticipantMax;
    private float prixParticipation;
    private boolean avecObstacle;
    private String causeSoutenu;

    private List<Long> parcoursId;
    private List<Long> inscriptionId;



}
