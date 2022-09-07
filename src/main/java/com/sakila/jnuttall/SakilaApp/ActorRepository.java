package com.sakila.jnuttall.SakilaApp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    @Query(value ="SELECT * FROM Actor a WHERE (:first_name is null or a.first_name = :first_name) AND (:last_name is null or a.last_name = :last_name)",
            nativeQuery = true)
    Iterable<Actor> searchByFirstLastName(@Param("first_name") String firstName, @Param("last_name") String lastName);
}