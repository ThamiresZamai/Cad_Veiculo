package br.com.cast.aluguel.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.DTO.FabricanteDTO;
import br.com.cast.aluguel.entity.Fabricante;

@Repository
public class FabricanteDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Fabricante buscarPorID(Integer id) {
		return em.find(Fabricante.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<FabricanteDTO> buscarTodos() {
		List<FabricanteDTO> lstautor = em.createQuery("Select f from " + Fabricante.class.getName() + " f ").getResultList();
		return lstautor;
	}
}
