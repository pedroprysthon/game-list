package br.com.pedro.listadejogos.repositories;

import br.com.pedro.listadejogos.models.GamesCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesCategoryRepository extends JpaRepository<GamesCategory, Long> {
}
