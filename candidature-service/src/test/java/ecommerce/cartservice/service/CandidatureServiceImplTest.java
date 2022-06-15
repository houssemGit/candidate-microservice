package ecommerce.cartservice.service;

import ecommerce.cartservice.exception.CandidatureNotFoundException;
import ecommerce.cartservice.model.Candidature;
import ecommerce.cartservice.model.CandidatureDTO;
import ecommerce.cartservice.model.Status;
import ecommerce.cartservice.repository.CandidatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

class CandidatureServiceImplTest {

    @Mock
    private CandidatureRepository mockCandidatureRepository;

    private CandidatureServiceImpl candidatureServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        candidatureServiceImplUnderTest = new CandidatureServiceImpl(mockCandidatureRepository);
    }

    @Test
    void testGetAllCandidatures() {
        // Setup
        final List<Candidature> expectedResult = List.of(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"));

        // Configure CandidatureRepository.findAll(...).
        final List<Candidature> candidatures = List.of(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"));
        when(mockCandidatureRepository.findAll()).thenReturn(candidatures);

        // Run the test
        final List<Candidature> result = candidatureServiceImplUnderTest.getAllCandidatures();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllCandidatures_CandidatureRepositoryReturnsNoItems() {
        // Setup
        when(mockCandidatureRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Candidature> result = candidatureServiceImplUnderTest.getAllCandidatures();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetCandidatureById() {
        // Setup
        final Optional<Candidature> expectedResult = Optional.of(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"));

        // Configure CandidatureRepository.findById(...).
        final Optional<Candidature> candidature = Optional.of(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"));
        when(mockCandidatureRepository.findById(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"))).thenReturn(candidature);

        // Run the test
        final Optional<Candidature> result = candidatureServiceImplUnderTest.getCandidatureById(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"));

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetCandidatureById_CandidatureRepositoryReturnsAbsent() {
        // Setup
        when(mockCandidatureRepository.findById(UUID.fromString("b3d6339e-dfba-4a16-96c5-b48048803536"))).thenReturn(Optional.empty());

        // Run the test
        final Optional<Candidature> result = candidatureServiceImplUnderTest.getCandidatureById(UUID.fromString("b3d6339e-dfba-4a16-96c5-b48048803536"));

        // Verify the results
        assertThat(result).isEmpty();
    }

    @Test
    void testCreateCandidature() {
        // Setup
        final CandidatureDTO candidature = new CandidatureDTO("candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate");
        final Candidature expectedResult = new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate");

        // Configure CandidatureRepository.save(...).
        final Candidature candidature1 = new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate");
        when(mockCandidatureRepository.save(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"))).thenReturn(candidature1);

        // Run the test
        final Candidature result = candidatureServiceImplUnderTest.createCandidature(candidature);

        // Verify the results
        assertThat(result).isEqualTo(null);
    }

    @Test
    void testUpdateCandidature() throws CandidatureNotFoundException {
        // Setup
        final CandidatureDTO candidatureDTO = new CandidatureDTO("candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate");
        final Candidature expectedResult = new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate");

        // Configure CandidatureRepository.findById(...).
        final Optional<Candidature> candidature = Optional.of(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"));
        when(mockCandidatureRepository.findById(UUID.fromString("1373e1b4-7bee-4c9c-9556-daccc08957f0"))).thenReturn(candidature);

        // Configure CandidatureRepository.save(...).
        final Candidature candidature1 = new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate");
        when(mockCandidatureRepository.save(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"))).thenReturn(candidature1);

        // Run the test
        final Candidature result = candidatureServiceImplUnderTest.updateCandidature(candidatureDTO, UUID.fromString("1373e1b4-7bee-4c9c-9556-daccc08957f0"));

        // Verify the results
        assertThat(result).isEqualTo(null);
    }



    @Test
    void testUpdateCandidature_ThrowsCandidatureNotFoundException() {
        // Setup
        final CandidatureDTO candidatureDTO = new CandidatureDTO("candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate");

        // Configure CandidatureRepository.findById(...).
        final Optional<Candidature> candidature = Optional.of(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"));
        when(mockCandidatureRepository.findById(UUID.fromString("1373e1b4-7bee-4c9c-9556-daccc08957f0"))).thenReturn(candidature);

        // Configure CandidatureRepository.save(...).
        final Candidature candidature1 = new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate");
        when(mockCandidatureRepository.save(new Candidature(UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"), "candidateId", "offreId", "evaluationId", Status.ACCEPTED, "creationDate"))).thenReturn(candidature1);

        // Run the test
        assertThatThrownBy(() -> candidatureServiceImplUnderTest.updateCandidature(candidatureDTO, UUID.fromString("d6ad056c-13fc-45b3-ba89-ba39e1792772"))).isInstanceOf(CandidatureNotFoundException.class);
    }

    @Test
    void testDeleteCandidature() {
        // Setup
        // Run the test
        candidatureServiceImplUnderTest.deleteCandidature(UUID.fromString("4f7dcd1b-27b7-4b1c-ac31-50c20ec39a3c"));

        // Verify the results
        verify(mockCandidatureRepository).deleteById(UUID.fromString("4f7dcd1b-27b7-4b1c-ac31-50c20ec39a3c"));
    }
}
