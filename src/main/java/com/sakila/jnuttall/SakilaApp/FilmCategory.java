package com.sakila.jnuttall.SakilaApp;

import com.sakila.jnuttall.scraper.Film;

import javax.persistence.*;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorId;
    @Column(name = "category_id")
    int categoryId;

    public FilmCategory(int actorId, int categoryId){

        this.actorId = actorId;
        this.categoryId = categoryId;
    }

    public FilmCategory(){}

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
