package ecommerce.cartservice.repository;

import ecommerce.cartservice.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface OffreRepository extends JpaRepository<Offre, UUID> {

}
