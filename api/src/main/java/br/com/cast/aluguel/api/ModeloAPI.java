package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.DAO.ModeloDAO;
import br.com.cast.aluguel.DTO.ModeloDTO;
import br.com.cast.aluguel.business.ModeloBusiness;

@RestController
@RequestMapping(path = "modelo")
public class ModeloAPI {

	@Autowired
	private ModeloBusiness modelobusiness;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ModeloDTO> buscarTodos(){
		return modelobusiness.buscarTodos();
	}
	
	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public List<ModeloDTO> buscarPorId(@PathVariable("id") Integer id) {
		return modelobusiness.buscarPorFabricante(id);
	}
	
}
