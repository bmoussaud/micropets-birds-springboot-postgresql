package org.moussaud.micropets.pets;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BirdController {

	@Autowired
	BirdRepository repository;

	@Value("${config.from:unknown}")
	String fromValue;

	@GetMapping(value = "/liveness")
	public String liveness() {
		return "BirdServiceLiveness";
	}

	@GetMapping(value = "/readiness")
	public String readiness() {
		return "BirdServiceReadiness";
	}

	@GetMapping(value = { "", "/", "/birds/v1/data" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public BirdSummary Birds() {
		BirdSummary summary = new BirdSummary();
		try {
			if (repository.count() == 0) {
				return this.load();
			} else {
				for (Bird Bird : repository.findAll()) {
					summary.addBird(Bird);
				}
				summary.addBird(new Bird("xxxx", "xxxx", 2,
						"https://upload.wikimedia.org/wikipedia/en/0/02/Tweety.svg", this.fromValue));
			}
		} catch (Exception e) {
			return this.load();
		}

		// return summary.filter();
		return summary;
	}

	@GetMapping(value = "/birds/v1/data/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Bird Bird(@PathVariable Long index) {
		System.out.println(repository.findById(index).get());
		return repository.findById(index).get();
	}

	@GetMapping(value = "/birds/v1/load", produces = MediaType.APPLICATION_JSON_VALUE)
	public BirdSummary load() {

		repository.save(new Bird("Tweety", "Yellow Canary", 2,
				"https://upload.wikimedia.org/wikipedia/en/0/02/Tweety.svg", this.fromValue));
		repository.save(new Bird("Hector", "African Grey Parrot", 5,
				"https://petkeen.com/wp-content/uploads/2020/11/African-Grey-Parrot.webp", this.fromValue));
		repository.save(new Bird("Micheline", "Budgerigar", 3,
				"https://petkeen.com/wp-content/uploads/2020/11/Budgerigar.webp", this.fromValue));

		repository.save(new Bird("Piplette", "Cockatoo", 1,
				"https://petkeen.com/wp-content/uploads/2020/11/Cockatoo.webp", this.fromValue));
		return this.Birds();
	}

}