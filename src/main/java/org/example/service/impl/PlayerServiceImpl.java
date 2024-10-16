package org.example.service.impl;

import org.example.model.Player;
import org.example.service.PlayerService;

import java.util.Optional;

public class PlayerServiceImpl implements PlayerService {

    @Override
    public Player add(final Player player) {
        return null;
    }

    @Override
    public Optional<Player> getByName(final String name) {
        return Optional.of(new Player(name));
    }

}
