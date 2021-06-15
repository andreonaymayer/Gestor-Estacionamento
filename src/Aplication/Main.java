package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import Entities.Carro;
import Entities.Patio;
import Entities.Registro;

public class Main {


	public static void main(String[] args) throws ParseException   {
		SimpleDateFormat tipoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date a = tipoData.parse("12/01/2020 12:00:00");
		Date b = tipoData.parse("12/01/2020 14:00:00");
		
		Patio patio;
		patio = new Patio(10, 5.00, 100.00);		
		
		Carro car;
		car = new Carro("III-6787");
		Registro reg;
		reg = new Registro(null, null, car,patio);
		
		reg.saidaDeVeiculo(b);
		System.out.println(reg);
		
	}

}