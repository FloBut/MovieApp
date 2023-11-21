package org.example;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

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
public class Movie {
    @Id
    @GeneratedValue
    private long Id;
    @Column
    private String name;

    @ManyToOne //o franchise poate avea mai multe filme
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @OneToMany(mappedBy="movie", cascade = CascadeType.MERGE, orphanRemoval = true)// un tweet are o lista de comentarii si se leaga
//un film poate avea o lista de caractere
    private List<Character> characters;
    @jakarta.persistence.Id
    private Long id;

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
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
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
