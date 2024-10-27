package org.example.service.impl;

import org.example.model.Player;
import org.example.repository.PlayerRepository;
import org.example.service.PlayerService;

import java.util.Optional;

public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(final PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player add(final Player player) {
        return playerRepository.add(player);
    }

    @Override
    public Optional<Player> getByName(final String name) {
        return playerRepository.findByName(name);
    }

}
