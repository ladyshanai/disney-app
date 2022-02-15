package com.alkemy.icons.icons.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterDTO {

    private long Id;

    private String image;

    private String name;

    private long age;

    private long weight;

    private String story;

    private List<MovieDTO> movies;

}
