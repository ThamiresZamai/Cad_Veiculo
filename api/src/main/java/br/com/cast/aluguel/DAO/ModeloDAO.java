package br.com.cast.aluguel.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.DTO.ModeloDTO;
import br.com.cast.aluguel.entity.Modelo;



@Repository
public class ModeloDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Modelo buscarPorID(Integer id) {
		return em.find(Modelo.class, id);
	}
	
	public List<ModeloDTO> buscarPorFabricante(Integer id) {
		List<ModeloDTO> lstfabricante = em.createQuery("Select m from " + Modelo.class.getName() + " m where fabricante=" + id).getResultList();
		return lstfabricante;
	}
	
	@SuppressWarnings("unchecked")
	public List<ModeloDTO> buscarTodos() {
		List<ModeloDTO> lstmodelo = em.createQuery("Select m from " + Modelo.class.getName() + " m ").getResultList();
		return lstmodelo;
	}

}
