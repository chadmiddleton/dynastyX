package com.chadmiddleton.dynastyx.league;

import com.chadmiddleton.dynastyx.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "${base.path}/league")
public class LeagueController {
    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<League> createLeague(@RequestBody Account account) {
        return ResponseEntity.ok(leagueService.createLeague(account));
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<League> getLeagueById(@PathVariable Long id) {
        return ResponseEntity.ok(leagueService.getLeagueById(id));
    }

    @GetMapping()
    public @ResponseBody ResponseEntity<Iterable<League>> getAllLeagues(){
        return ResponseEntity.ok(leagueService.getLeagues());
    }

    @PutMapping
    public @ResponseBody ResponseEntity<League> updateLeague(@RequestBody League league){
        return ResponseEntity.ok(leagueService.updateLeague(league));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLeague(@PathVariable Long id){
        leagueService.deleteLeague(id);
    }
}
