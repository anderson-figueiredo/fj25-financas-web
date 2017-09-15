package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Gerente;

@Stateless
public class GerenteDao {

	@Inject
	private EntityManager manager;
	
	public void adiciona(Gerente gerente) {
		this.manager.joinTransaction();
		this.manager.persist(gerente);
	}
	
	public List<Gerente> lista() {
		this.manager.joinTransaction();
		return this.manager.createQuery("select g from Gerente g", Gerente.class).getResultList();
	}
	
	public Gerente busca(Integer id) {
		this.manager.joinTransaction();
		return  this.manager.find(Gerente.class, id);
	}
	
	public void remove(Gerente gerente) {
		this.manager.joinTransaction();
		Gerente gerenteParaRemover = this.manager.find(Gerente.class, gerente.getId());
		this.manager.remove(gerenteParaRemover);
	}
}
