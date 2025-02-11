package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Parcours;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "parcoursId", source = "parcours", qualifiedByName = "mapParcoursToIds")
    @Mapping(target = "inscriptionId", source = "inscriptions", qualifiedByName = "mapInscriptionsToIds")
    CourseDto toDto(Course course);

    @Mapping(target = "parcours", ignore = true) // Gérer l'association ailleurs
    @Mapping(target = "inscriptions", ignore = true)
    Course toEntity(CourseDto courseDTO);

    @Named("mapParcoursToIds")
    static List<Long> mapParcoursToIds(List<Parcours> parcours) {
        return parcours.stream().map(Parcours::getId).collect(Collectors.toList());
    }

    @Named("mapInscriptionsToIds")
    static List<Long> mapInscriptionsToIds(List<Inscription> inscriptions) {
        return inscriptions.stream().map(Inscription::getId).collect(Collectors.toList());
    }
}

