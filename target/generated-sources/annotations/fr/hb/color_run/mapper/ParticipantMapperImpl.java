package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.ProfilParticipantDto;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T18:54:37+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ParticipantMapperImpl implements ParticipantMapper {

    @Override
    public ProfilParticipantDto toDto(Participant participant) {
        if ( participant == null ) {
            return null;
        }

        ProfilParticipantDto profilParticipantDto = new ProfilParticipantDto();

        profilParticipantDto.setRoleId( participantRoleId( participant ) );
        profilParticipantDto.setInscriptionId( ParticipantMapper.mapInscriptionsToIds( participant.getInscriptions() ) );
        profilParticipantDto.setId( participant.getId() );
        profilParticipantDto.setNom( participant.getNom() );
        profilParticipantDto.setPrenom( participant.getPrenom() );
        profilParticipantDto.setEmail( participant.getEmail() );
        profilParticipantDto.setPhoto( participant.getPhoto() );
        profilParticipantDto.setMotDePasse( participant.getMotDePasse() );

        return profilParticipantDto;
    }

    @Override
    public Participant toEntity(ProfilParticipantDto participantDTO) {
        if ( participantDTO == null ) {
            return null;
        }

        Participant participant = new Participant();

        participant.setId( participantDTO.getId() );
        participant.setNom( participantDTO.getNom() );
        participant.setPrenom( participantDTO.getPrenom() );
        participant.setEmail( participantDTO.getEmail() );
        participant.setMotDePasse( participantDTO.getMotDePasse() );
        participant.setPhoto( participantDTO.getPhoto() );

        return participant;
    }

    private Long participantRoleId(Participant participant) {
        if ( participant == null ) {
            return null;
        }
        Role role = participant.getRole();
        if ( role == null ) {
            return null;
        }
        Long id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
