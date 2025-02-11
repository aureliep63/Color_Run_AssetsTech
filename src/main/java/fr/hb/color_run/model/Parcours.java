package fr.hb.color_run.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parcours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La latitude du parcours de la course est obligatoire.")
    private double latitude;

    @NotNull(message = "La longitude du parcours de la course est obligatoire.")
    private double longitude;

    @NotNull(message = "L'ordre des points pour la course est obligatoire.")
    @Min(value = 1)
    private int ordre;

    @ManyToOne
    private Course course;



    @Override
    public String toString() {
        return "Parcours{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", ordre=" + ordre +
//                ", courses=" + courses +
                '}';
    }
}
