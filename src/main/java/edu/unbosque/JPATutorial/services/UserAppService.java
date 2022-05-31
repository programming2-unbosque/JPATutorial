package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.UserApp;
import edu.unbosque.JPATutorial.jpa.repositories.UserAppRepository;
import edu.unbosque.JPATutorial.jpa.repositories.UserAppRepositoryImpl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

@Stateless
public class UserAppService {

    UserAppRepository userAppRepository;

    public Optional<UserApp> save(String email, String password, String name, String role) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppRepositoryImpl(entityManager);

        UserApp userApp = new UserApp(email, password, name, role);
        Optional<UserApp> persistedUser = userAppRepository.save(userApp);

        entityManager.close();
        entityManagerFactory.close();

        return persistedUser;

    }

}
