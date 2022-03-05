package it.prova.gestionecorso.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecorso.model.Corso;

@WebServlet("/PrepareSearchCorsoServlet")
public class PrepareSearchCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareSearchCorsoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//metto un bean 'vuoto' in request perché per la pagina risulta necessario
		request.setAttribute("search_corso_attr", new Corso());
		request.getRequestDispatcher("/corso/search.jsp").forward(request, response);

	}

}
