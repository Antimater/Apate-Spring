package guru.springframework.spring6webapp.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.domain.Author;

import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import guru.springframework.spring6webapp.repositories.AuthorRepository;




@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	private static Logger logger = LogManager.getLogger(BootstrapData.class);
	

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) 
	{
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// Create author eric
		Author eric = new Author();
		eric.setFirstName("Eric");
		eric.setLastName("Evans");
		
		//create book domain driven design
		Book ddd = new Book();
		ddd.setTitle("Domain Driven Design");
		ddd.setIsbn("123456");
		
		//save author and book to repo
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
		dddSaved.getAuthors().add(ericSaved);
		noEJBSaved.getAuthors().add(rodSaved);
		
		
		
		//create publisher
		Publisher publisher = new Publisher();
		publisher.setPublisherName("My Publisher");
		publisher.setAddress("123 Main");
		
		Publisher savedPublisher = publisherRepository.save(publisher);
		
		dddSaved.setPublisher(savedPublisher);
		noEJBSaved.setPublisher(savedPublisher);

		authorRepository.save(ericSaved);
		authorRepository.save(rodSaved);
		bookRepository.save(dddSaved);
		bookRepository.save(noEJBSaved);
		publisherRepository.save(savedPublisher);		
		
		logger.trace("In Bootstrap");
		logger.trace("Author Count: " + authorRepository.count());
		
		System.out.println("In Bootstrap");
		System.out.println("Author Count: " + authorRepository.count());
		System.out.println("Book Count: " + bookRepository.count());
		System.out.println("Publisher Count: " + publisherRepository.count());

	}

}
