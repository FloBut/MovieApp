package org.example;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class CharacterService {
    CharacterRepository characterRepository;
    MovieRepository movieRepository;

    public CharacterService(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }
    //adaug un caracter intr o lista de caractere a unui film
    public Movie addCharacterToMovie (Long movieId, Character character) {
        //caut filmul cu id ul dat ca parametru
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new EntityNotFoundException("id not found"));
        //adaug in lista de filme
        movie.getCharacters().add(character);
        //updatez caracterul din lista de caractere a filmului
        character.getMovies().add(movie);
        return  movieRepository.save(movie);
    }
}
