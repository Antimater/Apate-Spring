package bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import domain.Author;
import domain.Book;
import repositories.AuthorRepository;
import repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author();
		eric.setFirstName("Eric");
		eric.setLastName("Evans");

		Book ddd = new Book();
		ddd.setTitle("Domain Driven Design");
		ddd.setIsbn("123456");

		Author ericSaved = authorRepository.save(eric);
		Book dddSaved = bookRepository.save(ddd);

		Author rod = new Author();
		eric.setFirstName("Rod");
		eric.setLastName("Johnson");

		Book noEJB = new Book();
		ddd.setTitle("J2EE Development withour EJB");
		ddd.setIsbn("54757585");

		Author rodSaved = authorRepository.save(rod);
		Book noEJBSaved = bookRepository.save(noEJB);

		ericSaved.getBook().add(dddSaved);
		rodSaved.getBook().add(noEJBSaved);

		System.out.println("In Bootstrap");
		System.out.println("Author Count: " + authorRepository.count());

	}

}
