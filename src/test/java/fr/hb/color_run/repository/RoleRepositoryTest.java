package fr.hb.color_run.repository;

import fr.hb.color_run.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertFalse;

@SpringBootTest
@ActiveProfiles("test")
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testFindAll() {

        // Récupérer tous les rôles
        List<Role> roles = roleRepository.findAll();

        // Vérifier que les rôles sont bien trouvés
        assertThat(roles).isNotEmpty();
        assertThat(roles.size()).isEqualTo(3);
        assertThat(roles).extracting(Role::getRole).contains("ADMIN", "PARTICIPANT");
    }


    @Test
        // Test pour sélectionner un seul role
    void shouldSelectRoleById() {
        // Arrange
        Role role = roleRepository.findById(1L).get();
        // Act
        assertEquals("ADMIN", role.getRole());
    }

    @Test
        // Test pour ajouter un nouveau role
    void shouldAddOneRole() {
        // Arrange
        Role role = new Role();
        role.setRole("ORGANISATEUR");
        // Act
        Role savedRole=roleRepository.save(role);
        // Assert
        assertNotNull(savedRole.getId()); // vérifie que id n'est pas null
        assertEquals("ORGANISATEUR", savedRole.getRole());
    }
    @Test
        //Test pour modifier une personne
    void shouldUpdateOneRole() {
        // Arrange
        Role role = roleRepository.findById(3L).get(); // on récup le 3eme ds la liste
        role.setRole("CREATEUR"); // je lui change son role, au lieu de ORGA c'est CREA

        // Act
        Role savedRole = roleRepository.save(role); // je sauvegarde

        // Assert
        assertEquals("CREATEUR", savedRole.getRole()); // je vérifie bien que c'est CREA, si je met ORGA le test sera faux
    }

    @Test
        //Test pour supprimer une personne
    void shouldDeleteOneRole() {
        // Arrange
        Role role = roleRepository.findById(3L).get();
        // Act
        roleRepository.delete(role);
        // Assert
        assertFalse("ROLE not deleted", roleRepository.existsById(3L));
    }
}

