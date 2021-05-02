package com.inimeve.bddspringboot.film.application.port.in;

import com.inimeve.bddspringboot.film.domain.Film;


public interface GetFilmUseCase {

    Film getFilm(Film.FilmId filmId);

}
