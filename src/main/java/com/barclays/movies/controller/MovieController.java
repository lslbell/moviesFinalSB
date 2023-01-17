package com.barclays.movies.controller;

import com.barclays.movies.model.Movie;
import com.barclays.movies.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    Logger logger = LoggerFactory.getLogger(MovieController.class);

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("movies");

        Movie movie = movieService.findById(1L);

        List<Movie> movies = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setTitle("Batman Begins");
        movie1.setIsbn("XXX-XXXXX-XXX");
        movies.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2L);
        movie2.setTitle("Batman: The Dark Knight");
        movie2.setIsbn("XXX-XXXXX-XXX");
        movies.add(movie2);

        Movie movie3 = new Movie();
        movie3.setId(3L);
        movie3.setTitle("Batman: The Dark Knight Rises");
        movie3.setIsbn("XXX-XXXXX-XXX");
        movies.add(movie3);

        modelAndView.addObject("movies", movies);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {
        Movie movie = new Movie();
        movie.setId(id);
//        movie.setTitle(id + "");
//        movie.setIsbn(id + "");

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        ModelAndView modelAndView = new ModelAndView("movies");
        modelAndView.addObject("movies", movies);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("addMovie");

        Movie movie = new Movie();
        movie.setId(4L);
        movie.setTitle("Batman Begins");
        movie.setIsbn("XXX-XXXXX-XXX");
        modelAndView.addObject("movie", movie);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid @ModelAttribute Movie movie, BindingResult result) {
        logger.info("Entering post");
        ModelAndView modelAndView = new ModelAndView("poster");

        if (result.hasErrors()) {
            modelAndView.setViewName("addMovie");
            logger.info("There were errors in the movie object");
        } else {
            logger.debug("Title: " + movie.getTitle());

            modelAndView.setViewName("addMovie");

            //write to db
            modelAndView.addObject("addMovieSuccess", true);
            modelAndView.addObject("addMovieTitle", movie.getTitle());
            modelAndView.addObject("movie", movie);
        }

        logger.info("Exiting post");
        return modelAndView;
    }

    @PutMapping
    public @ResponseBody String put() {
        return "get";
    }

    @DeleteMapping
    public @ResponseBody String delete() {
        return "get";
    }
}
