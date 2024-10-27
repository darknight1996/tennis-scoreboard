package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.model.Player;
import org.example.repository.PlayerRepository;
import org.example.repository.util.HibernateUtil;

import java.util.Optional;

public class HibernatePlayerRepository implements PlayerRepository {

    private final EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    @Override
    public Player add(final Player player) {
        try (final EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            entityManager.persist(player);

            entityManager.getTransaction().commit();
        }

        return player;
    }

    @Override
    public Optional<Player> findByName(final String name) {
        final Optional<Player> playerOptional;

        try (final EntityManager entityManager = entityManagerFactory.createEntityManager()) {
           entityManager.getTransaction().begin();

            playerOptional = entityManager.createQuery(
                    "select p from Player p where p.name = :name", Player.class)
                    .setParameter("name", name)
                    .getResultList().stream()
                    .findFirst();

           entityManager.getTransaction().commit();
        }

        return playerOptional;
    }

}
