package com.barclays.movies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOVIE_TYPE")
public class MovieType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TYPE")
    private String type;

//    @Column(name = "Movie")
//    @OneToMany(targetEntity =)
//    List<Movie> movies = new ArrayList<>();


}
