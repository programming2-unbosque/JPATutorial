package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    Optional<Author> findById(Integer id);

    List<Author> findAll();

    Optional<Author> save(Author author);

    void deleteById(Integer id);

}
