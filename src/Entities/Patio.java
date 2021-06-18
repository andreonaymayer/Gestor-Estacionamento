package Entities;

public class Patio {
	private int idPatio=0;
	private String nome = "Grande";
	private int vagas=0;
	private int vagasDisponiveis=0;
	private double valorHora;
	private double valorDiaria;
	

	public Patio(int vagas, double valorHora, double valorDiaria) {
		this.idPatio = 1;
		this.vagas = vagas;
		this.valorHora = valorHora;
		this.valorDiaria = valorDiaria;
		this.vagasDisponiveis = vagas;
	}

	public void entradaVeiculo() {
		vagasDisponiveis-=1;
	}
	
	public void saidaVeiculo() {
		vagasDisponiveis+=1;
	}
	
	public int getVagasOcupadas() {
		return 5;//vagas-vagasDisponiveis;
	}
	public String toString() {
		return "Patio [nome=" + nome + ", vagas=" + vagas + ", vagasDisponiveis=" + vagasDisponiveis + ", valorHora="
				+ valorHora + ", valorDiaria=" + valorDiaria + "]";
	}

	public int getIdPatio() {
		return idPatio;
	}

	public void setIdPatio(int idPatio) {
		this.idPatio = idPatio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	
}

