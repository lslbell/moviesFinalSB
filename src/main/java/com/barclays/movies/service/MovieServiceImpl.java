package com.barclays.movies.service;

import com.barclays.movies.model.Movie;
import com.barclays.movies.repository.MovieRepository;
import com.barclays.movies.repository.MovieTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;

    private MovieTypeRepository movieTypeRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieTypeRepository movieTypeRepository) {
        this.movieRepository = movieRepository;
        this.movieTypeRepository = movieTypeRepository;
    }

    @Override
    public Movie save(Movie movie) {
        logger.info("Entering the save");

        movie = movieRepository.saveAndFlush(movie);

        logger.info("Exiting the save");
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        logger.info("Entering findAll");

        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        logger.info("Entering find by id");

        Movie movie = null;
        Optional<Movie> movieOptional = movieRepository.findById(id);

        if (movieOptional.isPresent()) {
            movie = movieOptional.get();
        } else {
            movie.setId(1L);
            movie.setTitle("Batman Begins");
            movie.setIsbn("XXX-XXXXX-XXX");
            movie.setMovieType(movieTypeRepository.getReferenceById(1L));
        }

        return movie;
    }
}
