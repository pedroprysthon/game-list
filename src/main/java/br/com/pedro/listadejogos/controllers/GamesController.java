package br.com.pedro.listadejogos.controllers;


import br.com.pedro.listadejogos.models.Games;
import br.com.pedro.listadejogos.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GamesController {
    @Autowired
    private GamesRepository gamesRepository;

    @GetMapping
    public ResponseEntity<List<Games>> findAllGames(){
        List<Games> games = gamesRepository.findAll();

        //return ResponseEntity.status(HttpStatus.OK).body(games);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Games> findGameById(@PathVariable("id") Long id) {
        Optional<Games> games = gamesRepository.findById(id);

        if (games.isPresent()) {
            return ResponseEntity.ok(games.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Games> saveGame(@RequestBody Games newGame) {

        Games created = this.gamesRepository.save(newGame);

        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Games> updateGame(@PathVariable("id") Long id, @RequestBody Games newGame) {
        Optional<Games> games = gamesRepository.findById(id);

        if (games.isPresent()) {
            //Games oldGame = games.get();//
            //oldGame.setTitle(newGame.getTitle());
            //oldGame.setDescription(newGame.getDescription());
            //oldGame = this.gamesRepository.save(oldGame);
            newGame.setId(id);
            this.gamesRepository.save(newGame);
            return ResponseEntity.ok(newGame);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGame(@PathVariable("id") Long id) {
        Optional<Games> games = gamesRepository.findById(id);

        if (games.isPresent()) {
            this.gamesRepository.delete(games.get());
        }

        return ResponseEntity.notFound().build();
    }

}
