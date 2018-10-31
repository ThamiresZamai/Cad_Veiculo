package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.DTO.FabricanteDTO;
import br.com.cast.aluguel.business.FabricanteBusiness;

@RestController
@RequestMapping(path = "fabricante")
public class FabricanteAPI {

	@Autowired
	public FabricanteBusiness fabricantebusiness;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<FabricanteDTO> buscarTodos() {
		return fabricantebusiness.buscarTodos();
	}
	
}
