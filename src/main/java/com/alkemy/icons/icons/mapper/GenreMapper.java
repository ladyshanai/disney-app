package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.GenreDTO;
import com.alkemy.icons.icons.entity.GenreEntity;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    public GenreEntity genreDTO2Entity(GenreDTO dto){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(dto.getName());
        genreEntity.setImage(dto.getImage());
        return genreEntity;

    }

    public GenreDTO genreEntity2DTO(GenreEntity entity){
        GenreDTO dto = new GenreDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        return dto;
    }
}
