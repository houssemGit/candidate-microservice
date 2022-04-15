package ecommerce.cartservice.service;

import ecommerce.cartservice.exception.CandidateNotFoundException;
import ecommerce.cartservice.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CandidateService {
     List<Candidate> getAllCandidates();
     Optional<Candidate> getCandidateById(UUID id);
     Candidate createCandidate(Candidate candidate);
     Candidate updateCandidate(Candidate candidate, UUID id) throws CandidateNotFoundException;
     void deleteCandidate(UUID id);
}
