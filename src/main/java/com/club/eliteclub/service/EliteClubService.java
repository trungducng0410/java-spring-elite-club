package com.club.eliteclub.service;

import com.club.eliteclub.dto.ClubDTO;

import java.util.List;

public interface EliteClubService {
    List<ClubDTO> getAll();
    ClubDTO getClub(long id);
    List<ClubDTO> searchClub(String searchTerm, short rating);
    void addClub(ClubDTO... clubs);
    void deleteClub(long id);
    ClubDTO updateClub(long id, ClubDTO clubDTO);
}
