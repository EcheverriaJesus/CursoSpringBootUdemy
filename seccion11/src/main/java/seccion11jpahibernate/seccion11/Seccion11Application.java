package seccion11jpahibernate.seccion11;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import seccion11jpahibernate.seccion11.entities.Address;
import seccion11jpahibernate.seccion11.entities.Client;
import seccion11jpahibernate.seccion11.entities.ClientDetails;
import seccion11jpahibernate.seccion11.entities.Course;
import seccion11jpahibernate.seccion11.entities.Invoice;
import seccion11jpahibernate.seccion11.entities.Student;
import seccion11jpahibernate.seccion11.repositories.ClientDetailsRepository;
import seccion11jpahibernate.seccion11.repositories.ClientRepository;
import seccion11jpahibernate.seccion11.repositories.CourseRepository;
import seccion11jpahibernate.seccion11.repositories.InvoiceRepository;
import seccion11jpahibernate.seccion11.repositories.StudentRepository;

@SpringBootApplication
public class Seccion11Application implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private ClientDetailsRepository clientDetailsRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(Seccion11Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToManyRemoveBodireccionalFind();
	}

	@Transactional
	public void manyToManyRemoveBodireccionalFind() {
		Optional<Student> studentoOptional1 = studentRepository.findOneWithCourses(1L);
		Optional<Student> studentoOptional2 = studentRepository.findOneWithCourses(2L);

		Student student1 = studentoOptional1.get();
		Student student2 = studentoOptional2.get();

		Course course1 = courseRepository.findOneWithStudents(1L).get();
		Course course2 = courseRepository.findOneWithStudents(2L).get();

		/* student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2)); */

		
		student1.addCourses(course1);
		student1.addCourses(course2);
		student2.addCourses(course2);

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(1L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptionalDb = courseRepository.findOneWithStudents(1L);

			if (courseOptionalDb.isPresent()) {
				Course courseDb = courseOptionalDb.get();
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyBodireccionalFind() {
		Optional<Student> studentoOptional1 = studentRepository.findOneWithCourses(1L);
		Optional<Student> studentoOptional2 = studentRepository.findOneWithCourses(2L);

		Student student1 = studentoOptional1.get();
		Student student2 = studentoOptional2.get();

		Course course1 = courseRepository.findOneWithStudents(1L).get();
		Course course2 = courseRepository.findOneWithStudents(2L).get();

		/* student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2)); */

		
		student1.addCourses(course1);
		student1.addCourses(course2);
		student2.addCourses(course2);

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToManyBidireccional() {
		Student student1 = new Student("Adris", "Medina");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso java Master", "Andres");
		Course course2 = new Course("Curso java SpringBoot", "Andres");

/* 		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2)); */

		student1.addCourses(course1);
		student1.addCourses(course2);
		student2.addCourses(course2);

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToManyRemove() {
		Student student1 = new Student("Adris", "Medina");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso java Master", "Andres");
		Course course2 = new Course("Curso java SpringBoot", "Andres");

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(3L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptionalDb = courseRepository.findOneWithStudents(3L);

			if (courseOptionalDb.isPresent()) {
				Course courseDb = courseOptionalDb.get();
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyRemoveFind() {
		Optional<Student> studentoOptional1 = studentRepository.findById(1L);
		Optional<Student> studentoOptional2 = studentRepository.findById(2L);

		Student student1 = studentoOptional1.get();
		Student student2 = studentoOptional2.get();

		Course course1 = courseRepository.findById(1L).get();
		Course course2 = courseRepository.findById(2L).get();

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(1L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptionalDb = courseRepository.findById(2L);

			if (courseOptionalDb.isPresent()) {
				Course courseDb = courseOptionalDb.get();
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyFind() {
		Optional<Student> studentoOptional1 = studentRepository.findById(1L);
		Optional<Student> studentoOptional2 = studentRepository.findById(2L);

		Student student1 = studentoOptional1.get();
		Student student2 = studentoOptional2.get();

		Course course1 = courseRepository.findById(1L).get();
		Course course2 = courseRepository.findById(2L).get();

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToMany() {
		Student student1 = new Student("Adris", "Medina");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso java Master", "Andres");
		Course course2 = new Course("Curso java SpringBoot", "Andres");

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(List.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void oneToOneBidireccionalFinfById() {

		Optional<Client> clientOptional = clientRepository.findOne(2L);

		clientOptional.ifPresent(client -> {
			ClientDetails clientDetails = new ClientDetails(true, 5000);

			client.setClientDetails(clientDetails);

			clientRepository.save(client);
		});

	}

	@Transactional
	public void oneToOneBidireccional() {

		Client client = new Client("Rrba", "Pura");
		ClientDetails clientDetails = new ClientDetails(true, 5000);

		client.setClientDetails(clientDetails);

		clientRepository.save(client);
	}

	@Transactional
	public void oneToOneFindById() {

		ClientDetails clientDetails = new ClientDetails(true, 5000);
		clientDetailsRepository.save(clientDetails);

		Optional<Client> clientOptional = clientRepository.findOne(2L); // new Client("Rrba", "Pura");
		clientOptional.ifPresent(client -> {
			client.setClientDetails(clientDetails);
			clientRepository.save(client);

			System.out.println(client);
		});
	}

	@Transactional
	public void oneToOne() {

		ClientDetails clientDetails = new ClientDetails(true, 5000);
		clientDetailsRepository.save(clientDetails);

		Client client = new Client("Rrba", "Pura");
		client.setClientDetails(clientDetails);
		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void removeInvoiceBidireccional() {

		Client client = new Client("Sulibeth", "Medina");

		Invoice invoice1 = new Invoice("Compras de la casa", 5000L);
		Invoice Invoice2 = new Invoice("Compras de la oficiona Noe", 8000L);

		client.addInvoice(invoice1).addInvoice(Invoice2);
		clientRepository.save(client);

		Optional<Client> optionalClientDb = clientRepository.findOne(3L);

		optionalClientDb.ifPresent(clientDb -> {
			/*
			 * Invoice invoice3 = new Invoice("Compras de la casa", 5000L);
			 * invoice3.setId(1L);
			 */

			Optional<Invoice> invoiceOptional = invoiceRepository.findById(2L);
			invoiceOptional.ifPresent(invoice -> {
				clientDb.removeInvoice(invoice);
				clientRepository.save(clientDb);
			});
		});

	}

	@Transactional
	public void removeInvoiceBidireccionalFindById() {
		Optional<Client> optionalClient = clientRepository.findOne(1L);

		optionalClient.ifPresent(client -> {

			Invoice invoice1 = new Invoice("Compras de la casa", 5000L);
			Invoice Invoice2 = new Invoice("Compras de la oficiona Noe", 8000L);

			client.addInvoice(invoice1).addInvoice(Invoice2);
			clientRepository.save(client);

			System.out.println(client);
		});

		Optional<Client> optionalClientDb = clientRepository.findOne(1L);

		optionalClientDb.ifPresent(client -> {
			Invoice invoice3 = new Invoice("Compras de la casa", 5000L);
			invoice3.setId(1L);

			Optional<Invoice> invoiceOptional = Optional.of(invoice3);
			invoiceOptional.ifPresent(invoice -> {
				client.removeInvoice(invoice);
				clientRepository.save(client);
				System.out.println(client);
			});
		});

	}

	@Transactional
	public void oneToManyInvoiceBidireccionalFindById() {
		Optional<Client> optionalClient = clientRepository.findOne(1L);

		optionalClient.ifPresent(client -> {

			Invoice invoice1 = new Invoice("Compras de la casa", 5000L);
			Invoice Invoice2 = new Invoice("Compras de la oficiona Noe", 8000L);

			client.addInvoice(invoice1).addInvoice(Invoice2);
			clientRepository.save(client);
		});
	}

	@Transactional
	public void oneToManyInvoiceBidireccional() {
		Client client = new Client("Sulibeth", "Medina");

		Invoice invoice1 = new Invoice("Compras de la casa", 5000L);
		Invoice Invoice2 = new Invoice("Compras de la oficiona Noe", 8000L);

		client.addInvoice(invoice1).addInvoice(Invoice2);
		clientRepository.save(client);
	}

	@Transactional
	public void removeAddressFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {

			Address address1 = new Address("Pino", 84);
			Address address2 = new Address("Esperanza", 85);

			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);

			clientRepository.save(client);

			System.out.println(client);

			Optional<Client> optionalClient2 = clientRepository.findOneWithAddresses(2L);
			optionalClient2.ifPresent(c -> {
				c.getAddresses().remove(address2);
				clientRepository.save(c);
				System.out.println(c);
			});
		});
	}

	@Transactional
	public void removeAddress() {
		Client client = new Client("Sulibeth", "Medina");

		Address address1 = new Address("Pino", 84);
		Address address2 = new Address("Esperanza", 85);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println(client);

		Optional<Client> optionalClient = clientRepository.findById(3L);
		optionalClient.ifPresent(c -> {
			c.getAddresses().remove(address1);
			clientRepository.save(c);
			System.out.println(c);
		});
	}

	@Transactional
	public void oneToManyFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {

			Address address1 = new Address("Pino", 84);
			Address address2 = new Address("Esperanza", 85);

			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);

			clientRepository.save(client);

			System.out.println(client);
		});
	}

	@Transactional
	public void oneToMany() {
		Client client = new Client("Sulibeth", "Medina");

		Address address1 = new Address("Pino", 84);
		Address address2 = new Address("Esperanza", 85);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void manyToOne() {
		Client client = new Client("David", "Echeverria");
		clientRepository.save(client);

		Invoice invoice = new Invoice("compras de oficina", 2000L);
		invoice.setClient(client);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		System.out.println(invoiceDB);
	}

	@Transactional
	public void manyToOneFindByIdClient() {
		Optional<Client> optionalClient = clientRepository.findById(1L);

		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();

			Invoice invoice = new Invoice("compras de oficina", 2000L);
			invoice.setClient(client);
			Invoice invoiceDB = invoiceRepository.save(invoice);
			System.out.println(invoiceDB);
		}
	}
}
