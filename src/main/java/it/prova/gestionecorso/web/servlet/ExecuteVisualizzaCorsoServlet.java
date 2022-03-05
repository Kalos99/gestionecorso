package it.prova.gestionecorso.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecorso.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaCorsoServlet")
public class ExecuteVisualizzaCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteVisualizzaCorsoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idCorsoParam = request.getParameter("idCorso");

		if (!NumberUtils.isCreatable(idCorsoParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_corso_attr", MyServiceFactory.getCorsoServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idCorsoParam)));
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/corso/show.jsp").forward(request, response);
	}

}
