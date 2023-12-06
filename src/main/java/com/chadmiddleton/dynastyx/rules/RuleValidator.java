package com.chadmiddleton.dynastyx.rules;

import com.chadmiddleton.dynastyx.Rule;
import com.chadmiddleton.dynastyx.account.Account;
import com.chadmiddleton.dynastyx.league.League;
import com.chadmiddleton.dynastyx.league.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;

public class RuleValidator {
    LeagueService leagueService;
    RuleService ruleService;
    @Autowired
    RuleValidator(LeagueService leagueService, RuleService ruleService){
        this.leagueService=leagueService;
        this.ruleService=ruleService;
    }

    public void validate(Long leagueId, Long ruleId){
        League league = leagueService.getLeagueById(leagueId);
//        Rule rule = ruleService.getRuleById(ruleId);
    }
}
