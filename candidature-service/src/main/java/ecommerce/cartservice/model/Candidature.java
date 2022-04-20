package ecommerce.cartservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "candidatures")
public class Candidature {

    @Id
    private String id;
    private String candidateId;
    private String offreId;
    private List<String> evaluations;
    private Status status;
    private String creationDate;
}
