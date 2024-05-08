package com.club.eliteclub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "elite_club")
public class EliteClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "rating")
    private short rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "EliteClub{" +
                "id=" + id +
                ", clubName='" + clubName + '\'' +
                '}';
    }
}
