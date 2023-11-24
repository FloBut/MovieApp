package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Un film contine mai multe caracatere, iar un caracter poate
// juca in mai multe filme. Un film poate apartine unei francize,
// iar o franciza poate contine mai multe filme. De exemplu, franciza Marvel contine 23 de filme.
//
//Pe langa operatiile standard, vreau sa pot sa:
//
//adaug un caracter intr-un film
//adaug un film intr-o franciza.
//Vad toate filmele dintr-o franciza
//Vad toata caracterele dintr-un film
@Service
public class MovieService {
    MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    //adaug un film in lista de filme
    @Transactional
    public Movie addMovie(Movie mouvie) {
        return movieRepository.save(mouvie);
    }

}
