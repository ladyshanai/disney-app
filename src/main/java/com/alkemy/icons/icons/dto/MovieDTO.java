package com.alkemy.icons.icons.dto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class MovieDTO {

    private long Id;

    private String image;

    private String title;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    private long calification;

}
