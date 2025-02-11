package fr.hb.color_run.service;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.model.Parcours;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParcoursService {
    List<ParcoursDto> getParcours();

    ParcoursDto getParcoursById(Long id);

    Parcours saveParcours(ParcoursDto parcoursDto);

    void deleteParcoursById(Long id);
}
