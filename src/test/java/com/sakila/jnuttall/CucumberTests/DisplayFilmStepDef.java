package com.sakila.jnuttall.CucumberTests;

import com.sakila.jnuttall.SakilaApp.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DisplayFilmStepDef {

    SakilaAppApplication sakilaAppApplication;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;



    public DisplayFilmStepDef(){

        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);
        languageRepository = mock(LanguageRepository.class);
        filmCategoryRepository = mock(FilmCategoryRepository.class);

        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository,
                filmCategoryRepository, languageRepository);
    }

    Film testFilm;
    Film expected;
    @Given("The webpage is loaded and is in use")
    public void the_webpage_is_loaded_and_is_in_use() {
        int id = 1;
        expected = new Film();
        expected.setFilm_id(1);
        expected.setTitle("Jaws");
        expected.setDescription("Horror film about a big shark");
    }

    @When("The API returns the list of films")
    public void the_api_returns_the_list_of_films() {
        when(filmRepository.findById(1)).thenReturn(Optional.of(expected));
        testFilm = filmRepository.findById(1).get();
    }

    @Then("Display a list of films")
    public void display_a_list_of_films() {
        Assertions.assertEquals(expected, testFilm, "Error: Desired film wasn't returned\n" +
                "Actual results:" + testFilm);
    }
}
