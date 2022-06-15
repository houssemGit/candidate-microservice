package ecommerce.cartservice.service;

import ecommerce.cartservice.exception.CandidatureNotFoundException;
import ecommerce.cartservice.model.Candidature;
import ecommerce.cartservice.model.CandidatureDTO;
import ecommerce.cartservice.repository.CandidatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CandidatureServiceImpl implements CandidatureService {

    CandidatureRepository candidatureRepository;

    @Override
    public List<Candidature> getAllCandidatures() {
        return candidatureRepository.findAll();
    }

    @Override
    public Optional<Candidature> getCandidatureById(UUID id) {
        return candidatureRepository.findById(id);
    }

    @Override
    public Candidature createCandidature(CandidatureDTO candidature) {
        Candidature candidate = Candidature.builder().creationDate(candidature.getCreationDate())
                .offreId(candidature.getOffreId())
                .candidateId(candidature.getCandidateId())
                .status(candidature.getStatus()).evaluationId(candidature.getEvaluationId()).build();
        return candidatureRepository.save(candidate);
    }

    @Override
    public Candidature updateCandidature(CandidatureDTO candidatureDTO, UUID id) throws CandidatureNotFoundException {
        Candidature candidateUpdated = Candidature.builder().creationDate(candidatureDTO.getCreationDate())
                .offreId(candidatureDTO.getOffreId())
                .candidateId(candidatureDTO.getCandidateId())
                .status(candidatureDTO.getStatus()).evaluationId(candidatureDTO.getEvaluationId()).build();
        Optional<Candidature> candidate = this.candidatureRepository.findById(id);
        if (candidate.isPresent()) {
            return this.candidatureRepository.save(candidateUpdated);
        } else {
            throw new CandidatureNotFoundException(id);
        }
    }

    @Override
    public void deleteCandidature(UUID id) {
        candidatureRepository.deleteById(id);
    }
}
