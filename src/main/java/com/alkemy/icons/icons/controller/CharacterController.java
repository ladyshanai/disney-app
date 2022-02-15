package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.CharacterBasicDTO;
import com.alkemy.icons.icons.dto.CharacterDTO;
import com.alkemy.icons.icons.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("characters")
public class CharacterController {

    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {this.characterService = characterService;}

    @GetMapping("/all")
    public ResponseEntity<List<CharacterBasicDTO>> getAll() {
        List<CharacterBasicDTO> characters = this.characterService.getAll();
        return ResponseEntity.ok(characters);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getDetailsById(@PathVariable Long id){
        CharacterDTO character = this.characterService.getDetailsByID(id);
        return ResponseEntity.ok(character);
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name;
            @RequestParam(required = false) Long age;
            @RequestParam(required = false) Set<Long> movies;
            @RequestParam(required = false, defaultValue = "ASC") String order;

    ){
        List<CharacterDTO> characters = this.characterService.getByFilters(name,age,movies,order);
        return ResponseEntity.ok(characters);
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character){
        CharacterDTO characterSaved = this.characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update(@PathVariable Long id, @RequestBody CharacterDTO character){
        CharacterDTO result = this.characterService.update(id,character);
        return ResponseEntity.ok().body(result);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> addMovie(@PathVariable Long id,@PathVariable Long idMovie){
        this.characterService.addMovie(id,idMovie);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> removeMovie(@PathVariable Long id,@PathVariable Long idMovie){
        this.characterService.removeMovie(id,idMovie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    }
