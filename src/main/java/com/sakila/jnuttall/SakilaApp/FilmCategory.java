package com.sakila.jnuttall.SakilaApp;


import javax.persistence.*;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmId;
    @Column(name = "category_id")
    int categoryId;

    public FilmCategory(int filmId, int categoryId){

        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public FilmCategory(){}

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
