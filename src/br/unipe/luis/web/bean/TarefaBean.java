package br.unipe.luis.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unipe.luis.web.dao.TarefaDao;
import br.unipe.luis.web.model.Tarefa;

@Named
@ViewScoped
public class TarefaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Tarefa tarefa;
	private TarefaDao tarefaDao;
	
	@PostConstruct
	public void init() {
		tarefa = new Tarefa();
		tarefaDao = new TarefaDao();
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public void cadastrarTarefa() {
		tarefaDao.inserir(tarefa);
		tarefa = new Tarefa();
	}

}
