package com.alkemy.icons.icons.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Getter
@Setter
public class MovieDTO {

    private long Id;

    private String image;

    private String title;

    @DateTimeFormat(pattern = ("MM/dd/yyyy") )
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate creationDate;

    private long calification;

    private long genreId;

}
