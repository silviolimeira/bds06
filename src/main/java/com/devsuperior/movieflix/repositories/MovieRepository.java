package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT obj FROM Movie obj WHERE " +
            "(obj.genre.id = :genreId) " +
            "ORDER BY obj.title ASC")
    Page<Movie> find(Long genreId, Pageable pageable);


    //Page<Movie> findAll(Pageable pageable);

}
