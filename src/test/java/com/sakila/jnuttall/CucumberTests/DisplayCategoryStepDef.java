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

public class DisplayCategoryStepDef {

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


    public DisplayCategoryStepDef(){

        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);
        languageRepository = mock(LanguageRepository.class);
        filmCategoryRepository = mock(FilmCategoryRepository.class);

        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository,
                filmCategoryRepository, languageRepository);
    }

    Category testCategory;
    Category expected;
    @Given("A category has been requested")
    public void a_category_has_been_requested() {
        int id = 1;
        expected = new Category();
        expected.setCategoryId(1);
        expected.setCategoryName("Vikings");
    }

    @When("The API returns the requested category")
    public void the_api_returns_the_requested_category() {
        when(categoryRepository.findById(1)).thenReturn(Optional.of(expected));
        testCategory = categoryRepository.findById(1).get();
    }

    @Then("The requested category is displayed")
    public void the_requested_category_is_displayed() {
        Assertions.assertEquals(expected, testCategory, "Error: Desired category wasn't returned\n" +
                "Actual results:" + testCategory);
    }

}
