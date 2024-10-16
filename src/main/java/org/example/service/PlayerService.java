package org.example.service;

import org.example.model.Player;

import java.util.Optional;

public interface PlayerService {

    Player add(final Player player);
    Optional<Player> getByName(final String name);

}
