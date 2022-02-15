package com.alkemy.icons.icons.mapper;


import com.alkemy.icons.icons.dto.CharacterDTO;
import com.alkemy.icons.icons.dto.MovieDTO;
import com.alkemy.icons.icons.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public MovieEntity movieDTO2Entity(MovieDTO dto){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImage(dto.getImage());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setCreationDate(dto.getCreationDate());
        movieEntity.setCalification(dto.getCalification());
        movieEntity.setGenreId(dto.getGenreId());
        return movieEntity;

    }



    public MovieDTO movieEntity2DTO(MovieEntity entity){
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate());
        dto.setCalification(entity.getCalification());
        dto.setGenreId(entity.getGenreId());
        return dto;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters){
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate());
        dto.setCalification(entity.getCalification());
        dto.setGenreId(entity.getGenreId());
        if (loadCharacters){
            List<CharacterDTO> characterDTOS = this.characterMapper.characterEntitySet2DTOList(entity.getCharacters(),  false);
            dto.setCharacters(characterDTOS);
        }
        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters){
        List<MovieDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities){
            dtos.add(this.movieEntity2DTO(entity,loadCharacters));
        }
        return dtos;
    }

    public List<MovieEntity> movieDTOList2Entity(List<MovieDTO> dtos){
        List<MovieEntity> entities = new ArrayList<>();
        for (MovieDTO dto : dtos){
            entities.add(this.movieDTO2Entity(dto));
        }
        return entities;
    }
}
