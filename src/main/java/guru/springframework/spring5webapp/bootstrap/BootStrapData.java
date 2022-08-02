package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("eric", "evans");
        Book confidence = new Book("confidence", 12345);
        Publisher sangam = new Publisher("sangam", "srinagar colony", "abc", "khammam");

        eric.getBooks().add(confidence);
        confidence.getAuthors().add(eric);
        sangam.getBooks().add(confidence);


        authorRepository.save(eric);
        bookRepository.save(confidence);
        publisherRepository.save(sangam);

        Author ram = new Author("ram", "sai");
        Book spring = new Book("spring", 12346);
        Publisher abc = new Publisher("abc", "srinagar street", "dfc", "hyd");


        ram.getBooks().add(spring);
        spring.getAuthors().add(ram);
        sangam.getBooks().add(spring);

        authorRepository.save(ram);
        bookRepository.save(spring);
        publisherRepository.save(abc);


        System.out.println("Bootstrap app is loading");
        System.out.println("No of books"+ bookRepository.count() );
        System.out.println("No of publishers: " + publisherRepository.count());
        System.out.println("No of publishers: " + sangam.getBooks().size());
    }
}
