package com.chadmiddleton.dynastyx.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeamRepository extends JpaRepository<Team, Long> {
}
