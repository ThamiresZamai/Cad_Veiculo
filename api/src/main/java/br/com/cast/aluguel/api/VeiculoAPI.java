package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.DTO.VeiculoFormDTO;
import br.com.cast.aluguel.DTO.VeiculoListDTO;
import br.com.cast.aluguel.business.VeiculoBusiness;

@RestController
@RequestMapping(path = "veiculo")
public class VeiculoAPI {

	@Autowired
	public VeiculoBusiness veiculobusiness;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<VeiculoListDTO> buscarTodos(){
		return veiculobusiness.buscarTodos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void inserir(@RequestBody VeiculoFormDTO veiculoformtdto) {
		veiculobusiness.salvar(veiculoformtdto);
	}
	
	@RequestMapping(path = "/{placa}", method = RequestMethod.GET)
	public void veiculoDuplo(@PathVariable("placa") String placa) {
		veiculobusiness.veiculoDuplo(placa);
	}
	
}
