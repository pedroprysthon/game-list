package br.com.pedro.listadejogos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games_category")
public class GamesCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "games_category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "games_category_id")
    @JsonIgnoreProperties("gamesCategory")
    private Set<Games> games = new HashSet<>();

    public GamesCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Games> getGames() {
        return games;
    }

    public void setGames(Set<Games> games) {
        this.games = games;
    }
}
