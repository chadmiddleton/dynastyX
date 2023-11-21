package com.chadmiddleton.dynastyx.teams;

import com.chadmiddleton.dynastyx.players.Player;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Player> players;
}
