package com.sakila.jnuttall.SakilaApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
@CrossOrigin
public class SakilaAppApplication {


	@Autowired

	//create objects
	private ActorRepository actorRepository;
	private FilmRepository filmRepository;
	private CategoryRepository categoryRepository;


	public SakilaAppApplication(ActorRepository actorRepository,
								FilmRepository filmRepository, CategoryRepository categoryRepository) {
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.categoryRepository = categoryRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(SakilaAppApplication.class, args);
	}

	@GetMapping("/allActors")
	@ResponseBody
	public Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}
	//Get actor by input ID

	@GetMapping("/Actor/{id}")
	@ResponseBody
	public Optional<Actor> getActor(@PathVariable Integer id) {
		return actorRepository.findById(id);
	}

	//Add actor
	@PostMapping("/addActor")
	@ResponseBody
	public String addActor(@RequestBody Actor actor) {
		actorRepository.save(actor);
		return ("Actor added");
	}

	//Edit info actor by input ID
	@PutMapping("/editActor/{id}")
	@ResponseBody
	public String editActor(@PathVariable Integer id, @RequestBody Actor newAct) {
		final Actor actor = actorRepository.findById(id).get();
		actor.setFirst_name(newAct.first_name);
		actor.setLast_name(newAct.last_name);
		actorRepository.save(actor);

		return ("Actor Edited");
	}

	//Remove actor based by input ID
	@DeleteMapping("/removeActor/{id}")
	@ResponseBody
	public String removeActor(@PathVariable Integer id) {
		actorRepository.deleteById(id);
		return ("Actor: " + id) + " has been removed";
	}

	//Find actor by their names
	@GetMapping("/findActorByName")
	@ResponseBody
	public Iterable<Actor> getActByName(String firstName, String lastName) {
		return actorRepository.searchByFirstLastName(firstName, lastName);
	}


	//Get all films
	@GetMapping("/allFilms")
	@ResponseBody
	public Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	//Get films by film's ID
	@GetMapping("/Film/{id}")
	@ResponseBody
	public Optional<Film> getFilm(@PathVariable Integer id) {
		return filmRepository.findById(id);
	}


	//Remove film based with input ID
	@DeleteMapping("/removeFilm/{id}")
	@ResponseBody
	public String removeFilm(@PathVariable Integer id) {
		filmRepository.deleteById(id);
		return ("Film: " + id + " has been removed");
	}

	//Edit film based with input ID
	@PutMapping("/editFilm/{id}")
	@ResponseBody
	public String editFilm(@PathVariable Integer id, @RequestBody Film newFilm) {
		final Film film = filmRepository.findById(id).get();
		film.setTitle(newFilm.title);
		film.setDescription(newFilm.description);
		filmRepository.save(film);
		return ("Film: " + id + " has been edited");
	}

	@GetMapping("/allCategory")
	@ResponseBody
	public Iterable<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@GetMapping("/Category/{id}")
	@ResponseBody
	public Optional<Category> getCategory(@PathVariable Integer id) {
		return categoryRepository.findById(id);
	}

	@DeleteMapping("/removeCategory/{id}")
	@ResponseBody
	public String removeCategory(@PathVariable Integer id) {
		categoryRepository.deleteById(id);
		return ("Category: " + id + " has been removed");
	}

	@PutMapping("/editCategory/{id}")
	@ResponseBody
	public String editCategory(@PathVariable Integer id, @RequestBody Category newCat) {
		Category category = categoryRepository.findById(id).get();
		category.setCategoryName(newCat.categoryName);
		categoryRepository.save(category);
		return ("Category: " + id + " has been edited");
	}

}
