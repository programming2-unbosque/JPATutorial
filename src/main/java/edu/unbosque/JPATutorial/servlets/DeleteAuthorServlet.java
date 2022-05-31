package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.AuthorService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteAuthorServlet", value = "/delete-author")
public class DeleteAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer authorId = Integer.parseInt(request.getParameter("authorId"));

        AuthorService authorService = new AuthorService();
        authorService.deleteAuthor(authorId);

        response.sendRedirect("./index.jsp");
    }

}
