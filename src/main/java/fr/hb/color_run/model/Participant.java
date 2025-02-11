package fr.hb.color_run.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du participant est obligatoire.")
    private String nom;

    @NotBlank(message = "Le prenom du participant est obligatoire.")
    private String prenom;

    @NotBlank(message = "L'email du participant est obligatoire.")
    @Email(message = "L'adresse e-mail n'est pas valide.")
    private String email;

    private String motDePasse;

    private String photo;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "participant", fetch = FetchType.EAGER)
    private List<Inscription> inscriptions = new ArrayList<>();



    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", photo='" + photo + '\'' +
                ", role=" + role +
//                ", inscriptions=" + inscriptions +
                '}';
    }
}
