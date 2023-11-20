package com.chadmiddleton.dynastyx.league;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LeagueRepository extends JpaRepository<League, UUID> {
}
