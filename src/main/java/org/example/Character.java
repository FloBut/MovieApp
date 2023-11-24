package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue
    private Long Id;

    @Column
    private String name;
    //un caracter poate juca in mai multe filme
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            //numele noului tabel pe care eu il definesc direct in clasa carater
            name = "movie_characters",
            //coloanee intre care se va face legatura
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id")
    )
    private List<Movie> movies;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    public Long getId() {

        return Id;
    }

    public void setId(Long id) {

        Id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String characterName) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        if (movies == null) {
            movies = new ArrayList<>();
        }
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Character{" +
                "Id=" + Id +
                ", characterName='" + name + '\'' +
                '}';
    }
}
