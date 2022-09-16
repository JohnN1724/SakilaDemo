package com.sakila.jnuttall.CucumberTests;

import com.sakila.jnuttall.SakilaApp.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

public class DisplayAllFilmsStepDef {


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

    @Given("the application is running")
    public void the_application_is_running() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("the {string} loads")
    public void the_loads(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("the api connects")
    public void the_api_connects() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("display a list of films")
    public void display_a_list_of_objects() {
        // Write code here that turns the phrase above into concrete actions

    }
}
