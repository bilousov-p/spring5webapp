package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
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
    public void run(String... args) {

        Author ericAuthor = new Author("Eric", "Evans");
        Book dddBook = new Book("Domain Driven Design", "123123");

        ericAuthor.getBooks().add(dddBook);
        dddBook.getAuthors().add(ericAuthor);

        authorRepository.save(ericAuthor);
        bookRepository.save(dddBook);

        Author rodAuthor = new Author("Rod", "Johnson");
        Book noEJBBook = new Book("J2EE Development without EJB", "232323");

        rodAuthor.getBooks().add(noEJBBook);
        noEJBBook.getAuthors().add(rodAuthor);

        authorRepository.save(rodAuthor);
        bookRepository.save(noEJBBook);

        Publisher newPublisher = new Publisher(
                "New publisher",
                "Ave",
                "New York",
                "Washington",
                "001");

        publisherRepository.save(newPublisher);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
