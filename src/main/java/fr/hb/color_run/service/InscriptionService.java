package fr.hb.color_run.service;

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.model.Inscription;

import java.util.List;

public interface InscriptionService {
    List<InscriptionDto> getInscriptions();

    InscriptionDto getInscriptionById(Long id);

    Inscription saveInscription(InscriptionDto inscriptionDto);

    void deleteInscription(Long id);
}
