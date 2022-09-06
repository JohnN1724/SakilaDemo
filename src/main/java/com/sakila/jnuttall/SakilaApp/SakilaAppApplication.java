package com.sakila.jnuttall.SakilaApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class SakilaAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SakilaAppApplication.class, args);
	}
	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private FilmRepository filmRepository;

	public SakilaAppApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/actor/{id}")
	public Optional<Actor> getActorById(@PathVariable("id") int id) {
		return actorRepository.findById(id);
	}

	@GetMapping("/categories/{id}")
	public Object getFilmCategory(@PathVariable("id") int id) {
		return this.filmRepository.getCategory(id);
	}

	@GetMapping("/film")
	public @ResponseBody Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@GetMapping("/filmStats")
	public @ResponseBody Iterable<Object> getFilmStats() {
		return filmRepository.getFilmInfo();
	}




}
