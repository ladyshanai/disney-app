package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.GenreDTO;
import com.alkemy.icons.icons.entity.GenreEntity;
import com.alkemy.icons.icons.mapper.GenreMapper;
import com.alkemy.icons.icons.repository.GenreRepository;
import com.alkemy.icons.icons.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepository;

    public GenreDTO save(GenreDTO dto){
        GenreEntity entity = genreMapper.genreDTO2Entity(dto);
        GenreEntity entitySaved =genreRepository.save(entity);
        GenreDTO result = genreMapper.genreEntity2DTO(entitySaved);
        return result;



    }
}
