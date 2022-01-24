package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.CharacterDTO;
import com.alkemy.icons.icons.entity.CharacterEntity;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {
    public CharacterEntity characterDTO2Entity(CharacterDTO dto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setImage(dto.getImage());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setStory(dto.getStory());


        return characterEntity;

    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity){
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setStory(entity.getStory());

        return dto;
    }
}
