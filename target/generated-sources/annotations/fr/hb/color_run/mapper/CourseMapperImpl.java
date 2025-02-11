package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T18:54:37+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDto toDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setParcoursId( CourseMapper.mapParcoursToIds( course.getParcours() ) );
        courseDto.setInscriptionId( CourseMapper.mapInscriptionsToIds( course.getInscriptions() ) );
        courseDto.setId( course.getId() );
        courseDto.setNom( course.getNom() );
        courseDto.setDescription( course.getDescription() );
        courseDto.setDateHeure( course.getDateHeure() );
        courseDto.setLieu( course.getLieu() );
        courseDto.setDistance( course.getDistance() );
        courseDto.setNbParticipantMax( course.getNbParticipantMax() );
        courseDto.setPrixParticipation( course.getPrixParticipation() );
        courseDto.setAvecObstacle( course.isAvecObstacle() );
        courseDto.setCauseSoutenu( course.getCauseSoutenu() );

        return courseDto;
    }

    @Override
    public Course toEntity(CourseDto courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( courseDTO.getId() );
        course.setNom( courseDTO.getNom() );
        course.setDescription( courseDTO.getDescription() );
        course.setDateHeure( courseDTO.getDateHeure() );
        course.setLieu( courseDTO.getLieu() );
        course.setDistance( courseDTO.getDistance() );
        course.setNbParticipantMax( courseDTO.getNbParticipantMax() );
        course.setPrixParticipation( courseDTO.getPrixParticipation() );
        course.setAvecObstacle( courseDTO.isAvecObstacle() );
        course.setCauseSoutenu( courseDTO.getCauseSoutenu() );

        return course;
    }
}
