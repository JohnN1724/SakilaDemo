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
    void getActorID(){
       Actor actor = new Actor();
       actor.setActorId(2);
       Assertions.assertEquals(2, actor.getActorId(), "Error: Incorrect actor id was returned\n" +
               "Actual results: " + actor.getActorId());
    }

    @Test
    void getActorFirstName(){
        Actor actor = new Actor();
        actor.setFirst_name("Keith");
        Assertions.assertEquals("Keith", actor.getFirst_name(), "Error: Incorrect actor first name was returned\n" +
                "Actual results: " + actor.getFirst_name());
    }
    @Test
    void getActorLastName(){
        Actor actor = new Actor();
        actor.setLast_name("Jones");
        Assertions.assertEquals("Jones", actor.getLast_name(), "Error: Incorrect actor last name was returned\n" +
                "Actual results: " + actor.getLast_name());
    }

    @Test
    void DeleteActorById(){
        Actor actor = new Actor();
        actor.setFirst_name("Bill");
        actor.setLast_name("Bob");
        actor.setActorId(3);
        sakilaAppApplication.removeActor(actor.getActorId());
        verify(actorRepository).deleteById(actor.getActorId());
    }

}
