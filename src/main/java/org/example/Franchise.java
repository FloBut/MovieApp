package org.example;

import jakarta.persistence.*;

import java.util.List;

//o franciza are un id, care va fi cheia straina in  film si are un nume
@Entity //indic jpa ului ca aceasta clasa este un tabel in baza de date
public class Franchise {
    @Id// un id care este cheie primara in tabel
    @GeneratedValue///generaza automat id ul in tabel pentru fiecare linie in parte
    private long Id;
    @Column//indic jpa ului ca atributul va fi o coloana in baza de date
    private String name;
    @OneToMany(mappedBy = "franchise", cascade = CascadeType.MERGE)
    //relatia este ca o franciza poate avea mai multe filme
    // cascade =relatia se propaga si catre filme
    // franciza are o lista de filme
    List<Movie> movies;
//se creaza mai intai un tabel gol si apoi se populeaza
    public Franchise() {
    }

    public Franchise(String name) {
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Franchise{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
