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
		System.out.println("L'input e: " + input == null);
		if(input == null) {
			throw new Exception("Problema valore in input");
		}
		String query = "from Corso c where 1=1 ";
		if(input.getNome() != null && !input.getNome().isEmpty()) {
			query += "and c.nome like '" + input.getNome() + "%' ";
		}
		if(input.getDocente() != null && !input.getDocente().isEmpty()) {
			query += "and c.docente like '" + input.getDocente() + "%' ";
		}
		if(input.getNumeroIscritti() != null) {
			query += "and c.numeroIscritti >= '" + input.getNumeroIscritti() + "' ";
		}
		if(input.getDataInizio() != null) {
			query += "and c.dataInizio >= '" +  new java.sql.Date(input.getDataInizio().getTime()) + "' ";
		}
		if(input.getDataFine() != null) {
			query += "and c.dataFine >= '" +  new java.sql.Date(input.getDataFine().getTime()) + "' ";
		}
		return entityManager.createQuery(query, Corso.class).getResultList();
	}

}
