package fr.hb.color_run.controller.rest;

import fr.hb.color_run.dto.ConnexionParticipantDto;
import fr.hb.color_run.dto.ProfilParticipantDto;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.repository.ParticipantRepository;
import fr.hb.color_run.service.Impl.TokenService;
import fr.hb.color_run.service.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participants")
public class ParticipantControllerRest {

    private ParticipantService participantService;
    private TokenService tokenService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private final ParticipantRepository participantRepository;

    public ParticipantControllerRest(TokenService tokenService, ParticipantService participantService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                                     ParticipantRepository participantRepository) {
        this.tokenService = tokenService;
        this.participantService = participantService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.participantRepository = participantRepository;
    }

    @GetMapping("")
    public List<ProfilParticipantDto> getAllParticipants() {
        return participantService.getParticipants();
    }

    @GetMapping("/{id}")
    public ProfilParticipantDto getParticipantById(@PathVariable Long id) {
        return participantService.getParticipantById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Participant saveParticipant(@RequestBody ProfilParticipantDto participantDto) {
        participantDto.setMotDePasse(passwordEncoder.encode(participantDto.getMotDePasse()));
        return participantService.saveParticipant(participantDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
    }

    @PutMapping("/{id}")
    public Participant updateParticipant(@PathVariable Long id, @RequestBody ProfilParticipantDto participantDto) {
        participantDto.setId(id);
        return participantService.saveParticipant(participantDto);
    }


//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody ConnexionParticipantDto loginRequest){
//        // try catch permet de gérer l'erreur
//        try {
//            // .authenticate va essayer d'authentifier l'objet en paramètre
//            Authentication authenticationObject = new UsernamePasswordAuthenticationToken(
//                    loginRequest.getEmail(),
//                    loginRequest.getMotDePasse());
//            authenticationObject =  authenticationManager.authenticate(authenticationObject);
//
//            String token = tokenService.generateToken(authenticationObject);
//
//            return ResponseEntity.ok(token);
//        } catch (BadCredentialsException ex){
//            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ConnexionParticipantDto loginRequest){
        // Vérifiez que le mot de passe encodé correspond au mot de passe stocké dans la base de données
        Optional<Participant> participantResult = participantRepository.findByEmail(loginRequest.getEmail());
        if (participantResult.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Participant participant = participantResult.get();
        boolean passwordMatches = passwordEncoder.matches(
                loginRequest.getMotDePasse(),
                participant.getMotDePasse());
        System.out.println(passwordEncoder.encode(loginRequest.getMotDePasse()));
       if (!passwordMatches) {

              return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
          }
        try {
            Authentication authenticationObject = new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getMotDePasse());
            System.out.println("Tentative d'authentification pour : " + loginRequest.getEmail());
            authenticationObject =  authenticationManager.authenticate(authenticationObject);
            System.out.println("Authentification réussie pour : " + loginRequest.getEmail());

            String token = tokenService.generateToken(authenticationObject);

            return ResponseEntity.ok(token);
        } catch (BadCredentialsException ex) {
            System.out.println("Échec de l'authentification pour : " + loginRequest.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }




}
