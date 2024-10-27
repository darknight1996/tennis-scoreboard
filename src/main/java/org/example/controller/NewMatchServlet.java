package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Player;
import org.example.service.PlayerService;
import org.example.service.impl.PlayerServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {

    private final PlayerService playerService = new PlayerServiceImpl();

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String firstPlayerName = request.getParameter("firstPlayerName");
        final String secondPlayerName = request.getParameter("secondPlayerName");

        Optional<Player> firstPlayerOptional = playerService.getByName(firstPlayerName);
        Optional<Player> secondPlayerOptional = playerService.getByName(secondPlayerName);

        final Player firstPlayer = firstPlayerOptional
                .orElseGet(() -> playerService.add(new Player(firstPlayerName)));
        final Player secondPlayer = secondPlayerOptional
                .orElseGet(() -> playerService.add(new Player(secondPlayerName)));

        System.out.println("first player: " + firstPlayer.getId() + " " + firstPlayer.getName());
        System.out.println("second player: " + secondPlayer.getId() + " " + secondPlayer.getName());
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/new-match.jsp").forward(request, response);
    }
}
