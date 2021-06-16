package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import Entities.Carro;
import Entities.Patio;
import Entities.Registro;

public class Main {


	public static void main(String[] args) throws ParseException   {
		SimpleDateFormat tipoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date a = tipoData.parse("01/06/2021 15:00:00");
		Date b = tipoData.parse("31/06/2021 15:00:00");
		
		Patio patio;
		patio = new Patio(10,(double) 5.00,(double) 100.00);		
		
		Carro car;
		car = new Carro("III-6787");
		
		Registro reg;
		reg = new Registro(a, b, car, patio);
		
		
		
	}

}