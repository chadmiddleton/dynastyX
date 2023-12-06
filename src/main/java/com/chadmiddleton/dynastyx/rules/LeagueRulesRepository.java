package com.chadmiddleton.dynastyx.rules;

import com.chadmiddleton.dynastyx.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRulesRepository extends JpaRepository<LeagueRules, Long> {
}
