package br.com.cast.aluguel.DTO;


public class VeiculoListDTO {

	private Integer id;
	private String placa;
	private Integer ano;
	private ModeloDTO modelodto;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public ModeloDTO getModelodto() {
		return modelodto;
	}
	public void setModelodto(ModeloDTO modelodto) {
		this.modelodto = modelodto;
	}
	
	
	
}
