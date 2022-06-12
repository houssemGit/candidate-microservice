package ecommerce.cartservice.repository;

import ecommerce.cartservice.model.Candidature;
import ecommerce.cartservice.model.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CandidatureRepositoryTest {

    @Autowired
    private CandidatureRepository candidatureRepository;

    private static UUID id;

    @BeforeEach
    public void setUp(){
        Candidature candidate =  Candidature.builder().status(Status.ACCEPTED).candidateId("123456").offreId("123654").build();
        candidatureRepository.save(candidate);
        this.id = candidate.getId();
    }

    @AfterEach
    void cleanUp() {
        this.candidatureRepository.deleteAll();
    }

    @Test
    public void whenSaveCandidate_ShouldReturnAddedPerson(){
        Candidature candidate =  Candidature.builder().status(Status.ACCEPTED).build();
        assertThat(candidate.getId()).isNull();
        candidatureRepository.save(candidate);
        assertThat(candidate.getId()).isNotNull();
    }

    @Test
    public void whenFindOneCandidate_shouldReturnCandidateDetails(){
        //given
        Candidature candidature =  Candidature.builder().status(Status.ACCEPTED).build();
        //when
        Candidature candidateResponse = candidatureRepository.findById(this.id).get();
        //then
        assertThat(candidateResponse.getOffreId()).isEqualTo("123654");
        assertThat(candidateResponse.getCandidateId()).isEqualTo("123456");
    }

}
