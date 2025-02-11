package fr.hb.color_run.service.Impl;

import fr.hb.color_run.dto.ProfilParticipantDto;
import fr.hb.color_run.mapper.ParticipantMapper;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.repository.InscriptionRepository;
import fr.hb.color_run.repository.ParticipantRepository;
import fr.hb.color_run.repository.RoleRepository;
import fr.hb.color_run.service.ParticipantService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantRepository participantRepository;
    private InscriptionRepository inscriptionRepository;
    private RoleRepository roleRepository;
    private ParticipantMapper participantMapper;
    private PasswordEncoder passwordEncoder;

    public ParticipantServiceImpl(ParticipantRepository participantRepository, InscriptionRepository inscriptionRepository, RoleRepository roleRepository, ParticipantMapper participantMapper, PasswordEncoder passwordEncoder) {
        this.participantRepository = participantRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.roleRepository = roleRepository;
        this.participantMapper = participantMapper;
        this.passwordEncoder = passwordEncoder;
    }

    private ProfilParticipantDto participantDto;

    @Override
    public List<ProfilParticipantDto> getParticipants(){
        List<Participant> participants = participantRepository.findAll();
        return  participants.stream()
                .map(participantMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfilParticipantDto getParticipantById(Long id){
        return participantRepository.findById(id)
                .map(participantMapper::toDto)
                .orElse(null);
    }

    @Override
    public Participant saveParticipant(ProfilParticipantDto profilParticipantDto) {
        Participant participant = participantMapper.toEntity(profilParticipantDto);
        if (participantRepository.findByEmail(participant.getEmail()).isPresent()) {
            throw new RuntimeException("Cet email est déjà utilisé !");
        }
            if (!participant.getMotDePasse().startsWith("$2a$")) {
                participant.setMotDePasse(passwordEncoder.encode(participant.getMotDePasse()));
            }
            if (profilParticipantDto.getInscriptionId() != null && !profilParticipantDto.getInscriptionId().isEmpty()) {
                List<Inscription> inscriptions = inscriptionRepository.findAllById(profilParticipantDto.getInscriptionId());
                participant.setInscriptions(inscriptions);
            }
            if (profilParticipantDto.getRoleId() != null) {
                Role role = roleRepository.findById(profilParticipantDto.getRoleId()).orElse(null);
                participant.setRole(role);
            }

            return participantRepository.save(participant);
        }


    @Override
    public void deleteParticipant(Long id){
        participantRepository.deleteById(id);
    }

}
