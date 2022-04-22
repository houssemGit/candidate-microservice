package ecommerce.cartservice.service;

import ecommerce.cartservice.exception.OffreNotFoundException;
import ecommerce.cartservice.model.Offre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface OffreService {
     List<Offre> getAllOffres();
     Optional<Offre> getOffreById(UUID id);
     Offre createOffre(Offre Offre);
     Offre updateOffre(Offre Offre, UUID id) throws OffreNotFoundException;
     void deleteOffre(UUID id);
}
