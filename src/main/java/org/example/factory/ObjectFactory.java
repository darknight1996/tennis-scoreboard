package org.example.factory;

import org.example.repository.PlayerRepository;
import org.example.repository.impl.HibernatePlayerRepository;
import org.example.service.PlayerService;
import org.example.service.impl.PlayerServiceImpl;

public class ObjectFactory {

    private static final PlayerRepository playerRepository = new HibernatePlayerRepository();
    private static final PlayerService playerService = new PlayerServiceImpl(playerRepository);

    public static PlayerService getPlayerService() {
        return playerService;
    }
}
