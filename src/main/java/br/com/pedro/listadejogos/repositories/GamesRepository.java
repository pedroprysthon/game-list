package br.com.pedro.listadejogos.repositories;

import br.com.pedro.listadejogos.models.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
}
