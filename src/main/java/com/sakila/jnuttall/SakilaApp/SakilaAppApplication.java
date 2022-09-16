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

	//Create Repos
	private ActorRepository actorRepository;
	private FilmRepository filmRepository;
	private CategoryRepository categoryRepository;

	private FilmCategoryRepository filmCategoryRepository;
	private LanguageRepository languageRepository;


	public SakilaAppApplication(ActorRepository actorRepository,
								FilmRepository filmRepository,
								CategoryRepository categoryRepository,
								FilmCategoryRepository filmCategoryRepository,
								LanguageRepository languageRepository) {

		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.categoryRepository = categoryRepository;
		this.filmCategoryRepository = filmCategoryRepository;
		this.languageRepository = languageRepository;
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

	@GetMapping("/allCategories")
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
	public String editCategory(@PathVariable Integer id, @RequestBody Category newCategory) {
		Category category = categoryRepository.findById(id).get();
		category.setCategoryName(newCategory.categoryName);
		categoryRepository.save(category);
		return ("Category: " + id + " has been edited");
	}

	@GetMapping("/allLanguage")
	@ResponseBody
	public Iterable<Language> getAllLanguage() {
		return languageRepository.findAll();
	}

	@GetMapping("/Language/{id}")
	@ResponseBody
	public Optional<Language> getLanguage(@PathVariable Integer id) {
		return languageRepository.findById(id);
	}

	@DeleteMapping("/removeLanguage/{id}")
	@ResponseBody
	public String removeLanguage(@PathVariable Integer id) {
		languageRepository.deleteById(id);
		return ("Language: " + id + " has been removed");
	}

	@PutMapping("/editLanguage/{id}")
	@ResponseBody
	public String editLanguage(@PathVariable Integer id, @RequestBody Language newLanguage) {
		Language language = languageRepository.findById(id).get();
		language.setName(newLanguage.name);
		languageRepository.save(language);
		return ("Language: " + id + " has been edited");
	}

	@GetMapping("/allFilmCategories")
	@ResponseBody
	public Iterable<FilmCategory> getAllFilmCategory() {
		return filmCategoryRepository.findAll();
	}

	@GetMapping("/FilmCategory/{id}")
	@ResponseBody
	public Optional<FilmCategory> getFilmCategory(@PathVariable Integer id) {
		return filmCategoryRepository.findById(id);
	}

	@DeleteMapping("/removeFilmCategory/{id}")
	@ResponseBody
	public String removeFilmCategory(@PathVariable Integer id) {
		filmCategoryRepository.deleteById(id);
		return ("Film category: " + id + " has been removed");
	}

	@PutMapping("/editFilmCategory/{id}")
	@ResponseBody
	public String editFilmCategory(@PathVariable Integer id, @RequestBody FilmCategory newFilmCategory) {
		FilmCategory filmCategory = filmCategoryRepository.findById(id).get();
		filmCategory.setCategoryId(newFilmCategory.categoryId);
		filmCategoryRepository.save(filmCategory);
		return ("Film category: " + id + " has been edited");
	}

}
