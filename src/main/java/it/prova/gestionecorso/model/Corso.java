package it.prova.gestionecorso.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "corso")
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "docente")
	private String docente;
	@Column(name = "numeroiscritti")
	private Integer numeroIscritti;
	@Column(name = "datainizio")
	private Date dataInizio;
	@Column(name = "datafine")
	private Date dataFine;

	// campi per le time info del record
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Corso() {
	}

	public Corso(String nome, String docente, Integer numeroIscritti, Date dataInizio, Date dataFine) {
		this.nome = nome;
		this.docente = docente;
		this.numeroIscritti = numeroIscritti;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public Corso(String nome, String docente) {
		this.nome = nome;
		this.docente = docente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public Integer getNumeroIscritti() {
		return numeroIscritti;
	}

	public void setNumeroIscritti(Integer numeroIscritti) {
		this.numeroIscritti = numeroIscritti;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "Corso [id=" + id + ", nome=" + nome + ", docente=" + docente + ", numeroIscritti=" + numeroIscritti
				+ ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + "]";
	}

}