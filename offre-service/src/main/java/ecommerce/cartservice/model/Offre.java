package ecommerce.cartservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Offre {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        private String intitulé_offre;
        private String Description;
        private String requirements;
        private int experience;
        private double salaire;

}
