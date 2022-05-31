package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.UserApp;
import edu.unbosque.JPATutorial.jpa.entities.WalletHistory;
import edu.unbosque.JPATutorial.jpa.repositories.UserAppRepository;
import edu.unbosque.JPATutorial.jpa.repositories.UserAppRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.WalletHistoryRepository;
import edu.unbosque.JPATutorial.jpa.repositories.WalletHistoryRepositoryImpl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.Optional;

@Stateless
public class WalletHistoryService {

    UserAppRepository userAppRepository;
    WalletHistoryRepository walletHistoryRepository;

    public Optional<WalletHistory> save(String email, String type, Double fcoins) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        walletHistoryRepository = new WalletHistoryRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);

        System.out.println(email);

        Optional<UserApp> userApp = userAppRepository.findByEmail(email);

        System.out.println(userApp.get().getName());

        if (userApp.isPresent()) {

            WalletHistory walletHistory = new WalletHistory(type, fcoins, new Date(), userApp.get());
            Optional<WalletHistory> persistedWalletHistory = walletHistoryRepository.save(walletHistory);

            entityManager.close();
            entityManagerFactory.close();

            return persistedWalletHistory;

        } else {
            throw new Exception("User not found");
        }

    }

}
