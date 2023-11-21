package com.chadmiddleton.dynastyx.league;

import com.chadmiddleton.dynastyx.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;
    @Autowired
    LeagueService(LeagueRepository leagueRepository){
        this.leagueRepository = leagueRepository;
    }

    public League createLeague(Account account){
        League league = new League();
        league.setId(account.getId());
        return leagueRepository.save(league);
    }

    public League getLeagueById(Long id) {
        return leagueRepository.getReferenceById(id);
    }

    public Iterable<League> getLeagues() {
        return leagueRepository.findAll();
    }

    public League updateLeague(League league) {
        return leagueRepository.save(league);
    }

    public void deleteLeague(Long id) {
        leagueRepository.deleteById(id);
    }
}
