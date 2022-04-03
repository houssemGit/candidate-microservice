package com.esprit.candidate.controller;

import com.esprit.candidate.exception.CandidateNotFoundException;
import com.esprit.candidate.model.Candidate;
import com.esprit.candidate.service.CandidateService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/candidates")
@Api(value = "Candidate API")
@AllArgsConstructor
public class CandidateController {

    CandidateService candidateService;

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidate() {
        List<Candidate> candidates = this.candidateService.getAllCandidates();
        if (candidates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(candidates, HttpStatus.OK);
        }
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") UUID id) {
        Optional<Candidate> candidate = this.candidateService.getCandidateById(id);
        if (candidate.isPresent()) {
            return new ResponseEntity<>(candidate.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidateDto) {
        Candidate candidate = this.candidateService.createCandidate(candidateDto);
        return new ResponseEntity<>(candidate, HttpStatus.CREATED);

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") UUID id, @RequestBody Candidate candidateDto) {
        try {
            return new ResponseEntity<>(this.candidateService.updateCandidate(candidateDto, id), HttpStatus.OK);
        }catch (CandidateNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCandidate(@PathVariable("id") UUID id) {
        try {
            this.candidateService.deleteCandidate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
