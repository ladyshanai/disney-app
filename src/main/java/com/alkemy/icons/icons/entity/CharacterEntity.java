package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "characters")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String image;

    private String name;

    private long age;

    private long weight;

    private String story;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<MovieEntity> movies = new ArrayList<>();





   // public void addMovie(MovieEntity movie){this.movies.add(movie);}

  //  public void removeMovie(MovieEntity movie){this.movies.remove(movie);}






}
