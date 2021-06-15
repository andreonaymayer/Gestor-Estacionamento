package Entities;

import java.util.Date;
import Entities.Patio;

public class Registro {
	private Date  entrada;
	private Date  saida;
	private Veiculo veiculo;
	private Boolean ocupando;
	private Double valorTotal;
	private Patio patio;
	private Integer dias;
	private Integer horas;
	private Integer minutos;
	

	
	
	public String toString() {
		return "Registro ["+ patio.getNome() + "]";
	}

	public Registro(Date entrada, Date saida, Veiculo veiculo, Patio patio) {
		this.entrada = entrada;
		if (entrada==null) {
		    Date dataAtual = new Date();  
			this.entrada = dataAtual;
		}
		this.saida = saida;
		this.veiculo = veiculo;
	}
	
	public void saidaDeVeiculo(Date saida) {
		this.saida = saida;
		this.ocupando = false;
		patio.saidaVeiculo();
	}
	
	
	public void entradadeVeiculo(Date entrada) {
		this.entrada = entrada;
		this.ocupando = true;
	}
	
	public void setHoras (int h) {
		this.horas = h;
	}
	public void setDias (int d) {
		this.dias = d;
	}
	public void setMinutos (int m) {
		this.minutos = m;
	}
	
	public String Diferenca (Date menorData, Date maiorData) {
		Long x = maiorData.getTime() - menorData.getTime();
		int horas = (int) (x/1000/60/60);
		setHoras(horas);
		int dias = (int) horas/24;
		setDias(dias);
		int minutos = (int) ((x/1000)/60) - (horas*60);
		setMinutos(minutos);
		int segundos = (int) (x/1000)- minutos*60 - horas*3600;
		horas = (int) (x/1000/60/60)-dias*24;
		String Retorno = String.format("Dia: %d\nHoras: %d:%d:%d", dias,horas,minutos,segundos);
		return Retorno;
	}
	
	
	public void setValorTotal() {
		Double valorReg=(double) 0;
		valorReg = this.dias * patio.getValorDiaria();
		valorReg = valorReg + this.dias * patio.getValorHora();
		if (this.dias == 0 || this.horas == 0 || this.minutos > 5) {
			valorReg = patio.getValorHora();
		}
		
		this.valorTotal = valorReg;
	}

	public double getValorTotal () {
		setValorTotal();
		return valorTotal;
	}
	

	
}
