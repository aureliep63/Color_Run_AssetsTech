package fr.hb.color_run.service.Impl;

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.mapper.InscriptionMapper;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.repository.CourseRepository;
import fr.hb.color_run.repository.InscriptionRepository;
import fr.hb.color_run.repository.ParticipantRepository;
import fr.hb.color_run.service.InscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    private InscriptionRepository inscriptionRepository;
    private ParticipantRepository participantRepository;
    private CourseRepository courseRepository;
    private InscriptionMapper inscriptionMapper;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository, ParticipantRepository participantRepository, CourseRepository courseRepository, InscriptionMapper inscriptionMapper) {
        this.inscriptionRepository = inscriptionRepository;
        this.participantRepository = participantRepository;
        this.courseRepository = courseRepository;
        this.inscriptionMapper = inscriptionMapper;
    }

    private InscriptionDto inscriptionDto;

    @Override
    public List<InscriptionDto> getInscriptions() {
        List<Inscription> inscriptions = inscriptionRepository.findAll();
        return inscriptions.stream()
                .map(inscriptionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public InscriptionDto getInscriptionById(Long id) {
       return inscriptionRepository.findById(id)
                                   .map(inscriptionMapper::toDto)
                                   .orElse(null);

    }

    @Override
    public Inscription saveInscription(InscriptionDto inscriptionDto) {
        Inscription inscription = inscriptionMapper.toEntity(inscriptionDto);

        if(inscriptionDto.getParticipantId() != null){
            Participant participant= participantRepository.findById(inscriptionDto.getParticipantId()).orElse(null);
            inscription.setParticipant(participant);
        }

        if(inscriptionDto.getCourseId() != null){
            Course course= courseRepository.findById(inscriptionDto.getCourseId()).orElse(null);
            inscription.setCourse(course);
        }

        return inscriptionRepository.save(inscription);
    }

    @Override
    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }
}
