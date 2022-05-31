package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listAuthorsServlet", value = "/list-authors")
public class ListAuthorsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        AuthorService authorService = new AuthorService();
        List<AuthorPOJO> authors = authorService.listAuthors();

        String authorsJsonString = new Gson().toJson(authors);

        PrintWriter out = response.getWriter();
        out.print(authorsJsonString);
        out.flush();

    }

}
