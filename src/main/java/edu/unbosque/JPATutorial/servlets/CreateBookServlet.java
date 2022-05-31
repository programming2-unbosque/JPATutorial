package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateBookServlet", value = "/create-book")
public class CreateBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        Integer authorId = Integer.parseInt(request.getParameter("authorId"));

        BookService bookService = new BookService();
        bookService.saveBook(title, isbn, authorId);

        response.sendRedirect("./index.jsp");

    }

}
