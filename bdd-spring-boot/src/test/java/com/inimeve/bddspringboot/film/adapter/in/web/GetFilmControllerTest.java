package com.inimeve.bddspringboot.film.adapter.in.web;

import com.inimeve.bddspringboot.film.application.service.GetFilmService;
import com.inimeve.bddspringboot.film.domain.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GetFilmController.class)
class GetFilmControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GetFilmService getFilmService;

    @BeforeEach
    public void setUp() {
        Film filmOne = Film.withId(1L, "Mock Title 1");
        Film filmTwo = Film.withId(2L, "Mock Title 2");
        Film filmThree = Film.withId(3L, "Mock Title 3");

        Mockito.when(getFilmService.getFilm(Mockito.anyLong())).thenReturn(filmOne);
        Mockito.when(getFilmService.getFilms()).thenReturn(Arrays.asList(filmOne, filmTwo, filmThree));
    }

    @Test
    public void givenExistingFilmId_thenFilmIsReturned() throws Exception{
        // Given
        Long id = 1L;

        // When
        mvc.perform(get("/api/films/{id}", id).contentType(MediaType.APPLICATION_JSON))

        // Then
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.title", is("Mock Title 1")));
    }

    @Test
    public void whenGetFilms_thenFilmsAreReturned() throws Exception{
        // When
        mvc.perform(get("/api/films").contentType(MediaType.APPLICATION_JSON))

        // Then
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", is(not(nullValue()))))
            .andExpect(jsonPath("$", hasSize(3)));
    }

}