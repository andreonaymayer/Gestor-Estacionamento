package Entities;
import Entities.Registro;

@SuppressWarnings("unused")
public class Patio {
	private int vagas;
	private int vagasDisponiveis;
	private double valorHora;
	private double valorDiaria;
	
	
	public Patio(int vagas, double valorHora, double valorDiaria) {
		this.vagas = vagas;
		this.valorHora = valorHora;
		this.valorDiaria = valorDiaria;
		this.vagasDisponiveis = vagas;
	}

	public int getVagasOcupadas() {
		return vagas-vagasDisponiveis;
	}
	
	public void entradaVeiculo() {
		vagasDisponiveis=-1;
	}
	
	public void saidaVeiculo() {
		vagasDisponiveis=+1;
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

