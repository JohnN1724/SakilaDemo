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
public class CategoryRepoTests {


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
    void getAllCategories()
    {

        List<Category> categoryList = new ArrayList<>();

        Category testCategory = new Category(1,"Adventure");
        Category testCategory2 = new Category(2, "Viking");

        categoryList.add(testCategory);
        categoryList.add(testCategory2);

        Iterable <Category> categoryIterable = categoryList;

        when(categoryRepository.findAll()).thenReturn(categoryIterable);

        Iterable <Category> Expected = categoryIterable;
        Iterable <Category> Actual = sakilaAppApplication.getAllCategory();

        Assertions.assertEquals(Expected, Actual, "Error: All categories weren't returned\n" +
                "Actual results: " + Actual);

    }


    @Test
    void getCategoryID(){
        Category category = new Category();
        category.setCategoryId(2);
        Assertions.assertEquals(2, category.getCategoryId(), "Error: Incorrect category ID was returned\n"+
                "Actual results: " + category.getCategoryId());
    }

    @Test
    void getCategoryName(){
        Category category = new Category();
        category.setCategoryName("Action");
        Assertions.assertEquals("Action", category.getCategoryName(), "Error: Wrong category returned\n" +
                "Actual results: " + category.getCategoryName());
    }

    @Test
    void deleteCategory(){
        Category category = new Category();
        category.setCategoryName("Drama");
        category.setCategoryId(3);
        sakilaAppApplication.removeCategory(category.getCategoryId());
        verify(categoryRepository).deleteById(category.getCategoryId());
    }

}
