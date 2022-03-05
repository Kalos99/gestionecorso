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

@WebServlet("/ExecuteDeleteCorsoServlet")
public class ExecuteDeleteCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteDeleteCorsoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idCorsoDaRimuovere = request.getParameter("idCorso");
		
		if(!NumberUtils.isCreatable(idCorsoDaRimuovere)) {
			request.setAttribute("errorMessage", "Attenzione, non è stato trovato il corso corrispondente.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		try{
			Corso corsoDaRimuovere = MyServiceFactory.getCorsoServiceInstance().caricaSingoloElemento(Long.parseLong(idCorsoDaRimuovere));
			MyServiceFactory.getCorsoServiceInstance().rimuovi(corsoDaRimuovere);
			request.setAttribute("listaCorsiAttribute", MyServiceFactory.getCorsoServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione, si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/corso/results.jsp").forward(request, response);
	}
}