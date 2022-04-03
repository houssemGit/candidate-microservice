package com.esprit.candidate.service;

import com.esprit.candidate.exception.CandidateNotFoundException;
import com.esprit.candidate.model.Candidate;
import com.esprit.candidate.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> getCandidateById(UUID id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Candidate candidateDto, UUID id) throws CandidateNotFoundException {
        Optional<Candidate> candidate = this.candidateRepository.findById(id);
        if (candidate.isPresent()) {
            return this.candidateRepository.save(candidateDto);
        } else {
            throw new CandidateNotFoundException(id);
        }
    }

    @Override
    public void deleteCandidate(UUID id) {
        candidateRepository.deleteById(id);
    }
}
