package com.barclays.movies.repository;

import com.barclays.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("MovieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long> {


}
