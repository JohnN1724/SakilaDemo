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

public class DisplayActorStepDef {

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


    @BeforeEach
    void setup(){

        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);
        languageRepository = mock(LanguageRepository.class);
        filmCategoryRepository = mock(FilmCategoryRepository.class);

        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository,
                filmCategoryRepository, languageRepository);
    }

    Actor testActor;
    Actor expected;
    @Given("there is an Actor ID")
    public void there_is_an_id() {
        int id = 1;
        expected = new Actor();
        expected.setActorId(1);
        expected.setFirst_name("First Name");
        expected.setLast_name("Last Name");
    }

    @When("the api connects to actor")
    public void the_api_is_connected() {
        when(actorRepository.findById(1)).thenReturn(Optional.of(expected));
        testActor = actorRepository.findById(1).get();
    }

    @Then("display an actor")
    public void display_film() {
        Assertions.assertEquals(expected, testActor, "Error: Actor wasn't returned"+
                "Actual results: " + testActor);
    }
}
