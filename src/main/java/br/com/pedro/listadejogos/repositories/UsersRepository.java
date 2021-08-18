package br.com.pedro.listadejogos.repositories;

import br.com.pedro.listadejogos.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
