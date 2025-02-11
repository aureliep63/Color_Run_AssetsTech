package fr.hb.color_run.initialisation;

import fr.hb.color_run.dto.*;
import fr.hb.color_run.service.Impl.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

    CourseServiceImpl courseService;
    InscriptionServiceImpl inscriptionService;
    ParcoursServiceImpl parcoursService;
    ParticipantServiceImpl participantService;
    RoleServiceImpl roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception{

        RoleDto adminRole=new RoleDto();
        adminRole.setRole("ADMIN");
        roleService.saveRole(adminRole);

        RoleDto participantRole=new RoleDto();
        participantRole.setRole("PARTICIPANT");
        roleService.saveRole(participantRole);

        RoleDto organisateurRole=new RoleDto();
        organisateurRole.setRole("ORGANISATEUR");
        roleService.saveRole(organisateurRole);



        ProfilParticipantDto p1=new ProfilParticipantDto();
        p1.setNom("admin");
        p1.setPrenom("Jean");
        p1.setEmail("admin@admin.com");
        p1.setMotDePasse(passwordEncoder.encode("admin"));
        p1.setPhoto("https://www.paris-medecine-esthetique.fr/wp-content/uploads/2021/04/beaute-homme-dr-mayeux-medecine-esthetique-paris8-cover-1536x1120.jpg.webp");
        p1.setRoleId(1L);
        participantService.saveParticipant(p1);

        ProfilParticipantDto p2=new ProfilParticipantDto();
        p2.setNom("createur");
        p2.setPrenom("Marie");
        p2.setEmail("createur@createur.com");
        p2.setMotDePasse(passwordEncoder.encode("createur"));
        p2.setPhoto("https://www.utopix.com/fr/blog/wp-content/uploads/2024/04/06f0aba6-e34c-4025-a17e-60ebaee7ad84_1-scaled.jpg");
        p2.setRoleId(2L);
        participantService.saveParticipant(p2);

        ProfilParticipantDto p3 = new ProfilParticipantDto();
        p3.setNom("participant1");
        p3.setPrenom("Paul");
        p3.setEmail("participant1@participant.com");
        p3.setMotDePasse(passwordEncoder.encode("participant1"));
        p3.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFRfvDeMy95qNw8j0_1PtuN89UaUOkWM6NwQ&s");
        p3.setRoleId(3L);
        participantService.saveParticipant(p3);

        ProfilParticipantDto p4 = new ProfilParticipantDto();
        p4.setNom("participant2");
        p4.setPrenom("Rosy");
        p4.setEmail("participant2@participant.com");
        p4.setMotDePasse(passwordEncoder.encode("participant2"));
        p4.setPhoto("https://as1.ftcdn.net/jpg/01/05/63/24/1000_F_105632490_xr18ylLjgVkBhgwu7MefPDN7PjmyAqSy.jpg");
        p4.setRoleId(3L);
        participantService.saveParticipant(p4);

        ProfilParticipantDto p5 = new ProfilParticipantDto();
        p5.setNom("participant3");
        p5.setPrenom("Louane");
        p5.setEmail("participant3@participant.com");
        p5.setMotDePasse(passwordEncoder.encode("participant3"));
        p5.setPhoto("https://www.paris-medecine-esthetique.fr/wp-content/uploads/2021/04/beaute-homme-dr-mayeux-medecine-esthetique-paris8-cover-1536x1120.jpg.webp");
        p5.setRoleId(3L);
        participantService.saveParticipant(p5);

        ProfilParticipantDto p6 = new ProfilParticipantDto();
        p6.setNom("participant4");
        p6.setPrenom("Carla");
        p6.setEmail("participant4@participant.com");
        p6.setMotDePasse(passwordEncoder.encode("participant4"));
        p6.setPhoto("https://www.femmes-numerique.fr/wp-content/uploads/2023/06/Photo_officielle_EM-scaled.jpg");
        p6.setRoleId(3L);
        participantService.saveParticipant(p6);




        CourseDto c1 = new CourseDto();
        c1.setNom("Course1");
        c1.setDescription("Description de la course 1 avec obstable");
        c1.setDateHeure(LocalDateTime.of(2025, 4, 30, 9, 00, 0));
        c1.setLieu("Lyon");
        c1.setDistance(3.3F);
        c1.setNbParticipantMax(300);
        c1.setPrixParticipation(12F);
        c1.setAvecObstacle(true);
        c1.setCauseSoutenu("Les Restos du cœur");
        courseService.saveCourse(c1);

        CourseDto c2 = new CourseDto();
        c2.setNom("Course2");
        c2.setDescription("Description de la course 2 sans obstacle");
        c2.setDateHeure(LocalDateTime.of(2025, 4, 30, 11, 30, 0));
        c2.setLieu("Clermont-Ferrand");
        c2.setDistance(9.2F);
        c2.setNbParticipantMax(450);
        c2.setPrixParticipation(9.9F);
        c2.setAvecObstacle(false);
        c2.setCauseSoutenu("Les Secours catholique");
        courseService.saveCourse(c2);

        CourseDto c3 = new CourseDto();
        c3.setNom("Course3");
        c3.setDescription("Description de la course 3 avec obstable");
        c3.setDateHeure(LocalDateTime.of(2025, 4, 30, 15, 00, 0));
        c3.setLieu("Montpellier");
        c3.setDistance(14.5F);
        c3.setNbParticipantMax(340);
        c3.setPrixParticipation(15F);
        c3.setAvecObstacle(true);
        c3.setCauseSoutenu("La Croix-Rouge");
        courseService.saveCourse(c3);

        CourseDto c4 = new CourseDto();
        c4.setNom("Course4");
        c4.setDescription("Description de la course 4 sans obstacle");
        c4.setDateHeure(LocalDateTime.of(2025, 4, 30, 17, 30, 0));
        c4.setLieu("Nantes");
        c4.setDistance(6.7F);
        c4.setNbParticipantMax(250);
        c4.setPrixParticipation(8.9F);
        c4.setAvecObstacle(false);
        c4.setCauseSoutenu("Médecins sans frontières");
        courseService.saveCourse(c4);

        ParcoursDto pLyon1 = new ParcoursDto();
        pLyon1.setLatitude(45.75638);
        pLyon1.setLongitude(4.85626);
        pLyon1.setOrdre(1);
        pLyon1.setCourseId(1L);
        parcoursService.saveParcours(pLyon1);

        ParcoursDto pLyon2 = new ParcoursDto();
        pLyon2.setLatitude(45.75985);
        pLyon2.setLongitude(4.84373);
        pLyon2.setCourseId(1L);
        pLyon2.setOrdre(2);
        parcoursService.saveParcours(pLyon2);

        ParcoursDto pLyon3 = new ParcoursDto();
        pLyon3.setLatitude(45.75985);
        pLyon3.setLongitude(4.84373);
        pLyon3.setOrdre(3);
        pLyon3.setCourseId(1L);
        parcoursService.saveParcours(pLyon3);

        ParcoursDto pLyon4 = new ParcoursDto();
        pLyon4.setLatitude(45.75638);
        pLyon4.setLongitude(4.85626);
        pLyon4.setOrdre(4);
        pLyon4.setCourseId(1L);
        parcoursService.saveParcours(pLyon4);

        InscriptionDto i1 = new InscriptionDto();
        i1.setParticipantId(3L);
        i1.setCourseId(1L);
        i1.setGenerationDossard("D1");
        inscriptionService.saveInscription(i1);

        InscriptionDto i2 = new InscriptionDto();
        i2.setParticipantId(4L);
        i2.setCourseId(1L);
        i2.setGenerationDossard("D2");
        inscriptionService.saveInscription(i2);

        InscriptionDto i3 = new InscriptionDto();
        i3.setParticipantId(4L);
        i3.setCourseId(1L);
        i3.setGenerationDossard("D3");
        inscriptionService.saveInscription(i3);
    }
}
