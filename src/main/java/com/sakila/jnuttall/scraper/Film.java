package com.sakila.jnuttall.scraper;

import javax.persistence.*;

@Entity
@Table(name="film")
public class Film {
    // Attributes
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int _id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "release_year")
    int released;

    @Column(name = "rating")
    String rating;

    @Column(name = "length")
    int length;

    /**
     * number of times watched
     * total time watched
     * revenue
     */

    public Film(int _id, String title, String description, int released, String rating, int length ) {
        this._id = _id;
        this.title = title;
        this.description = description;
        this.released = released;
        this.rating = rating;
        this.length = length;
    }

    public Film(){}

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
