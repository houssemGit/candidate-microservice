package ecommerce.cartservice.service;

import ecommerce.cartservice.exception.CandidatureNotFoundException;
import ecommerce.cartservice.model.Candidature;
import ecommerce.cartservice.model.CandidatureDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CandidatureService {
     public List<Candidature> getAllCandidatures();

     public Optional<Candidature> getCandidatureById(UUID id);

     public Candidature createCandidature(CandidatureDTO candidature);

     public Candidature updateCandidature(CandidatureDTO candidatureDto, UUID id) throws CandidatureNotFoundException;

     public void deleteCandidature(UUID id);
}