//package fr.hb.color_run.repository;
//
//import fr.hb.color_run.model.Parcours;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//class ParcoursRepositoryTest {
//
//    @Autowired
//    private ParcoursRepository parcoursRepository;
//
//    @Test
//    public void testFindAll() {
//
//        // Récupérer tous les rôles
//        List<Parcours> parcours = parcoursRepository.findAll();
//
//        // Vérifier que les rôles sont bien trouvés
//        assertThat(parcours).isNotEmpty();
//        assertThat(parcours.size()).isEqualTo(3);
//        assertThat(parcours).extracting(Parcours::getOrdre).contains(1, 2, 3);}
//
//}