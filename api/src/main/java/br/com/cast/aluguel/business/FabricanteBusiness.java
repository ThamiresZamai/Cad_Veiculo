package br.com.cast.aluguel.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.aluguel.DAO.FabricanteDAO;
import br.com.cast.aluguel.DTO.FabricanteDTO;
import br.com.cast.aluguel.entity.Fabricante;

@Service
public class FabricanteBusiness {

	@Autowired
	private FabricanteDAO fabricantedao;
	
	public Fabricante buscarPorId(Integer id) {
		return fabricantedao.buscarPorID(id);
	}
	
	@Transactional
	public List<FabricanteDTO> buscarTodos(){
		List<FabricanteDTO> lstfabricantedto = fabricantedao.buscarTodos();
		return lstfabricantedto;
	}
}
