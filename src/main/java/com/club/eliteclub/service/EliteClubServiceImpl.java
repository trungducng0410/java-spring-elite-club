package com.club.eliteclub.service;

import com.club.eliteclub.entity.EliteClub;
import com.club.eliteclub.dto.ClubDTO;
import com.club.eliteclub.repository.EliteClubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EliteClubServiceImpl implements EliteClubService {
    private static final Logger LOG = LoggerFactory.getLogger(EliteClubServiceImpl.class);

    @Autowired
    private EliteClubRepository eliteClubRepository;

    public List<ClubDTO> getAll() {
        return eliteClubRepository.findAll().
                stream().
                map(ClubDTO::new).
                collect(Collectors.toList());
    }

    @Override
    public ClubDTO getClub(long id) {
        return new ClubDTO(eliteClubRepository.findById(id).get());
    }

    public List<ClubDTO> getAll(int page, int pageSize) {
        return eliteClubRepository.findAll(PageRequest.of(page, pageSize)).
                stream().
                map(ClubDTO::new).
                collect(Collectors.toList());
    }

    public void addClub(ClubDTO... clubs) {
        for (ClubDTO club : clubs) {
            EliteClub eliteClub = new EliteClub();
            eliteClub.setClubName(club.clubName());
            eliteClub.setRating(club.rating());
            eliteClubRepository.save(eliteClub);
        }
    }

    public List<ClubDTO> searchClub(String searchTerm, short rating) {
        LOG.info("Searching term {}", searchTerm);
        String pattern = buildLikePattern(searchTerm);
        List<ClubDTO> result = eliteClubRepository.findClubs(pattern, rating).
                stream().
                map(ClubDTO::new).
                toList();
        LOG.info("Search Result: {}", result);
        return result;
    }

    private String buildLikePattern(String searchTerm) {
        return searchTerm.toLowerCase() + "%";
    }

    @Override
    public void deleteClub(long id) {
        eliteClubRepository.deleteById(id);
    }

    @Override
    public ClubDTO updateClub(long id, ClubDTO clubDTO) {
        EliteClub club = eliteClubRepository.findById(id).get();
        club.setClubName(clubDTO.clubName());
        EliteClub updatedClub = eliteClubRepository.save(club);
        return new ClubDTO(updatedClub.getClubName(), updatedClub.getRating());
    }
}
