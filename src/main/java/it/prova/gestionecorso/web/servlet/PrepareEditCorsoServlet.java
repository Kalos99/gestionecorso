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

@WebServlet("/PrepareEditCorsoServlet")
public class PrepareEditCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrepareEditCorsoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdDelCorsoDaAggiornare = request.getParameter("idCorso");
		
		if(!NumberUtils.isCreatable(parametroIdDelCorsoDaAggiornare)) {
			request.setAttribute("errorMessage", "Attenzione, non è stato trovato il corso corrispondente.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try{
			Corso corsoPerAggiornamento = MyServiceFactory.getCorsoServiceInstance().caricaSingoloElemento(Long.parseLong(parametroIdDelCorsoDaAggiornare));
			request.setAttribute("CorsoCheSiVuoleAggiornare", corsoPerAggiornamento);
		} catch (Exception e){
			//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/corso/edit.jsp").forward(request, response);
	
	}

}
