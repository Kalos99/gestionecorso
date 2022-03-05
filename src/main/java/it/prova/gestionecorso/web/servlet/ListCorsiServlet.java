package it.prova.gestionecorso.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecorso.service.MyServiceFactory;

@WebServlet("/ListCorsiServlet")
public class ListCorsiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCorsiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// preparo la lista di articoli
		try {
			request.setAttribute("listaCorsiAttribute", MyServiceFactory.getCorsoServiceInstance().listAll());
		} catch (Exception e) {
			//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/corso/results.jsp").forward(request, response);
	}

}
