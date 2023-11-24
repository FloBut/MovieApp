package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public List<Movie> findAllByFranchise_Id(Long frnchiseId);
}
