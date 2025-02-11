package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.model.Parcours;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParcoursMapper {

    @Mapping(target = "courseId", source = "course.id")
    ParcoursDto toDto(Parcours parcours);

    @Mapping(target = "course", ignore = true) // Gérer ailleurs
    Parcours toEntity(ParcoursDto parcoursDto);

    List<ParcoursDto> toDtoList(List<Parcours> parcoursList);

    List<Parcours> toEntityList(List<ParcoursDto> parcoursDtoList);
}