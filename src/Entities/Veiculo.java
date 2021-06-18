package Entities;

public abstract class Veiculo {
	protected String placa;
	protected static int idVeiculo;
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


	
}
