package com.sakila.jnuttall.SakilaApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

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
    void setup(){
        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository,
                filmCategoryRepository, languageRepository);
    }

    @Test
    void testGetAllFilms(){

        List<Film> filmList = new ArrayList<>();

        Film testFilm = new Film (1,"Filmy Film", "Adventure", 2005,
                6, 5, 1.99, 88, 4, "PG", "Bonus features" );
        Film testFilm2 = new Film(2,"Filmington", "Period Drama Romcom", 2005,
                6, 88, 1.99, 90, 3, "PG", "Behind the scenes");

        filmList.add(testFilm);
        filmList.add(testFilm2);

        Iterable <Film> filmIterable = filmList;

        when(filmRepository.findAll()).thenReturn(filmIterable);

        Iterable <Film> Expected = filmIterable;
        Iterable <Film> Actual = sakilaAppApplication.getAllFilms();

        Assertions.assertEquals(Expected, Actual, "Error: All Films have not been returned\n" +
                "Actual Results: " + Actual);

    }

}