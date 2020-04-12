package br.unipe.luis.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Aula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeProfessor;
	private String nomeDisciplina;
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@OneToMany(mappedBy = "aula", cascade = CascadeType.MERGE)
	private List<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	public Aula() {
		super();
	}

	public Aula(Integer id, String nomeProfessor, String nomeDisciplina, Date data) {
		super();
		this.id = id;
		this.nomeProfessor = nomeProfessor;
		this.nomeDisciplina = nomeDisciplina;
		this.data = data;
	}
	
	public void addTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
		tarefa.setAula(this);
	}


	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
