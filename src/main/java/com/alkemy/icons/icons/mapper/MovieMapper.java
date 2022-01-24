package com.alkemy.icons.icons.mapper;


import com.alkemy.icons.icons.dto.MovieDTO;
import com.alkemy.icons.icons.entity.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieEntity movieDTO2Entity(MovieDTO dto){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImage(dto.getImage());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setCreationDate(dto.getCreationDate());
        movieEntity.setCalification(dto.getCalification());
        return movieEntity;

    }

    public MovieDTO movieEntity2DTO(MovieEntity entity){
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate());
        dto.setCalification(entity.getCalification());
        return dto;
    }
}
