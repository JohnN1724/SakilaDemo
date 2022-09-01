package com.sakila.jnuttall.SakilaApp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    int actor_id;
    @Column(name = "first_name")
    String first_name;
    @Column(name = "last_name")
    String last_name;

    private List<Actor> ActorList= new ArrayList();

    public Actor(int actor_id, String first_name, String last_name){
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Actor(){}

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Actor> getActorList(){
        return this.ActorList;
    }


    public void addActor(Actor a){
        this.ActorList.add(a);
    }
}
