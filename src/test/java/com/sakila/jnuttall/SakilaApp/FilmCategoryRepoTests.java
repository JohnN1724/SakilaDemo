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
public class FilmCategoryRepoTests {


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
    void getAllfilmCategories()
    {

        List<FilmCategory> filmCategoryList = new ArrayList<>();

        FilmCategory testfilmCategory = new FilmCategory(1,9);
        FilmCategory testfilmCategory2 = new FilmCategory(2, 9);

        filmCategoryList.add(testfilmCategory);
        filmCategoryList.add(testfilmCategory2);

        Iterable <FilmCategory> filmCategoryIterable = filmCategoryList;

        when(filmCategoryRepository.findAll()).thenReturn(filmCategoryIterable);

        Iterable <FilmCategory> Expected = filmCategoryIterable;
        Iterable <FilmCategory> Actual = sakilaAppApplication.getAllFilmCategory();

        Assertions.assertEquals(Expected, Actual, "Error: All film Categories weren't returned \n"
                + "Actual results: " + Actual);

    }

    @Test
    void testAFilmCategory(){
        when(filmCategoryRepository.findById(1)).thenReturn(Optional.of(new FilmCategory()));
        FilmCategory output = filmCategoryRepository.findById(1).get();
        FilmCategory expected = new FilmCategory();
        Assertions.assertEquals(expected, output, "Error: Incorrect film category was returned\n" +
                "Actual results: " + output);

    }

    @Test
    void testEditFilmCategory(){
        FilmCategory filmCategory = new FilmCategory();
        Assertions.assertEquals((Integer) null, filmCategory.categoryId);
        when(filmCategoryRepository.findById(1)).thenReturn(Optional.of(filmCategory));
        FilmCategory newCategoryId = new FilmCategory();
        newCategoryId.setCategoryId(9);
        ArgumentCaptor<FilmCategory> captor = ArgumentCaptor.forClass(FilmCategory.class);
        sakilaAppApplication.editFilmCategory(1, newCategoryId);
        verify(filmCategoryRepository).save(newCategoryId);
    }

}

