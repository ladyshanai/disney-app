package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Table(name = "genres")
@Getter
@Setter
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String image;



}
