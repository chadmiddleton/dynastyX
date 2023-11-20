package com.chadmiddleton.dynastyx.league;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class League {
    @Id
    private UUID id;
    private String name = "Dynasty League";
}
