package br.com.cast.aluguel.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.entity.Veiculo;

@Repository
public class VeiculoDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void inserir(Veiculo veiculo) {
			em.persist(veiculo);
	}
	
	public Veiculo buscarPorId(Integer id) {
		return em.find(Veiculo.class, id);
	}
	
	public Veiculo buscarPorPlaca(String placa) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select v ")
			.append("from ").append(Veiculo.class.getName()).append(" v ")
			.append("inner join v.modelo m ")
			.append("inner join m.fabricante")
			.append(" where v.placa = :placa ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("placa", placa);
		try {
			return (Veiculo) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> buscarTodos() {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("select v ")
			.append("from ").append(Veiculo.class.getName()).append(" v ")
			.append("inner join fetch v.modelo m ")
			.append("inner join fetch m.fabricante");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		
	}
}
