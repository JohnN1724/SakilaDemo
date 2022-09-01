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
	private ActorRepository actorRepository;

	public SakilaAppApplication(ActorRepository actorRepository) {

		this.actorRepository = actorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaAppApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("/getActor/{id}")
	public @ResponseBody
	Optional<Actor> getActor(@PathVariable Integer id) {
		return actorRepository.findById(id);
	}

	@PutMapping("/add")
	@ResponseBody
	public void change(@RequestParam int id, @RequestParam String first_name, @RequestParam String last_name) {

	}
}
