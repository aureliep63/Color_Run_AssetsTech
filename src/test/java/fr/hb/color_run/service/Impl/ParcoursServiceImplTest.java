package fr.hb.color_run.service.Impl;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
public class ParcoursServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username="admin", password="admin", roles="ADMIN")
    void shouldReturnAllParcours() throws Exception {
    mockMvc.perform(get("/vueCourses"))
            .andExpect(status().isOk())
            .andExpect(view().name("vueCourses/list"))
            .andExpect(model().attributeExists("courses"));
    }


}

