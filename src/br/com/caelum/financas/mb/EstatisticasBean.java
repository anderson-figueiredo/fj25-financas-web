package br.com.caelum.financas.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Session;
import javax.management.j2ee.statistics.Statistic;
import javax.persistence.EntityManager;

@Named
@ApplicationScoped
public class EstatisticasBean {

	@Inject
	private EntityManager Manager;

	private Statistic estatisticas;

	public void gera() {
		System.out.println("Gerando estatísticas");
		Session session = this.Manager.unwrap(Session.class);
		this.estatisticas = session.getSessionFactory().getStatistics();
	}

	public Statistic getEstatisticas() {
		return estatisticas;
	}

	public void setEstatisticas(Statistic estatisticas) {
		this.estatisticas = estatisticas;
	}
}
