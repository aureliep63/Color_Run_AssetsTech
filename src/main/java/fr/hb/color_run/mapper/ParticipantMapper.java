package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.ProfilParticipantDto;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {
    @Mapping(target = "roleId", source = "role.id")
    @Mapping(target = "inscriptionId", source = "inscriptions", qualifiedByName = "mapInscriptionsToIds")
    ProfilParticipantDto toDto(Participant participant);

    @Mapping(target = "role", ignore = true) // Gérer ailleurs
    @Mapping(target = "inscriptions", ignore = true)
    Participant toEntity(ProfilParticipantDto participantDTO);

    @Named("mapInscriptionsToIds")
    static List<Long> mapInscriptionsToIds(List<Inscription> inscriptions) {
        return inscriptions.stream().map(Inscription::getId).collect(Collectors.toList());
    }
}
