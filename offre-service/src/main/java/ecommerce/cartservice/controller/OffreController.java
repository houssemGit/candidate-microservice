package ecommerce.cartservice.controller;

import ecommerce.cartservice.exception.OffreNotFoundException;
import ecommerce.cartservice.model.Offre;
import ecommerce.cartservice.service.OffreService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/offres")
@Api(value = "Offre API")
@AllArgsConstructor
public class OffreController {

	@Autowired
    OffreService offreService;

    @GetMapping
    public ResponseEntity<List<Offre>> getAllOffre() {
        List<Offre> offres = this.offreService.getAllOffres();
        if (offres.isEmpty()) {
        	
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(offres, HttpStatus.OK);
        }
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Offre> getOffreById(@PathVariable("id") UUID id) {
        Optional<Offre> offre = this.offreService.getOffreById(id);
        if (offre.isPresent()) {
            return new ResponseEntity<>(offre.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Offre> createOffre(@RequestBody Offre offreDto) {
        Offre offre = this.offreService.createOffre(offreDto);
        return new ResponseEntity<>(offre, HttpStatus.CREATED);

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Offre> updateOffre(@PathVariable("id") UUID id, @RequestBody Offre offreDto) {
        try {
            return new ResponseEntity<>(this.offreService.updateOffre(offreDto, id), HttpStatus.OK);
        }catch (OffreNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOffre(@PathVariable("id") UUID id) {
        try {
            this.offreService.deleteOffre(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
