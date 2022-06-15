package ecommerce.cartservice.controller;

import ecommerce.cartservice.exception.CandidatureNotFoundException;
import ecommerce.cartservice.model.Candidature;
import ecommerce.cartservice.model.CandidatureDTO;
import ecommerce.cartservice.model.Status;
import ecommerce.cartservice.service.CandidatureService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CandidatureController.class)
class CandidatureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CandidatureService mockCandidatureService;

    @Test
    void testGetAllCandidature() throws Exception {
        // Setup
        // Configure CandidatureService.getAllCandidatures(...).
        final List<Candidature> candidatures = Arrays.asList(new Candidature(UUID.fromString("e3bbb02f-5561-4c85-87da-5ba9037658c0"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"));
        when(mockCandidatureService.getAllCandidatures()).thenReturn(candidatures);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/candidatures")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetAllCandidature_CandidatureServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockCandidatureService.getAllCandidatures()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/candidatures")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        //assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getContentAsString()).isEqualTo("");
    }


}
