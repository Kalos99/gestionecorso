package it.prova.gestionecorso.service;

import java.util.List;

import it.prova.gestionecorso.dao.CorsoDAO;
import it.prova.gestionecorso.model.Corso;

public interface CorsoService {
	
	// questo mi serve per injection
	public void setCorsoDao(CorsoDAO corsoDao);

	public List<Corso> listAll() throws Exception;

	public Corso caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Corso input) throws Exception;

	public void inserisciNuovo(Corso input) throws Exception;

	public void rimuovi(Corso input) throws Exception;

	public List<Corso> findByExample(Corso input) throws Exception;


}
