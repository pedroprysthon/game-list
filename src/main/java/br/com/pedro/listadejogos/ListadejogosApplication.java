package br.com.pedro.listadejogos;

import br.com.pedro.listadejogos.models.Games;
import br.com.pedro.listadejogos.models.GamesCategory;
import br.com.pedro.listadejogos.repositories.GamesCategoryRepository;
import br.com.pedro.listadejogos.repositories.GamesRepository;
import br.com.pedro.listadejogos.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ListadejogosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ListadejogosApplication.class, args);
	}

	@Autowired
	private GamesCategoryRepository gamesCategoryRepository;

	@Autowired
	private GamesRepository gamesRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public void run(String... args) throws Exception {
		Optional<GamesCategory> category = this.gamesCategoryRepository.findById(1l);
		Games games = new Games();

		if (category.isPresent()) {
			games.setGamesCategory(category.get());
		}

		games.setTitle("Rocket League");
		games.setDescription("jogo de carro que bate bola");
		games.setStartingDate(new Date(System.currentTimeMillis()));
		games.setReviewScore(5);
		games.setReviewNote("good game");
		games.setImageUrl("https://www.oficinadanet.com.br/imagens/post/32824/egs-social-rocketleague-news-1920x1080-1920x1080-975383433.jpg");
		this.gamesRepository.save(games);
	}
}
