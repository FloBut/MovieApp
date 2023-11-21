package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    FranchiseService franchiseService;
    MovieService movieService;

    @Override
    public void run(String... args) throws Exception {
        Franchise franchise = new Franchise("Disney");
        Movie movie = new Movie("movie1");
        Character character = new Character("charater1");
    }
}
