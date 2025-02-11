package fr.hb.color_run.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilParticipantDto {

     Long id;
    private String nom;
    private String prenom;
    private String email;
    private String photo;
    private String motDePasse;
    private List<Long> inscriptionId;
    private Long roleId;


}
