package com.solicitut.learning_jpa.bootstrap;

import com.solicitut.learning_jpa.domain.Author;
import com.solicitut.learning_jpa.domain.Book;
import com.solicitut.learning_jpa.domain.Publisher;
import com.solicitut.learning_jpa.repositories.AuthorRepository;
import com.solicitut.learning_jpa.repositories.BookRepository;
import com.solicitut.learning_jpa.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author author = new Author();
    author.setFirstName("John");
    author.setLastName("Smith");

    Author author2 = new Author();
    author2.setFirstName("Jane");
    author2.setLastName("Doe");

    Book book = new Book();
    book.setTitle("The First Book");
    book.setIsbn("978-3-16-148410-0");

    Book book2 = new Book();
    book2.setTitle("The Second Book");
    book2.setIsbn("978-3-16-148410-1");

    Publisher publisher = new Publisher();
    publisher.setName("Gramedia");
    publisher.setAddress("Road Avenue");
    publisher.setEmail("gramedia@gmail.com");
    publisher.setPhone("555-555-5555");
    publisher.setWebsite("www.gramedia.com");

    Author authorSaved = authorRepository.save(author);
    Author authorSaved2 = authorRepository.save(author2);

    Book bookSaved = bookRepository.save(book);
    Book bookSaved2 = bookRepository.save(book2);

    Publisher publisherSaved = publisherRepository.save(publisher);

    bookSaved.setPublishers(publisherSaved);
    bookSaved2.setPublishers(publisherSaved);

    authorSaved.getBooks().add(bookSaved);
    authorSaved2.getBooks().add(bookSaved2);

    authorRepository.save(authorSaved);
    authorRepository.save(authorSaved2);

    bookRepository.save(bookSaved);
    bookRepository.save(bookSaved2);

    System.out.println("In Bootstrap");
    System.out.println("Author Count: " + authorRepository.count());
    System.out.println("Book Count: " + bookRepository.count());
    System.out.println("Publisher Count: " + publisherRepository.count());
  }
}
