package it.prova.gestionecorso.service;

import it.prova.gestionecorso.dao.CorsoDAO;
import it.prova.gestionecorso.dao.CorsoDAOImpl;

public class MyServiceFactory {
	
	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static CorsoService CORSO_SERVICE_INSTANCE = null;
	private static CorsoDAO CORSODAO_INSTANCE = null;

	public static CorsoService getCorsoServiceInstance() {
		if (CORSO_SERVICE_INSTANCE == null)
			CORSO_SERVICE_INSTANCE = new CorsoServiceImpl();

		if (CORSODAO_INSTANCE == null)
			CORSODAO_INSTANCE = new CorsoDAOImpl();

		CORSO_SERVICE_INSTANCE.setCorsoDao(CORSODAO_INSTANCE);

		return CORSO_SERVICE_INSTANCE;
	}

}
