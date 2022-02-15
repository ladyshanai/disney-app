package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.CharacterBasicDTO;
import com.alkemy.icons.icons.dto.CharacterDTO;
import com.alkemy.icons.icons.dto.CharacterFiltersDTO;
import com.alkemy.icons.icons.entity.CharacterEntity;
import com.alkemy.icons.icons.entity.MovieEntity;
import com.alkemy.icons.icons.mapper.CharacterMapper;
import com.alkemy.icons.icons.repository.CharacterRepository;
import com.alkemy.icons.icons.service.CharacterService;
import com.alkemy.icons.icons.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    private CharacterRepository characterRepository;
    private CharacterSpecification characterSpecification;

    private CharacterMapper characterMapper;

    private MovieService movieService;

    @Autowired
    public CharacterServiceImpl(
            CharacterRepository characterRepository,
            CharacterSpecification characterSpecification,
            MovieService movieService,
            CharacterMapper characterMapper){
        this.characterRepository = characterRepository;
        this.characterSpecification = characterSpecification;
        this.characterMapper = characterMapper;
        this.movieService = movieService;
    }

    public CharacterDTO getDetailsById(Long id){
        Optional<CharacterEntity> entity = this.characterRepository.findById(id);
        if (!entity.isPresent()){
            throw new ParamNotFound("Id character not valid");
        }
        CharacterDTO characterDTO = this.characterMapper.characterEntity2DTO(entity.get(), true);
        return characterDTO;

    }




    public List<CharacterBasicDTO> getAll(){
        List<CharacterEntity> entities = this.characterRepository.findAll();
        List<CharacterBasicDTO> characterBasicDTOS = this.characterMapper.characterEntitySet2BasicDTOList((entities));
        return characterBasicDTOS;
    }

    public List<CharacterDTO> getByFilters(String name,Long age, Set<Long>movies,String order){
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO (name,age,movies,order);
        List<CharacterEntity> entities = this.characterRepository.findAll(this.characterSpecification.getByFilters(filtersDTO));
        List<CharacterDTO> dtos = this.characterMapper.characterEntitySet2DTOList(entities,  true);
        return dtos;

    }

    public CharacterDTO save(CharacterDTO dto){
        CharacterEntity entity = this.characterMapper.characterDTO2Entity(characterDTO);
        CharacterEntity entitySaved =this.characterRepository.save(entity);
        CharacterDTO result = this.characterMapper.characterEntity2DTO(entitySaved, false);
        return result;
    }

    public CharacterDTO update(Long id, CharacterDTO characterDTO){
        Optional<CharacterEntity> entity = this.characterRepository.findById(id);
        if (!entity.isPresent()){
            throw new ParamNotFound( "Id character not valid" );
        }
        this.characterMapper.characterEntityRefreshValues(entity.get(),characterDTO);
        CharacterEntity entitySaved = this.characterRepository.save(entity.get());
        CharacterDTO result = this.characterMapper.characterEntity2DTO(entitySaved, false);
        return result;
    }
    public void addMovie(Long id, Long idMovie){
        CharacterEntity entity = this.characterRepository.getById(id);
        entity.getMovies().size();
        MovieEntity movieEntity = this.movieService.getEntityById(idMovie);
        entity.addMovie(movieEntity);
        this.characterRepository.save(entity);

    }

    public void removeMovie(Long id, Long idMovie){
        CharacterEntity entity = this.characterRepository.getById(id);
        entity.getMovies().size();
        MovieEntity movieEntity = this.movieService.getEntityById(idMovie);
        entity.removeMovie(movieEntity);
        this.characterRepository.save(entity);
    }

    public void delete(Long id){
        this.characterRepository.deleteById(id);
    }


}
