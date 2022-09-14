package com.sakila.jnuttall.SakilaApp;

import org.apache.commons.codec.language.bm.Lang;
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
public class LanguageRepoTests {


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
    void setup()
    {
        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository,
                filmCategoryRepository, languageRepository);
    }


    @Test
    void getAllLanguages()
    {

        List<Language> languageList = new ArrayList<>();

        Language testLanguage = new Language(1,"German");
        Language testLanguage2 = new Language(2, "Mandarin");

        languageList.add(testLanguage);
        languageList.add(testLanguage2);

        Iterable <Language> languageIterable = languageList;

        when(languageRepository.findAll()).thenReturn(languageIterable);

        Iterable <Language> Expected = languageIterable;
        Iterable <Language> Actual = sakilaAppApplication.getAllLanguage();

        Assertions.assertEquals(Expected, Actual, "Error: All languages weren't returned \n"
                + "Actual results: " + Actual);

    }

    @Test
    void testALanguage(){
        when(languageRepository.findById(1)).thenReturn(Optional.of(new Language()));
        Language output = languageRepository.findById(1).get();
        Language expected = new Language();
        Assertions.assertEquals(expected, output, "Error: Incorrect language was returned\n" +
                "Actual results: " + output);

    }

    @Test
    void testEditLanguage(){
        Language language = new Language();
        Assertions.assertEquals(null, language.name);
        when(languageRepository.findById(1)).thenReturn(Optional.of(language));
        Language newLanguage = new Language();
        newLanguage.setName("Korean");
        ArgumentCaptor<Language> captor = ArgumentCaptor.forClass(Language.class);
        sakilaAppApplication.editLanguage(1, newLanguage);
        verify(languageRepository).save(newLanguage);
    }
}

