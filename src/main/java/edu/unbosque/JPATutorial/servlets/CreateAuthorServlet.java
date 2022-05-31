package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.AuthorService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateAuthorServlet", value = "/create-author")
public class CreateAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");

        AuthorService authorService = new AuthorService();
        authorService.saveAuthor(name);

        response.sendRedirect("./index.jsp");
    }

}
