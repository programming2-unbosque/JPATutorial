package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.LibraryService;
import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listLibrariesServlet", value = "/list-libraries")
public class ListLibrariesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        LibraryService libraryService = new LibraryService();
        List<LibraryPOJO> libraries = libraryService.listLibraries();

        String librariesJsonString = new Gson().toJson(libraries);

        PrintWriter out = response.getWriter();
        out.print(librariesJsonString);
        out.flush();

    }

}
