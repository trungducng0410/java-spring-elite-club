package com.club.eliteclub.controller;

import com.club.eliteclub.dto.ClubDTO;
import com.club.eliteclub.service.EliteClubService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EliteClubController {

    @Autowired
    private EliteClubService eliteClubService;

    @GetMapping("/clubs")
    public List<ClubDTO> clubs() {
        return eliteClubService.getAll();
    }

    @GetMapping("/clubs/{id}")
    public ClubDTO clubWithId(@PathVariable long id) {
        return eliteClubService.getClub(id);
    }

    @PostMapping("/clubs")
    public ResponseEntity createNewClub(@RequestBody ClubDTO clubDTO) {
        eliteClubService.addClub(clubDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/clubs/search")
    public List<ClubDTO> searchClub(@RequestParam @Pattern(regexp = "(\\w+)") String clubName, @RequestParam @Min(1) @Max(5) short rating) {
        return eliteClubService.searchClub(clubName, rating);
    }

    @DeleteMapping("/clubs/{id}")
    public void deleteClub(@PathVariable long id) {
        eliteClubService.deleteClub(id);
    }

    @PutMapping(path = "/clubs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClubDTO updateClub(@PathVariable long id, @RequestBody ClubDTO clubDTO) {
        return eliteClubService.updateClub(id, clubDTO);
    }
}
