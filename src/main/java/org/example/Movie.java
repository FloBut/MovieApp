package org.example;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
//2. Simuleaza o aplicatie de filme
//Un film contine mai multe caracatere, iar un caracter poate juca
// in mai multe filme.
// Un film poate apartine unei francize, iar o franciza poate contine mai multe
// filme.
// De exemplu, franciza Marvel contine 23 de filme.
//
//Pe langa operatiile standard, vreau sa pot sa:
//
//adaug un caracter intr-un film
//adaug un film intr-o franciza.
//Vad toate filmele dintr-o franciza
//Vad toata caracterele dintr-un film

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue
    private long movieId;
    @Column
    private String name;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //o franchise poate avea mai multe filme
    @JoinColumn(name = "franchise_Id")
    private Franchise franchise;

    @ManyToMany(mappedBy="movie")
    //un film poate avea o lista de caractere
    //un caracter poate juca in mai multe filme
    private List<Character> characters;
    @jakarta.persistence.Id
    private Long id;


    public Movie(String name) {
        this.name = name;
    }

    public Movie() {

    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public List<Character> getCharacters() {
        if (characters == null ) {
            characters = new ArrayList<>();
        }
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", franchise=" + franchise +
                ", characters=" + characters +
                '}';
    }


}
