package com.solicitut.learning_jpa.repositories;

import com.solicitut.learning_jpa.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
