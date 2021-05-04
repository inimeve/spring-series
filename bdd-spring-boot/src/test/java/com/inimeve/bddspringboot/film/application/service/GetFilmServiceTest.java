package com.inimeve.bddspringboot.film.application.service;

import com.inimeve.bddspringboot.film.domain.Film;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GetFilmServiceTest {

    private final GetFilmService getFilmService = new GetFilmService();

    @Test
    public void givenExistingFilmId_thenFilmIsReturned() {
        // Given
        Long id = 1L;

        // When
        Film result = getFilmService.getFilm(id);

        // Then
        assertThat(result, is(not(nullValue())));
        assertThat(result.getId(), is(id));
        assertThat(result.getTitle(), is("Test Title"));
    }

    @Test
    public void whenGetFilms_thenFilmsAreReturned() {
        // When
        List<Film> result = getFilmService.getFilms();

        // Then
        assertThat(result, is(not(nullValue())));
        assertThat(result, hasSize(3));

    }
}