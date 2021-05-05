package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepository;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AuthorService {

    AuthorRepository authorRepository;

    public List<AuthorPOJO> listAuthors() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        List<Author> authors = authorRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<AuthorPOJO> authorsPOJO = new ArrayList<>();
        for (Author author : authors) {
            authorsPOJO.add(new AuthorPOJO(
                    author.getAuthorId(),
                    author.getName(),
                    author.getBooks().size()
            ));
        }

        return authorsPOJO;

    }

    public Author saveAuthor(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);

        Author author = new Author(name);
        Author persistedAuthor = authorRepository.save(author).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedAuthor;

    }

    public void deleteAuthor(Integer authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        authorRepository.deleteById(authorId);

        entityManager.close();
        entityManagerFactory.close();

    }

}
