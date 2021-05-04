package com.inimeve.bddspringboot.film.application.service;

import com.inimeve.bddspringboot.film.application.port.in.GetFilmQuery;
import com.inimeve.bddspringboot.film.domain.Film;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GetFilmService implements GetFilmQuery {

    @Override
    public Film getFilm(Long uuid) {
        return Film.withId(1L, "Test Title");
    }

    @Override
    public List<Film> getFilms() {
        Film filmOne = Film.withId(1L, "Mock Title 1");
        Film filmTwo = Film.withId(2L, "Mock Title 2");
        Film filmThree = Film.withId(3L, "Mock Title 3");

        return Arrays.asList(filmOne, filmTwo, filmThree);
    }

}
