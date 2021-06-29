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
	private Integer idRegistro;


	
	public String toString() {
		String ocupe = "Não";
		if (ocupando) {
			ocupe = "Sim";
		}
		return "Veiculo: "+ veiculo.getPlaca() + "\n  entrada =" + entrada + ", saida=" + saida + ", veiculo=" + veiculo.getPlaca() + ", ocupando=" + ocupe
				+ ", valorTotal=" + valorTotal + ", dias=" + dias + ", horas=" + horas + ", minutos=" + minutos + " ;";
	}

	public Registro(Date entrada, Date saida, Veiculo veiculo, Patio patio, Boolean ocupando) {
		this.entrada = entrada;
		if (entrada==null) {
		    Date dataAtual = new Date();  
			this.entrada = dataAtual;
		}
		this.saida = saida;
		this.veiculo = veiculo;
		this.patio = patio;
		patio.entradaVeiculo();
		this.ocupando = ocupando;
		this.veiculo.setOcupandoVei(ocupando);
	}
	
	public void saidaDeVeiculo() {
		Date dataAtual = new Date();
		this.saida = dataAtual;
		this.ocupando = false;
		patio.saidaVeiculo();
		this.veiculo.setOcupandoVei(false);
		Diferenca();
		System.out.println("Valor Total: "+ this.valorTotal);
	}
	
	public void setValorTotal() {
		this.valorTotal = this.horas * patio.getValorHora();
		this.valorTotal = this.valorTotal + patio.getValorDiaria() * dias;
		if (this.minutos>15) {
			this.valorTotal=this.valorTotal + patio.getValorHora();
		}
	}
	
	public void entradadeVeiculo(Date entrada) {
		this.entrada = entrada;
		this.ocupando = true;
	}
	
	
	public void Diferenca () {
		Long x = saida.getTime() - entrada.getTime();
		int horas = (int) (x/1000/60/60);
		setHoras(horas);
		int dias = (int) horas/24;
		setDias(dias);
		int minutos = (int) ((x/1000)/60) - (horas*60);
		setMinutos(minutos);
		//int segundos = (int) (x/1000)- minutos*60 - horas*3600;
		horas = (int) (x/1000/60/60)-dias*24;
		setHoras(horas);
		setValorTotal();
		System.out.printf("Dias: %d\nHoras: %d\nMinutos: %d\n",dias,horas,minutos);
		
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


	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	
	
	
}
