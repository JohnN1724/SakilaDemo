package com.sakila.jnuttall.CucumberTests;

import com.sakila.jnuttall.SakilaApp.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
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


    public DisplayActorStepDef(){

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
    @Given("when an Actor ID is requested")
    public void when_an_actor_id_is_requested() {
        // Write code here that turns the phrase above into concrete actions
        int id = 1;
        expected = new Actor();
        expected.setActorId(1);
        expected.setFirst_name("Bill");
        expected.setLast_name("Bob");
    }

    @Given("the API requests the actor")
    public void the_api_requests_the_actor() {
        // Write code here that turns the phrase above into concrete actions
        when(actorRepository.findById(1)).thenReturn(Optional.of(expected));
        testActor = actorRepository.findById(1).get();
        throw new io.cucumber.java.PendingException();
    }

    @Then("the actor is displayed")
    public void the_actor_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(expected, testActor, "Error: Actor wasn't returned"+
                "Actual results: " + testActor);
        throw new io.cucumber.java.PendingException();
    }
}
