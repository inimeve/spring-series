package com.inimeve.bddspringboot.film.domain;

public class Film {

    private final Long id;

    private final String title;

    private Film(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Film withoutId(String title) {
        return new Film(null, title);
    }

    public static Film withId(Long id, String title) {
        return new Film(id, title);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
