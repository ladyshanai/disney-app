package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO getDetailsByID(Long id);
    List<CharacterBasicDTO> getAll();
    List<CharacterDTO> getByFilters(String name, Long age, Set<Long> movies, String order);

    CharacterDTO save(CharacterDTO characterDTO);

    CharacterDTO update(Long id,CharacterDTO character);

    void addMovie(Long id, Long idMovie);

    void removeMovie(Long id, Long idMovie);

    void delete(Long id);
}
