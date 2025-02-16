package com.solicitut.learning_jpa.repositories;

import com.solicitut.learning_jpa.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
