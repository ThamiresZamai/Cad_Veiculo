package br.com.cast.aluguel.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.aluguel.DAO.ModeloDAO;
import br.com.cast.aluguel.DTO.FabricanteDTO;
import br.com.cast.aluguel.DTO.ModeloDTO;
import br.com.cast.aluguel.entity.Fabricante;
import br.com.cast.aluguel.entity.Modelo;

@Service
public class ModeloBusiness {

	@Autowired
	private ModeloDAO modelodao;

	public List<ModeloDTO> buscarPorFabricante(Integer id) {
		List<ModeloDTO> lstmodelo = modelodao.buscarPorFabricante(id);
		return lstmodelo;

	}

	@Transactional
	public List<ModeloDTO> buscarTodos() {
		List<ModeloDTO> lstmodelodto = modelodao.buscarTodos();
		return lstmodelodto;
	}
}
