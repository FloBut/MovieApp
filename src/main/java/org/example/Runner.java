package org.example;

import org.hibernate.engine.jdbc.CharacterStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

   CharacterService characterService;
    MovieService movieService;

    @Override
    public void run(String... args) throws Exception {
        //creez un film
        Character character = new Character("charater1");
        Movie movie = new Movie("movie1");
        Movie savedMovie = movieService.addMovie(movie);

        characterService.addCharacterToMovie(savedMovie.getMovieId(),character);
    }
}
