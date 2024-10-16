package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.PlayerService;
import org.example.service.impl.PlayerServiceImpl;

import java.io.IOException;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {

    private final PlayerService playerService = new PlayerServiceImpl();

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String firstPlayerName = request.getParameter("firstPlayerName");
        final String secondPlayerName = request.getParameter("secondPlayerName");

        if (playerService.getByName(firstPlayerName).isPresent() || playerService.getByName(secondPlayerName).isPresent()) {
            request.setAttribute("errorMessage", "Player already exists");

            final RequestDispatcher requestDispatcher = request.getRequestDispatcher("/new-match.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/new-match.jsp").forward(request, response);
    }
}
