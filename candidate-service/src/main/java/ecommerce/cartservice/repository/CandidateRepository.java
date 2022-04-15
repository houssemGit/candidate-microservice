package ecommerce.cartservice.repository;

import ecommerce.cartservice.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    List<Candidate> findByName(String name);
    List<Candidate> findByFirstName(String firstName);
    List<Candidate> findByEmail(String email);
}
