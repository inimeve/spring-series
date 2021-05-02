package com.inimeve.bddspringboot.film.domain;

public class Film {

    private final FilmId id;

    public Film(FilmId id) {
        this.id = id;
    }


    public static class FilmId {
        private final Long value;

        public FilmId(Long value) {
            this.value = value;
        }
    }
}
