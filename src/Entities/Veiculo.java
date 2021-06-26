package Entities;

public abstract class Veiculo {
	protected String placa;
	protected Boolean indAtivo;
	protected Boolean ocupandoVei;
	protected static  int idVeiculo;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		Veiculo.idVeiculo = idVeiculo;
	}
	public Veiculo(String placa, int idVeiculo) {
		this.placa = placa;
		Veiculo.idVeiculo = idVeiculo;
	}
	public Boolean getIndAtivo() {
		return indAtivo;
	}
	public void setIndAtivo(Boolean indAtivo) {
		this.indAtivo = indAtivo;
	}
	public Boolean getOcupandoVei() {
		return ocupandoVei;
	}
	public void setOcupandoVei(Boolean ocupandoVei) {
		this.ocupandoVei = ocupandoVei;
	}


	
}
