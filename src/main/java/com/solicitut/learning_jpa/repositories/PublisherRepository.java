package com.solicitut.learning_jpa.repositories;

import com.solicitut.learning_jpa.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
