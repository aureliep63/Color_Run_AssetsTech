package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.model.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InscriptionMapper {
    @Mapping(target = "participantId", source = "participant.id")
    @Mapping(target = "courseId", source = "course.id")
    InscriptionDto toDto(Inscription inscription);

    @Mapping(target = "participant", ignore = true)
    @Mapping(target = "course", ignore = true)
    Inscription toEntity(InscriptionDto inscriptionDTO);
}
