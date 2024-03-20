package seccion9hibernet.seccion9hibernet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import seccion9hibernet.seccion9hibernet.entities.Person;
import seccion9hibernet.seccion9hibernet.repositories.PersonRepository;

@SpringBootApplication
public class Seccion9hibernetApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Seccion9hibernetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Person> persons = (List<Person>) repository.findAll();

		persons.stream().forEach(person -> System.out.println(person));

	}

}
