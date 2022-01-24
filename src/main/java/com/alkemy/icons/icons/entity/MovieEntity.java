package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "movies")
@Getter
@Setter

public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;

    private String image;

    private String title;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    private long calification;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private GenreEntity genre;

    @Column(name = "genre_id", nullable = false)
    private long genreId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Character_Movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private Set<CharacterEntity> characters = new HashSet<>();

    @Override
    public boolean equals(Object obj){
        if(obj ==null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MovieEntity other = (MovieEntity) obj;
        return other.Id == this.Id;
    }

    // public void addCharacter(CharacterEntity movie){this.characters.add(character);}

    //  public void removeCharacter(CharacterEntity movie){this.characters.remove(character);}

}
