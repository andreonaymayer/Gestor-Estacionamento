package Entities;

public class Moto extends Veiculo{

	public String nome;
	public String marca;
	public String cor;
	
	public Moto(String placa, int idVeiculo) {
		super(placa, idVeiculo);
		this.nome = "CG 150";
		this.marca = "Honda";
		this.cor = "Vermelha";
	}
	

}
