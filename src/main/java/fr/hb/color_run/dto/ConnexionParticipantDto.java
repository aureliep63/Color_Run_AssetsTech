package fr.hb.color_run.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnexionParticipantDto {


    private String email;
    private String motDePasse;


}
