package com.sakila.jnuttall.SakilaApp;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language{
    //attributes
    //defines the primary key
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int language_id;
    @Column(name = "name")
    String name;

    public Language(int language_id, String name){

        this.language_id = language_id;
        this.name = name;
    }

    public Language(){}

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
