package it.prova.gestionecorso.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecorso.model.Corso;
import it.prova.gestionecorso.service.MyServiceFactory;
import it.prova.gestionecorso.utility.UtilityCorsoForm;

/**
 * Servlet implementation class ExecuteSearchCorsoServlet
 */
@WebServlet("/ExecuteSearchCorsoServlet")
public class ExecuteSearchCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteSearchCorsoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeInputParam = request.getParameter("nome");
		String docenteInputParam = request.getParameter("docente");
		String numeroIscrittiStringParam = request.getParameter("numeroIscritti");
		String dataInizioInputStringParam = request.getParameter("dataInizio");
		String dataFineStringParam = request.getParameter("dataFine");
		System.out.println(nomeInputParam + " - " + docenteInputParam + " - " + numeroIscrittiStringParam + " - "
				+ dataInizioInputStringParam + " - " + dataFineStringParam);

		Corso modelloPerRicerca = UtilityCorsoForm.createCorsoFromParams(nomeInputParam, docenteInputParam,
				numeroIscrittiStringParam, dataInizioInputStringParam, dataFineStringParam);
		System.out.println(modelloPerRicerca);

		try {

			for (Corso c : MyServiceFactory.getCorsoServiceInstance().findByExample(modelloPerRicerca)) {
				System.out.println(c);
			}

			request.setAttribute("listaCorsiAttribute",
					MyServiceFactory.getCorsoServiceInstance().findByExample(modelloPerRicerca));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/corso/results.jsp").forward(request, response);
	}
}
