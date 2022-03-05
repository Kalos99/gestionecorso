package it.prova.gestionecorso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionecorso.model.Corso;

public class CorsoDAOImpl implements CorsoDAO{
	
	private EntityManager entityManager;

	@Override
	public List<Corso> list() throws Exception {
		return entityManager.createQuery("from Corso", Corso.class).getResultList();
	}

	@Override
	public Corso findOne(Long id) throws Exception {
		return entityManager.find(Corso.class, id);
	}

	@Override
	public void update(Corso input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);	
	}

	@Override
	public void insert(Corso input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);	
	}

	@Override
	public void delete(Corso input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));	
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Corso> findByExample(Corso input) throws Exception {
		TypedQuery<Corso> query = entityManager
				.createQuery("FROM Corso where nome like :nomeCorso and docente like :docenteCorso and datainizio >= :dataInizioCorso and datafine >= :dataFineCorso and numeroiscritti >= :numeroIscrittiCorso", Corso.class);
		query.setParameter("nomeCorso", input.getNome());
		query.setParameter("docenteCorso", input.getDocente());
		query.setParameter("dataInizioCorso", input.getDataInizio());
		query.setParameter("dataFineCorso", input.getDataFine());
		query.setParameter("numeroIscrittiCorso", input.getNumeroIscritti());
		return query.getResultList();
	}

}
