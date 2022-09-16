package com.sakila.jnuttall.SakilaApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FilmRepoTests {


    SakilaAppApplication sakilaAppApplication;

    @Mock
    CategoryRepository categoryRepository;
    @Mock
    FilmRepository filmRepository;
    @Mock
    ActorRepository actorRepository;
    @Mock
    LanguageRepository languageRepository;
    @Mock
    FilmCategoryRepository filmCategoryRepository;


    @BeforeEach
    void setup() {
        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository,
                filmCategoryRepository, languageRepository);
    }

    @Test
    void testGetAllFilms() {

        List<Film> filmList = new ArrayList<>();

        Film testFilm = new Film(1, "Filmy Film", "Adventure", 2005,
                6, 5, 1.99, 88, 4, "PG", "Bonus features");
        Film testFilm2 = new Film(2, "Filmington", "Period Drama Romcom", 2005,
                6, 88, 1.99, 90, 3, "PG", "Behind the scenes");

        filmList.add(testFilm);
        filmList.add(testFilm2);

        Iterable<Film> filmIterable = filmList;

        when(filmRepository.findAll()).thenReturn(filmIterable);

        Iterable<Film> Expected = filmIterable;
        Iterable<Film> Actual = sakilaAppApplication.getAllFilms();

        Assertions.assertEquals(Expected, Actual, "Error: All Films have not been returned\n" +
                "Actual Results: " + Actual);

    }

    @Test
    void getFilmID() {
        Film film = new Film();
        film.setFilm_id(1);
        Assertions.assertEquals(1, film.getFilm_id(), "Error: Incorrect film ID was returned\n" +
                "Actual results: " + film.getFilm_id());
    }

    @Test
    void getFilmTitle() {
        Film film = new Film();
        film.setTitle("Jaws");
        Assertions.assertEquals("Jaws", film.getTitle(), "Error: Incorrect film title was returned\n" +
                "Actual results: " + film.getTitle());
    }

    @Test
    void getFilmDesc() {
        Film film = new Film();
        film.setDescription("Horror movie about a big shark");
        Assertions.assertEquals("Horror movie about a big shark", film.getDescription(), "Error: Incorrect film description was returned\n" +
                "Actual results: " + film.getDescription());
    }

    @Test
    void getFilmReleaseYear() {
        Film film = new Film();
        film.setRelease_year(2010);
        Assertions.assertEquals(2010, film.getRelease_year(), "Error: Incorrect film release year was returned\n" +
                "Actual results: " + film.getRelease_year());
    }

    @Test
    void getRentDuration() {
        Film film = new Film();
        film.setRental_duration(2);
        Assertions.assertEquals(2, film.getRental_duration(), "Error: Incorrect rental duration was returned\n" +
                "Actual results: " + film.getRental_duration());
    }

    @Test
    void getRentalRate() {
        Film film = new Film();
        film.setRental_rate(6);
        Assertions.assertEquals(6, film.getRental_rate(), "Error: Incorrect rental rate was returned\n" +
                "Actual results: " + film.getRental_rate());
    }

    @Test
    void getFilmLength() {
        Film film = new Film();
        film.setLength(100);
        Assertions.assertEquals(100, film.getLength(), "Error: Incorrect film length was returned\n" +
                "Actual results: " + film.getLength());
    }

    @Test
    void getFilmRating() {
        Film film = new Film();
        film.setRating("15");
        Assertions.assertEquals("15", film.getRating(), "Error: Incorrect rating was returned\n" +
                "Actual results: " + film.getRating());
    }

    @Test
    void deleteFilm() {
        Film film = new Film();
        film.setTitle("Jaws");
        film.setFilm_id(3);
        sakilaAppApplication.removeCategory(film.getFilm_id());
        verify(categoryRepository).deleteById(film.getFilm_id());
    }

}