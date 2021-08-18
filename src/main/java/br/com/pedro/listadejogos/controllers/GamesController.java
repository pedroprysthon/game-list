package br.com.pedro.listadejogos.controllers;


import br.com.pedro.listadejogos.models.Games;
import br.com.pedro.listadejogos.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {
    @Autowired
    private GamesRepository gamesRepository;

    @GetMapping
    public ResponseEntity<List<Games>> getGames(){
        List<Games> games = gamesRepository.findAll();

        return ResponseEntity.ok(games);
    }
}
