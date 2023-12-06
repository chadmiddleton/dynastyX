package com.chadmiddleton.dynastyx.rules;

import com.chadmiddleton.dynastyx.Rule;
import com.chadmiddleton.dynastyx.league.LeagueRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LeagueRules implements Rule {
    @Id
    private Long id;

    @Override
    public void attachRule(Long ruleId) {

    }

    @Override
    public void getRule(Long ruleId) {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
