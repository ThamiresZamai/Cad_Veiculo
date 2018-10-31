package br.com.cast.aluguel.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.aluguel.DAO.FabricanteDAO;
import br.com.cast.aluguel.DAO.ModeloDAO;
import br.com.cast.aluguel.DAO.VeiculoDAO;
import br.com.cast.aluguel.DTO.FabricanteDTO;
import br.com.cast.aluguel.DTO.ModeloDTO;
import br.com.cast.aluguel.DTO.VeiculoFormDTO;
import br.com.cast.aluguel.DTO.VeiculoListDTO;
import br.com.cast.aluguel.entity.Fabricante;
import br.com.cast.aluguel.entity.Modelo;
import br.com.cast.aluguel.entity.Veiculo;
import br.com.cast.aluguel.exception.VeiculoExistenteException;

@Service
public class VeiculoBusiness {

	@Autowired
	private VeiculoDAO veiculodao;
	@Autowired
	private ModeloDAO modelodao;
	@Autowired
	private FabricanteDAO fabricantedao;

	@Transactional
	public void salvar(VeiculoFormDTO veiculoformdto) {
		Modelo modelo = modelodao.buscarPorID(veiculoformdto.getModelodto().getId());
		Fabricante fabricante = fabricantedao.buscarPorID(veiculoformdto.getModelodto().getFabricantedto().getId());
		veiculoDuplo(veiculoformdto.getPlaca());
		Veiculo veic = new Veiculo();
		veic.setAno(veiculoformdto.getAno());
		veic.setId(veiculoformdto.getId());
		veic.setPlaca(veiculoformdto.getPlaca());
		modelo.setFabricante(fabricante);
		veic.setModelo(modelo);

		veiculodao.inserir(veic);

	}

	public void veiculoDuplo(String placa) {
		Veiculo veiculo = veiculodao.buscarPorPlaca(placa);
		if (veiculo != null) {
			throw new VeiculoExistenteException();
		}
	}

	public VeiculoListDTO buscarPorId(Integer id) {
		Veiculo veiculo = veiculodao.buscarPorId(id);

		VeiculoListDTO veiculolistdto = new VeiculoListDTO();
		veiculolistdto.setAno(veiculo.getAno());
		veiculolistdto.setId(veiculo.getId());
		veiculolistdto.setPlaca(veiculo.getPlaca());

		Modelo modelo = veiculo.getModelo();
		if (modelo != null) {
			ModeloDTO modelodto = new ModeloDTO();
			modelodto.setId(modelo.getId());
			modelodto.setNome(modelo.getNome());

			Fabricante fabricante = modelo.getFabricante();
			if (fabricante != null) {
				FabricanteDTO fabricantedto = new FabricanteDTO();
				fabricantedto.setId(fabricante.getId());
				fabricantedto.setNome(fabricante.getNome());
				modelodto.setFabricantedto(fabricantedto);
			}
			veiculolistdto.setModelodto(modelodto);

		}

		return veiculolistdto;
	}

	public VeiculoListDTO buscarPorPlaca(String placa) {
		Veiculo veiculo = veiculodao.buscarPorPlaca(placa);

		VeiculoListDTO veiculolistdto = new VeiculoListDTO();
		veiculolistdto.setAno(veiculo.getAno());
		veiculolistdto.setId(veiculo.getId());
		veiculolistdto.setPlaca(veiculo.getPlaca());

		Modelo modelo = veiculo.getModelo();
		if (modelo != null) {
			ModeloDTO modelodto = new ModeloDTO();
			modelodto.setId(modelo.getId());
			modelodto.setNome(modelo.getNome());

			Fabricante fabricante = modelo.getFabricante();
			if (fabricante != null) {
				FabricanteDTO fabricantedto = new FabricanteDTO();
				fabricantedto.setId(fabricante.getId());
				fabricantedto.setNome(fabricante.getNome());
				modelodto.setFabricantedto(fabricantedto);
			}
			veiculolistdto.setModelodto(modelodto);

		}

		return veiculolistdto;
	}

	@Transactional
	public List<VeiculoListDTO> buscarTodos() {
		List<Veiculo> veiculos = veiculodao.buscarTodos();
		List<VeiculoListDTO> lstveiculodto = new ArrayList<>();

		for (Veiculo veiculo : veiculos) {
			VeiculoListDTO veiculolistdto = new VeiculoListDTO();
			veiculolistdto.setAno(veiculo.getAno());
			veiculolistdto.setId(veiculo.getId());
			veiculolistdto.setPlaca(veiculo.getPlaca());

			Modelo modelo = veiculo.getModelo();
			if (modelo != null) {
				ModeloDTO modelodto = new ModeloDTO();
				modelodto.setId(modelo.getId());
				modelodto.setNome(modelo.getNome());

				Fabricante fabricante = modelo.getFabricante();
				if (fabricante != null) {
					FabricanteDTO fabricantedto = new FabricanteDTO();
					fabricantedto.setId(fabricante.getId());
					fabricantedto.setNome(fabricante.getNome());
					modelodto.setFabricantedto(fabricantedto);
				}
				veiculolistdto.setModelodto(modelodto);

			}

			lstveiculodto.add(veiculolistdto);
		}

		return lstveiculodto;
	}

}
