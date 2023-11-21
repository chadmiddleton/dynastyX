package com.chadmiddleton.dynastyx.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${base.path}/team")
public class TeamController {

    private final TeamService teamService;
    @Autowired
    public TeamController(TeamService teamService){
        this.teamService=teamService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Team> createTeam(@RequestBody Team team){
        return ResponseEntity.ok(teamService.createTeam(team));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Iterable<Team>> getTeams(){
        return ResponseEntity.ok(teamService.getTeams());
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Team> getTeamById(@PathVariable Long id){
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Team> updateTeam(@RequestBody Team team){
        return ResponseEntity.ok(teamService.updateTeam(team));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
    }
}
