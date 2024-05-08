package com.club.eliteclub.repository;

import com.club.eliteclub.entity.EliteClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EliteClubRepository extends JpaRepository<EliteClub, Long> {
    @Query("SELECT x from EliteClub x WHERE lower(x.clubName) LIKE :searchTerm ORDER BY x.clubName ASC")
    List<EliteClub> findClubs(@Param("searchTerm") String searchTerm);

    @Query("SELECT x from EliteClub x WHERE lower(x.clubName) LIKE :searchTerm AND x.rating > :rating ORDER BY x.rating DESC")
    List<EliteClub> findClubs(@Param("searchTerm") String searchTerm,@Param("rating") short rating);
}
