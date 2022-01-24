package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.CharacterDTO;
import com.alkemy.icons.icons.entity.CharacterEntity;
import com.alkemy.icons.icons.mapper.CharacterMapper;
import com.alkemy.icons.icons.repository.CharacterRepository;
import com.alkemy.icons.icons.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO save(CharacterDTO dto){
        CharacterEntity entity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity entitySaved =characterRepository.save(entity);
        CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved);
        return result;
    }
}
