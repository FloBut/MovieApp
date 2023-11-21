package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Character {
    @Id
    @GeneratedValue
    private Long Id;

    @Column
    private String characterName;
    //un caracter poate juca in mai multe filme
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movies;

    public Character() {
    }

    public Character(String characterName) {
        this.characterName = characterName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Movie getMovies() {
        return movies;
    }

    public void setMovies(Movie movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Character{" +
                "Id=" + Id +
                ", characterName='" + characterName + '\'' +
                ", movies=" + movies +
                '}';
    }
}
