package com.chadmiddleton.dynastyx.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TeamService {
    private final TeamRepository teamRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository=teamRepository;
    }
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.getReferenceById(id);
    }

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
