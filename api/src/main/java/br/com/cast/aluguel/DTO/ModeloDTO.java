package br.com.cast.aluguel.DTO;

public class ModeloDTO {

	private Integer id;
	private String nome;
	private FabricanteDTO fabricantedto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public FabricanteDTO getFabricantedto() {
		return fabricantedto;
	}
	public void setFabricantedto(FabricanteDTO fabricantedto) {
		this.fabricantedto = fabricantedto;
	}
	
	
	
}
