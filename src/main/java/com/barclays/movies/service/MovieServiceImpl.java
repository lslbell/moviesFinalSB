package com.barclays.movies.service;

import com.barclays.movies.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Override
    public Movie save(Movie movie) {
        logger.info("Entering the save");

        return movie;
    }

    @Override
    public List<Movie> findAll() {
        logger.info("Entering findAll");

        List<Movie> movies = new ArrayList<>();

        return movies;
    }

    @Override
    public Movie findById(Long id) {
        logger.info("Entering find by id");

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setIsbn("");
        movie.setTitle("");

        return movie;
    }
}
