package fr.formation.servlet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.formation.repo.IProduitRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/produits")
public class ProduitsServlet extends HttpServlet {
	@Autowired
	private IProduitRepository repoProduit;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Cet utilitaire permet d'injecter les dépendances @Autowired depuis le contexte de SPRING enregistré dans la configuration web.xml
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("produits", this.repoProduit.findAll());
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/produits.jsp")
			.forward(req, resp);
	}
}
