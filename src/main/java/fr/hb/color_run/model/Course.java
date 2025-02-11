package fr.hb.color_run.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la course est obligatoire.")
    private String nom;

    private String description;

    private LocalDateTime dateHeure;

    @NotBlank(message = "Le lieu de la course est obligatoire.")
    private String lieu;

    @NotNull(message = "La distance de la course est obligatoire.")
    private float distance;

    @NotNull(message = "Le nombre de participant maximum à la course est obligatoire.")
    private int nbParticipantMax;

    @NotNull(message = "Le prix de la participation à une course est obligatoire.")
    @Min(value = 0, message = "Le prix doit être supérieur à 0€")
    private float prixParticipation;

    private boolean avecObstacle;

    private String causeSoutenu;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Parcours> parcours = new ArrayList<>();

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Inscription> inscriptions = new ArrayList<>();

    public Course(long l, String course2, String s, LocalDateTime of, String s1, float v, int i, float v1, boolean b, String lesSecoursCatholique) {
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", dateHeure=" + dateHeure +
                ", lieu='" + lieu + '\'' +
                ", distance=" + distance +
                ", nbParticipantMax=" + nbParticipantMax +
                ", prixParticipation=" + prixParticipation +
                ", avecObstacle=" + avecObstacle +
                ", causeSoutenu='" + causeSoutenu + '\'' +
//                ", parcours=" + parcours +
//                ", inscriptions=" + inscriptions +
                '}';
    }
}
