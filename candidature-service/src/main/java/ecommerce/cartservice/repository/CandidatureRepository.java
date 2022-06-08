package ecommerce.cartservice.repository;

import ecommerce.cartservice.model.Candidature;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, UUID> {
}
