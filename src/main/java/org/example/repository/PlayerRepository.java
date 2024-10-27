package org.example.repository;

import org.example.model.Player;

import java.util.Optional;

public interface PlayerRepository {

    Player add(final Player player);
    Optional<Player> findByName(final String name);

}
