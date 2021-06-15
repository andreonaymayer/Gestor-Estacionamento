package Entities;

public abstract class Veiculo {
	protected static String placa;
	
	public Veiculo (String placa) {
		Veiculo.placa = placa;
	}
}
