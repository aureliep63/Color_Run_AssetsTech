package fr.hb.color_run.service.Impl;


import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.repository.ParticipantRepository;
import fr.hb.color_run.repository.RoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	private ParticipantRepository participantRepository;

	public CustomUserDetailsService(ParticipantRepository participantRepository, RoleRepository roleRepository) {
		this.participantRepository = participantRepository;
	}

//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//		Optional<Participant> participantResult = participantRepository.findByEmail(email);
//		if(participantResult.isEmpty()) {
//			throw new UsernameNotFoundException(email + " not found.");
//		}
//		Participant participant = participantResult.get();
//		return new User(participant.getEmail(), participant.getMotDePasse(), getParticipantRoles(participant.getRole()));
//	}

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Participant> participantResult = participantRepository.findByEmail(email);
		if (participantResult.isEmpty()) {
			throw new UsernameNotFoundException(email + " not found.");
		}
		Participant participant = participantResult.get();
		System.out.println("Mot de passe dans la base de données : " + participant.getMotDePasse());
		return new User(participant.getEmail(), participant.getMotDePasse(), getParticipantRoles(participant.getRole()));
	}


	private List<GrantedAuthority> getParticipantRoles(Role role) {
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		if (role != null) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRole().toUpperCase()));
		}
		return roles;
	}
}
