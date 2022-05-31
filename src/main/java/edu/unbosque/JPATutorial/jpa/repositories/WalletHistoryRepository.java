package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.WalletHistory;

import java.util.Optional;

public interface WalletHistoryRepository {

    Optional<WalletHistory> save(WalletHistory walletHistory);

}
