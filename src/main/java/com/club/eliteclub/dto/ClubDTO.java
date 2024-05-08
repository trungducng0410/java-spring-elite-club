package com.club.eliteclub.dto;

import com.club.eliteclub.entity.EliteClub;

public record ClubDTO(String clubName, short rating) {
    public ClubDTO(EliteClub eliteClub) {
        this(eliteClub.getClubName(), eliteClub.getRating());
    }
}
