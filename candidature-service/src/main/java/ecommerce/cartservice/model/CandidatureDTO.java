package ecommerce.cartservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidatureDTO {
    private String candidateId;
    private String offreId;
    private String evaluationId;
    private Status status;
    private String creationDate;
}
