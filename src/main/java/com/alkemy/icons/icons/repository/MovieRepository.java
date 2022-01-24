package com.alkemy.icons.icons.repository;


import com.alkemy.icons.icons.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository<MovieEntity, Long> {



}
