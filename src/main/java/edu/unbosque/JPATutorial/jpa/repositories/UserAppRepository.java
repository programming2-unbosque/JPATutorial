package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.UserApp;

import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> findByEmail(String email);

    Optional<UserApp> save(UserApp userApp);

}
