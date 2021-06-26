package Entities;

public class Carro extends Veiculo{
	private String nome;
	private String marca;
	private String cor;
	

	public Carro(String nome, String marca, String cor, String placa) {
		super(placa, idVeiculo);
		this.nome = nome;
		this.marca = "marca";
		this.cor = cor;
		this.ocupandoVei = false;
		
	}
	public String toString() {
		String ocupe = "Não";
		if (ocupandoVei) {
			ocupe = "Sim";
		}
		return "Carro [placa= "+ super.placa + " Ocupando="+ ocupe +", nome=" + nome + ", marca=" + marca + ", cor=" + cor + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}
