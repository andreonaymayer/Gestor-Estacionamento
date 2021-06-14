package Entities;

import java.util.Date;

public class Registro {
	private Date  entrada;
	private Date  saida;
	private Veiculo veiculo;
	private Boolean ocupando;
	private Double valorTotal;
	
	
	public Registro(Date entrada, Date saida, Veiculo veiculo, Boolean ocupando, Double valorTotal) {
		this.entrada = entrada;
		this.saida = saida;
		this.veiculo = veiculo;
		this.ocupando = ocupando;
		this.valorTotal = valorTotal;
	}
	
	public String Diferenca (Date menorData, Date maiorData) {
		Long x = maiorData.getTime() - menorData.getTime();
		int horas = (int) (x/1000/60/60);
		int dias = (int) horas/24;
		int minutos = (int) ((x/1000)/60) - (horas*60);
		int segundos = (int) (x/1000)- minutos*60 - horas*3600;
		horas = (int) (x/1000/60/60)-dias*24;
		String Retorno = String.format("Dia: %d\nHoras: %d:%d:%d", dias,horas,minutos,segundos);
		return Retorno;
	}
	
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Boolean getOcupando() {
		return ocupando;
	}
	public void setOcupando(Boolean ocupando) {
		this.ocupando = ocupando;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
