package Entities;

public abstract class Veiculo {
	protected String placa;
	protected String nome;
	
	
	public String toString() {
		return "Veiculo [placa=" + placa + ", nome=" + nome + "]";
	}

	public Veiculo(String placa, String nome) {
		this.placa = placa;
		this.nome = nome;
	}
	
	public void Padrao() {
		this.placa = "PQP-1234";
		this.nome = "Fusca verde";
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
