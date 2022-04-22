package ecommerce.cartservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String candidateId;
    private String offreId;
    private String evaluationId;
    private Status status;
    private String creationDate;
}
