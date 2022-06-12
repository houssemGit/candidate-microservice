package ecommerce.cartservice.service;

import ecommerce.cartservice.model.Candidature;
import ecommerce.cartservice.model.Status;
import ecommerce.cartservice.repository.CandidatureRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CandidatureServiceTest {

    @InjectMocks
    private CandidatureService candidatureService;

    @Mock
    private CandidatureRepository candidatureRepository;

    @Test
    public void getPerson_returnPersonDetails(){
        //given
        Candidature candidature= Candidature.builder().status(Status.ACCEPTED).candidateId("123456").offreId("123654").build();
        when(candidatureRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(candidature));
        //when
        Candidature candidatureResponse = candidatureService.getCandidatureById(Mockito.any(UUID.class)).get();
        //then
        assertThat(candidatureResponse.getOffreId()).isEqualTo(candidature.getOffreId());
        assertThat(candidatureResponse.getCandidateId()).isEqualTo(candidature.getCandidateId());
    }

    @Test
    public void getAllCandidates_returnAllCandidatesDetails() {
    /*    when(candidateRepository.findAll())
                .thenReturn(Stream.of(new Candidate("houssem.eleuch@softylis.tn", "Eleuch", "Houssem"), new Person("fakhri.amri@softylis.tn", "amri", "fakhri"))
                        .collect(Collectors.toList()));
        assertThat(candidateService.getCandidateById("id"))
                .isNotEmpty()
                .hasSize(2)
                .contains(new Person("fakhri.amri@softylis.tn", "amri", "fakhri"));
    }*/
    }
    @Rollback
    @Test
    public void deletePerson_returnDeletedPerson(){
        //assertThat(candidateService.deleteCandidate("houssem.eleuch@softylis.tn")).isEqualTo("personne supprimé");
    }


}
