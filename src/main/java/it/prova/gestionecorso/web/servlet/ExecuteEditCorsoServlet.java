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
import it.prova.gestionecorso.utility.UtilityCorsoForm;

@WebServlet("/ExecuteEditCorsoServlet")
public class ExecuteEditCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteEditCorsoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// estraggo input
		String nomeInputParam = request.getParameter("nome");
		String docenteInputParam = request.getParameter("docente");
		String numeroIscrittiStringParam = request.getParameter("numeroIscritti");
		String dataInizioInputStringParam = request.getParameter("dataInizio");
		String dataFineStringParam = request.getParameter("dataFine");
		String idStringParam = request.getParameter("idCorso");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Corso corsoInstance = UtilityCorsoForm.createCorsoFromParams(nomeInputParam, docenteInputParam, numeroIscrittiStringParam, dataInizioInputStringParam, dataFineStringParam);

		// se la validazione non risulta ok
		if (!UtilityCorsoForm.validateCorsoBean(corsoInstance) || !NumberUtils.isCreatable(idStringParam)) {
			request.setAttribute("CorsoCheSiVuoleAggiornare", corsoInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/corso/edit.jsp").forward(request, response);
			return;
		}

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			corsoInstance.setId(Long.parseLong(idStringParam));
			MyServiceFactory.getCorsoServiceInstance().aggiorna(corsoInstance);
			request.setAttribute("listaCorsiAttribute", MyServiceFactory.getCorsoServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/corso/results.jsp").forward(request, response);

	}



}
