package it.prova.gestionecorso.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecorso.model.Corso;
import it.prova.gestionecorso.service.MyServiceFactory;

@WebServlet("/PrepareDeleteCorsoServlet")
public class PrepareDeleteCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrepareDeleteCorsoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdDelCorsoDaEliminare = request.getParameter("idCorso");
		
		if(!NumberUtils.isCreatable(parametroIdDelCorsoDaEliminare)) {
			request.setAttribute("errorMessage", "Attenzione, non è stato trovato il corso corrispondente.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try{
			Corso corsoPerEliminazione = MyServiceFactory.getCorsoServiceInstance().caricaSingoloElemento(Long.parseLong(parametroIdDelCorsoDaEliminare));
			request.setAttribute("CorsoCheSiVuoleEliminare", corsoPerEliminazione);
		} catch (Exception e){
			//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/corso/delete.jsp").forward(request, response);
	
	}
}
