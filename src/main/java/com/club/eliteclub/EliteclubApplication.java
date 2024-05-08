package com.club.eliteclub;

import com.club.eliteclub.dto.ClubDTO;
import com.club.eliteclub.service.EliteClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EliteclubApplication implements ApplicationRunner {
	private Logger LOG = LoggerFactory.getLogger(EliteclubApplication.class);

	@Autowired
	private EliteClubService eliteClubService;

	public static void main(String[] args) {
		SpringApplication.run(EliteclubApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		eliteClubService.addClub(
				new ClubDTO("Billionaire", (short) 5),
				new ClubDTO("Environmentalist", (short) 2),
				new ClubDTO("Poker", (short) 3));
	}

}
