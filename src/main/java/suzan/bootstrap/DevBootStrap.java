package suzan.bootstrap;

import suzan.model.Author;
import suzan.model.Book;
import suzan.model.Publisher;
import suzan.repositories.AuthorRepository;
import suzan.repositories.BookRepository;
import suzan.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Tribal Publications");
        publisher.setAddress("US");
        publisherRepository.save(publisher);

        //Cameroon
        Author james = new Author("James", "Cameroon");
        Book happiness = new Book("What is Happiness?", "23987", publisher);
        //Book happiness = new Book("What is Happiness?", "23987", "Sun Leaf");
        james.getBooks().add(happiness);
        happiness.getAuthors().add(james);
        authorRepository.save(james);
        bookRepository.save(happiness);

        //Erica
        Author erica = new Author("Erica", "Parles");
        Book crisis = new Book("Crisis Management", "41898", publisher);
        erica.getBooks().add(crisis);
        //crisis.getAuthors().add(erica);
        authorRepository.save(erica);
        bookRepository.save(crisis);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}