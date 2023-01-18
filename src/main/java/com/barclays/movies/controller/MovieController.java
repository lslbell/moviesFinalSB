package com.barclays.movies.controller;

import com.barclays.movies.model.Movie;
import com.barclays.movies.model.MovieType;
import com.barclays.movies.repository.MovieTypeRepository;
import com.barclays.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.h2.engine.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/browseMovies")
public class MovieController {

    MovieService movieService;
    MovieTypeRepository movieTypeRepository;

    @Autowired
    public MovieController(MovieService movieService, MovieTypeRepository movieTypeRepository) {
        this.movieService = movieService;
        this.movieTypeRepository = movieTypeRepository;
        }

    Logger logger = LoggerFactory.getLogger(MovieController.class);

    @ModelAttribute("movieTypeList")
    public List<MovieType> getMovieTypeList() {
        return movieTypeRepository.findAll();
    }

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("movies");

        List<Movie> movies = movieService.findAll();

        modelAndView.addObject("movies", movies);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {
        //should add default movie if nullP...

        Movie movie = movieService.findById(id);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        ModelAndView modelAndView = new ModelAndView("movies");
        modelAndView.addObject("movies", movies);

        return modelAndView;
    }

    @GetMapping("/addMovie")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("addMovie");

        Movie movie = movieService.findById(1L);

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

    @GetMapping("/edit")
    public ModelAndView edit(@PathParam("id") Long id) {
        Movie movie = movieService.findById(id);

        ModelAndView modelAndView = new ModelAndView("addMovie");
        modelAndView.addObject("movie", movie);

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
