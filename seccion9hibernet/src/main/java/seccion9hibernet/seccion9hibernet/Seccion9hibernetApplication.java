package seccion9hibernet.seccion9hibernet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.transaction.annotation.Transactional;

import seccion9hibernet.seccion9hibernet.dto.PersonDto;
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

		whereIn();
	}

	@Transactional(readOnly = true)
	public void whereIn() {
		System.out.println("------------ Consulta para obtner varios id con where in:");
		List<Person> persons = repository.getPersonByIds(Arrays.asList(1L, 2L, 5L, 7L));
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void subQueries() {
		System.out.println("------------ Consulta el nombre mas corto y su longitud :");
		List<Object[]> registers = repository.getShorterName();
		registers.forEach(reg -> {
			String name = (String) reg[0];
			Integer length = (Integer) reg[1];
			System.out.println("name = "+ name + ", length = " + length);
		});

		System.out.println("------------ Consulta para obtner el ultimo registro de persona :");
		Optional<Person> optionalPerson = repository.getLastRegistration();
		optionalPerson.ifPresent(System.out::println);

	}

	@Transactional(readOnly = true)
	public void QyueriesFunctionAgregation() {

		System.out.println("----------------- Consulta de CONT :");
		Long count = repository.getTotalPerson();
		System.out.println(count);

		System.out.println("----------------- Consulta de MIN :");
		Long min = repository.getMinId();
		System.out.println(min);

		System.out.println("----------------- Consulta de MAX :");
		Long max = repository.getMaxId();
		System.out.println(max);

		System.out.println("----------------- Consulta de Nombre y su tamaño");
		List<Object[]> regs = repository.getPersonNameLength();
		regs.forEach(reg -> {
			String name = (String) reg[0];
			Integer length = (Integer) reg[1];
			System.out.println("name = " + name + " length = " + length);
		});

		System.out.println("----------------- Consulta del minimo en tamaño del nombre :");
		Integer minLengthName = repository.getMinLengthName();
		System.out.println(minLengthName);

		System.out.println("----------------- Consulta del maximo en tamaño del nombre :");
		Integer maxLengthName = repository.getMaxLengthName();
		System.out.println(maxLengthName);

		System.out.println(
				"----------------- Consulta del Resumen de funciones de agregacion min, max, sum, avg, count :");
		Object[] resumeReg = (Object[]) repository.getResumeAgregationFunction();
		System.out.println("min = " + resumeReg[0] +
				", max = " + resumeReg[1] +
				", suma = " + resumeReg[2] +
				", avg = " + resumeReg[3] +
				", count = " + resumeReg[4]);

	}

	@Transactional
	public void PersonalizedQueriesBetween() {
		System.out.println("Consultas de BETWEEN en Id");
		List<Person> persons = repository.findAllBetweenId(2L, 5L);
		persons.forEach(System.out::println);

		System.out.println("Consultas de BETWEEN en Names");
		List<Person> personsName = repository.findAllBetweenName("J", "Q");
		personsName.forEach(System.out::println);

		System.out.println("Consultas sin utilizar el @Query");

		System.out.println("Consultas de BETWEEN en Id");
		List<Person> persons2 = repository.findByIdBetweenOrderByIdAsc(2L, 5L);
		persons2.forEach(System.out::println);

		System.out.println("Consultas de BETWEEN en Names");
		List<Person> personsName2 = repository.findByNameBetweenOrderByNameAscLastnameDesc("J", "Q");
		personsName2.forEach(System.out::println);

		persons = repository.findAllByOrderByNameDescLastnameAsc();
		persons.forEach(System.out::println);
	}

	@Transactional
	public void personalizedQueriesConcatUpperAndLowerCase() {
		System.out.println("Consulta nombres y apellidos de personas con Concat");
		List<String> names = repository.findAllFullNameConcat();
		names.forEach(System.out::println);

		System.out.println("Consulta de Nombres y Apellidos con ||");
		List<String> names2 = repository.findAllFullNameConcatdiferent();
		names2.forEach(System.out::println);

		System.out.println("Consulta con UPPER:");
		List<String> mayus = repository.findAllFullNameConcatUpper();
		mayus.forEach(System.out::println);

		System.out.println("Consulta con LOWER:");
		List<String> minus = repository.findAllFullNameConcatLower();
		minus.forEach(System.out::println);

		System.out.println("Consulta con LOWER & UPPER:");
		List<String> upperandLower = repository.findAllPersonDataListCase();
		upperandLower.forEach(System.out::println);
	}

	@Transactional
	public void personalizedQueriesDistinct() {
		System.out.println("Consultas con Nombres de Personas");
		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);

		System.out.println("Nombres no duplicados:============");
		List<String> nameDis = repository.findAllNamesDistinct();
		nameDis.forEach(System.out::println);

		System.out.println("Lenguajes no repetidos ==============");
		List<String> languages = repository.findAllProgrammingLanguageDistinct();
		languages.forEach(System.out::println);

		System.out.println("Total de Lenguajes ==============");
		Long languagesCount = repository.findAllProgrammingLanguageDistinctCount();
		System.out.println("Total de lenguajes de programación: " + languagesCount);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries2() {
		System.out.println("=================================Consulta por persona y lenguaje de programacion:");
		List<Object[]> personsRegs = repository.findAllMixPerson();

		personsRegs.forEach(reg -> {
			System.out.println("programmingLanguaje= " + reg[1] + ", persona= " + reg[0]);
		});

		System.out.println("Consulta de puebla y devuelve objecto entity de una instancia personalizada");
		List<Person> persons = repository.findAllObjectPersonPersonalized();
		persons.forEach(System.out::println);

		System.out.println("Consulta de puebla y devuelve objeto Dto de una clase DTO persopnalizada");
		List<PersonDto> personDto = repository.findAllPersonDto();
		personDto.forEach(System.out::println);

	}

	@Transactional(readOnly = true)
	public void personalizedQueries() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=================================Consulta solo el Nombre");
		System.out.println("Ingresa el Id, (Query personalizada)");
		Long id = scanner.nextLong();
		scanner.close();

		String name = repository.getNameById(id);
		System.out.println(name);

		Long idDb = repository.getIdById(id);
		System.out.println(idDb);

		String fullName = repository.getFullNameById(id);
		System.out.println(fullName);

		System.out.println("Consulta por campos perzonalizados por el id");
		Object[] personReg = (Object[]) repository.obtenerPersonDataById(id);
		System.out.println("id= " + personReg[0] + ", Nombre= " + personReg[1] + ", Apellido = " + personReg[2]
				+ ", Languaje = " + personReg[3]);

		System.out.println("Consulta por campos personalizados lista========================");
		List<Object[]> regs = repository.obtenerPersonDataList();
		regs.forEach(reg -> System.out.println(
				"id= " + reg[0] + ", Nombre= " + reg[1] + ", Apellido = " + reg[2] + ", Languaje = " + reg[3]));
	}

	@Transactional
	public void delete2() {
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el id del usuario a eliminar: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);
		optionalPerson.ifPresentOrElse(person -> repository.delete(person),
				() -> System.out.println("No existe el usario para eliminar"));

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void delete() {
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el id del usuario: ");
		Long id = scanner.nextLong();
		repository.deleteById(id);

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void update() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a editar:");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		/* optionalPerson.ifPresent(person -> { */
		if (optionalPerson.isPresent()) {
			Person personDB = optionalPerson.orElseThrow();
			System.out.println(personDB);
			System.out.println("Ingrese el lenguaje de programacion: ");
			String programmingLanguage = scanner.next();
			personDB.setProgrammingLanguage(programmingLanguage);
			Person personUpdate = repository.save(personDB);
			System.out.println(personUpdate);
		} else {
			System.out.println("No existe el usuario");
		}

		/* }) */;
		scanner.close();
	}

	@Transactional
	public void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el Nombre:");
		String name = scanner.next();
		System.out.println("Ingrese el Apellido:");
		String lastname = scanner.next();
		;
		System.out.println("Ingrese el Lenguanje:");
		String programminLanguage = scanner.next();
		scanner.close();

		Person person = new Person(null, name, lastname, programminLanguage);
		Person personNew = repository.save(person);
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne() {
		/*
		 * Person person =null;
		 * Optional<Person> optionalPerson = repository.findById(8L);
		 * if (optionalPerson.isPresent()) {
		 * person = optionalPerson.get();
		 * }
		 * System.out.println(person);
		 */
		repository.findByNameContaining("ria").ifPresent(System.out::println);
	}

	public void list() {

		/* List<Person> persons = (List<Person>) repository.findAll(); */
		/*
		 * List<Person> persons = (List<Person>)
		 * repository.buscarByProgrammingLanguage("Python", "Pepe");
		 */
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java", "Andres");
		persons.stream().forEach(person -> {
			System.out.println(person);
		});

		List<Object[]> personsValues = repository.obtenerPersonDataByProgrammingLanguage("Java");
		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " ES EXPERTO EN " + person[1]);
		});
	}

}
