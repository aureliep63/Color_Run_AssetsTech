package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Participant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T18:54:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class InscriptionMapperImpl implements InscriptionMapper {

    @Override
    public InscriptionDto toDto(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }

        InscriptionDto inscriptionDto = new InscriptionDto();

        inscriptionDto.setParticipantId( inscriptionParticipantId( inscription ) );
        inscriptionDto.setCourseId( inscriptionCourseId( inscription ) );
        inscriptionDto.setId( inscription.getId() );
        inscriptionDto.setGenerationDossard( inscription.getGenerationDossard() );

        return inscriptionDto;
    }

    @Override
    public Inscription toEntity(InscriptionDto inscriptionDTO) {
        if ( inscriptionDTO == null ) {
            return null;
        }

        Inscription inscription = new Inscription();

        inscription.setId( inscriptionDTO.getId() );
        inscription.setGenerationDossard( inscriptionDTO.getGenerationDossard() );

        return inscription;
    }

    private Long inscriptionParticipantId(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }
        Participant participant = inscription.getParticipant();
        if ( participant == null ) {
            return null;
        }
        Long id = participant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long inscriptionCourseId(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }
        Course course = inscription.getCourse();
        if ( course == null ) {
            return null;
        }
        Long id = course.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
