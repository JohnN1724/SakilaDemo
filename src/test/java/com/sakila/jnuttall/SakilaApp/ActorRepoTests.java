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
public class ActorRepoTests {

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
    void testAllActors(){

        List <Actor> actorList = new ArrayList<>();

        Actor testActor = new Actor(1, "Pingu", "Penguin");
        Actor anotherActor = new Actor(2, "Postman", "Pat");

        actorList.add(testActor);
        actorList.add(anotherActor);

        Iterable <Actor> actorIterable = actorList;

        when(actorRepository.findAll()).thenReturn(actorIterable);

        Iterable <Actor> Expected = actorIterable;
        Iterable <Actor> Actual = sakilaAppApplication.getAllActors();

        Assertions.assertEquals(Expected, Actual , "Error - Not all actors were returned\n"
        + "Actual results: " + Actual);

    }

    @Test
    void testAnActor(){
        when(actorRepository.findById(1)).thenReturn(Optional.of(new Actor()));
        Actor output = actorRepository.findById(1).get();
        Actor expected = new Actor();
        Assertions.assertEquals(expected, output, "Error: Incorrect actor was returned\n" +
                "Actual results: " + output);

    }

    @Test
    void testEditActor(){
        Actor actor = new Actor();
        Assertions.assertEquals(null, actor.first_name);
        when(actorRepository.findById(1)).thenReturn(Optional.of(actor));
        Actor newFirstName = new Actor();
        newFirstName.setFirst_name("Postperson");
        ArgumentCaptor<Actor> captor = ArgumentCaptor.forClass(Actor.class);
        sakilaAppApplication.editActor(1, newFirstName);
        verify(actorRepository).save(newFirstName);
    }
}
