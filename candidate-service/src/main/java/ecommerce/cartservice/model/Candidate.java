package ecommerce.cartservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidate {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        private String name;
        private String firstName;
        private String email;
}
