package ecommerce.cartservice.repository;

import ecommerce.cartservice.model.Candidature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidatureRepository extends MongoRepository<Candidature, String> {
}
