package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/demo-jstl")
public class DemoJstlServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> prenoms = new ArrayList<>();
		
		prenoms.add("Zoro");
		prenoms.add("Albert");
		prenoms.add("Marion");
		
		// On donne la liste de prénoms au scope Request
		req.setAttribute("prenoms", prenoms);
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/demo-jstl.jsp")
			.forward(req, resp);
	}
}
