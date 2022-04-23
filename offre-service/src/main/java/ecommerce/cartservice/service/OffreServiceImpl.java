package ecommerce.cartservice.service;

import ecommerce.cartservice.exception.OffreNotFoundException;
import ecommerce.cartservice.repository.OffreRepository;
import ecommerce.cartservice.model.Offre;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OffreServiceImpl implements OffreService {

	@Autowired
    OffreRepository offreRepository;

    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    @Override
    public Optional<Offre> getOffreById(UUID id) {
        return offreRepository.findById(id);
    }

    @Override
    public Offre createOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public Offre updateOffre(Offre offreDto, UUID id) throws OffreNotFoundException {
        Optional<Offre> offre = this.offreRepository.findById(id);
        if (offre.isPresent()) {
            offreDto.setId(id);
            return this.offreRepository.save(offreDto);
        } else {
            throw new OffreNotFoundException(id);
        }
    }

    @Override
    public void deleteOffre(UUID id) {
        offreRepository.deleteById(id);
    }
}
