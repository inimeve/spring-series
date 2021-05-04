package com.inimeve.bddspringboot.film.adapter.in.web;

import com.inimeve.bddspringboot.film.application.service.GetFilmService;
import com.inimeve.bddspringboot.film.domain.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GetFilmController {

    private final GetFilmService getFilmService;

    @Autowired
    public GetFilmController(GetFilmService getFilmService) {
        this.getFilmService = getFilmService;
    }

    @GetMapping("/films/{id}")
    public Film getFilm(@PathVariable Long id) {
        return this.getFilmService.getFilm(id);
    }

    @GetMapping("/films")
    public List<Film> getFilms() {
        return this.getFilmService.getFilms();
    }

}
