package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.CharacterBasicDTO;
import com.alkemy.icons.icons.dto.CharacterDTO;
import com.alkemy.icons.icons.dto.MovieDTO;
import com.alkemy.icons.icons.entity.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class CharacterMapper {

    @Autowired
    private MovieMapper movieMapper;

    public CharacterEntity characterDTO2Entity(CharacterDTO dto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setImage(dto.getImage());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setStory(dto.getStory());


        return characterEntity;

    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies){
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setStory(entity.getStory());
        if (loadMovies){
            List<MovieDTO> moviesDTO = this.movieMapper.movieEntityList2DTOList(entity.getMovies(),  false);
            dto.setMovies(moviesDTO);
        }

        return dto;
    }

 /*   public CharacterDTO characterEntity2DTO(CharacterEntity entity){
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setStory(entity.getStory());

        return dto;
    }*/
    public void characterEntityRefreshValues(CharacterEntity entity, CharacterDTO characterDTO){
        entity.setImage(characterDTO.getImage());
        entity.setName(characterDTO.getName());
        entity.setAge(characterDTO.getId());
        entity.setWeight(characterDTO.getWeight());
        entity.setStory(characterDTO.getStory());
    }

    public Set<CharacterEntity> characterDTOList2Entity(List<CharacterDTO>dtos){
        Set<CharacterEntity> entities = new HashSet<>();
        for (CharacterDTO dto : dtos){
            entities.add(this.characterDTO2Entity(dto));
        }
        return entities;
    }

    /**
     *
     * @param entities (Set or List)
     * @param loadMovies

     */

    public List<CharacterDTO>characterEntitySet2DTOList(Collection<CharacterEntity>entities,boolean loadMovies){
        List<CharacterDTO> dtos = new ArrayList<>();
        for (CharacterEntity entity : entities){
            dtos.add(this.characterEntity2DTO(entity,loadMovies));
        }
        return dtos;
    }

    public List<CharacterBasicDTO>characterEntitySet2BasicDTOList(Collection<CharacterEntity>entities){
        List<CharacterDTO> dtos = new ArrayList<>();
        CharacterBasicDTO basicDTO;
        for (CharacterEntity entity : entities){
            basicDTO = new CharacterBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImage(entity.getImage());
            basicDTO.setName(entity.getName());
            basicDTO.setAge(entity.getAge());
            dtos.add(basicDTO);
        }
        return dtos;
    }
}
