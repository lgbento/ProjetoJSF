package br.unipe.luis.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

import br.unipe.luis.web.dao.AulaDao;
import br.unipe.luis.web.dao.TarefaDao;
import br.unipe.luis.web.model.Aula;
import br.unipe.luis.web.model.Tarefa;


@Named
@RequestScoped
public class AulaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aula aula;
	private AulaDao aulaDao;
	
	private int tarefaIdSelecionada;
	
	private List<Tarefa> tarefas;
	private TarefaDao tarefaDao;
	
	@PostConstruct
	public void init() {
		aula = new Aula();
		aulaDao = new AulaDao();
		tarefaDao = new TarefaDao();
		tarefas = tarefaDao.buscarTodos();
	}
	
	public Aula getAula() {
		return aula;
	}
	
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public int getTarefaIdSelecionada() {
		return tarefaIdSelecionada;
	}
	
	public void setTarefaIdSelecionada(int tarefaIdSelecionada) {
		this.tarefaIdSelecionada = tarefaIdSelecionada;
	}
	
	public void mapearAulaTarefa() {
		System.out.println("Mapeando");
		if(tarefaIdSelecionada != 0) {
			Tarefa tarefa = tarefaDao.buscarPorId(tarefaIdSelecionada);
			aula.addTarefa(tarefa);
		}
	}
	
	public void cadastrarAula() {
		aulaDao.inserir(aula);
		aula = new Aula();
	}

}
