package it.prova.gestionecorso.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecorso.model.Corso;

@WebServlet("/PrepareInsertCorsoServlet")
public class PrepareInsertCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareInsertCorsoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//metto un bean 'vuoto' in request perché per la pagina risulta necessario
		request.setAttribute("insert_corso_attr", new Corso());
		request.getRequestDispatcher("/corso/insert.jsp").forward(request, response);

	}


}
