package fr.hb.color_run.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcoursDto {

     Long id;
    private int ordre;
    private double latitude;
    private double longitude;
    private Long courseId;
}
