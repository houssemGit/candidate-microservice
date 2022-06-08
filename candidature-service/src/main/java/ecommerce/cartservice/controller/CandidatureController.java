package ecommerce.cartservice.controller;

import ecommerce.cartservice.exception.CandidatureNotFoundException;
import ecommerce.cartservice.model.Candidature;
import ecommerce.cartservice.service.CandidatureService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/candidatures")
@Api(value = "Candidature API")
@AllArgsConstructor
public class CandidatureController {

    CandidatureService candidatureService;

    @GetMapping
    public ResponseEntity<List<Candidature>> getAllCandidature() {
        List<Candidature> candidatures = this.candidatureService.getAllCandidatures();
        if (candidatures.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(candidatures, HttpStatus.OK);
        }
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Candidature> getCandidatureById(@PathVariable("id") UUID id) {
        Optional<Candidature> candidate = this.candidatureService.getCandidatureById(id);
        if (candidate.isPresent()) {
            return new ResponseEntity<>(candidate.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Candidature> createCandidature(@RequestBody Candidature candidatureDto) {
        Candidature candidature = this.candidatureService.createCandidature(candidatureDto);
        return new ResponseEntity<>(candidature, HttpStatus.CREATED);

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Candidature> updateCandidature(@PathVariable("id") UUID id, @RequestBody Candidature candidatureDto) {
        try {
            return new ResponseEntity<>(this.candidatureService.updateCandidature(candidatureDto, id), HttpStatus.OK);
        }catch (CandidatureNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCandidature(@PathVariable("id") UUID id) {
        try {
            this.candidatureService.deleteCandidature(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
