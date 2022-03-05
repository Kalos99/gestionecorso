package it.prova.gestionecorso.dao;

import java.util.List;

import it.prova.gestionecorso.model.Corso;

public interface CorsoDAO extends IBaseDAO<Corso>{
	public List<Corso> findByExample(Corso input) throws Exception;
}
