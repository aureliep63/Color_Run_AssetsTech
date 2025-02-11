package fr.hb.color_run.service;

import fr.hb.color_run.dto.ProfilParticipantDto;
import fr.hb.color_run.model.Participant;

import java.util.List;

public interface ParticipantService {
    List<ProfilParticipantDto> getParticipants();

    ProfilParticipantDto getParticipantById(Long id);

    Participant saveParticipant(ProfilParticipantDto profilParticipantDto);

    void deleteParticipant(Long id);
}
