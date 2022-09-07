package com.sakila.jnuttall.SakilaApp;

import javax.persistence.*;


@Entity
@Table(name = "category")
public class Category
{
    //Attributes
    //define the PK
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;

    @Column(name = "name")
    String categoryName;

    //Constructors

    public Category(int categoryId, String categoryName)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    public Category(){}

    //methods

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String catName) {
        this.categoryName = catName;
    }
}
