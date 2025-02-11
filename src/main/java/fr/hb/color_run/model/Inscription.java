package fr.hb.color_run.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String generationDossard;

    @ManyToOne
    private Participant participant;

    @ManyToOne
    private Course course;



    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", generationDossard='" + generationDossard + '\'' +
                ", participant=" + participant +
                ", course=" + course +
                '}';
    }
}
