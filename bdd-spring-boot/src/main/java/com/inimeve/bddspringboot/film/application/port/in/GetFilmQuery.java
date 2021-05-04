package com.inimeve.bddspringboot.film.application.port.in;

import com.inimeve.bddspringboot.film.domain.Film;

import java.util.List;

public interface GetFilmQuery {

    Film getFilm(Long id);

    List<Film> getFilms();

}
