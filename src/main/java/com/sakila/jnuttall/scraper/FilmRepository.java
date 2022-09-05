package com.sakila.jnuttall.scraper;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Integer> {
    @Query(nativeQuery = true, value = "SELECT category.category_id, category.name FROM film INNER JOIN film_category ON film.film_id = film_category.film_id INNER JOIN category ON film_category.category_id = category.category_id where film.film_id = :id")
    Object getCategory(@Param("id") int id);

    @Query(nativeQuery = true, value = "select film.film_id, film.description, film.release_year, film.length, film.rating, film.rental_rate, category.name as category, count(rental_id) as times_rented, count(rental_id)*film.length as minutes_watched, count(rental_id) * rental_rate as revenue from film inner join film_category on film.film_id = film_category.film_id inner join category on film_category.category_id = category.category_id inner join inventory on inventory.film_id = film.film_id inner join rental on rental.inventory_id = inventory.inventory_id group by film.film_id order by revenue desc;")
    Iterable<Object> getFilmStats();

//    @Query(nativeQuery = true, value = "SELECT category.name FROM film INNER JOIN film_category ON film.film_id = film_category.film_id INNER JOIN category ON film_category.category_id = category.category_id WHERE film.film_id = :id");
//    Optional<Film> getFilmCategory(@Param("id") int id);
}
