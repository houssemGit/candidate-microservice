package ecommerce.cartservice.service;

import ecommerce.cartservice.exception.CandidatureNotFoundException;
import ecommerce.cartservice.model.Candidature;
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
    public Candidature createCandidature(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    @Override
    public Candidature updateCandidature(Candidature candidatureDto, UUID id) throws CandidatureNotFoundException {
        Optional<Candidature> candidate = this.candidatureRepository.findById(id);
        if (candidate.isPresent()) {
            return this.candidatureRepository.save(candidatureDto);
        } else {
            throw new CandidatureNotFoundException(id);
        }
    }

    @Override
    public void deleteCandidature(UUID id) {
        candidatureRepository.deleteById(id);
    }
}
