package com.alkemy.icons.icons.service.impl;


import com.alkemy.icons.icons.dto.MovieDTO;
import com.alkemy.icons.icons.entity.MovieEntity;
import com.alkemy.icons.icons.mapper.MovieMapper;
import com.alkemy.icons.icons.repository.MovieRepository;
import com.alkemy.icons.icons.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl  implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;


    public MovieDTO save(MovieDTO dto){
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySaved =movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved);
        return result;
    }
}
