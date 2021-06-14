package Aplication;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;



public class Main {


	public static void main(String[] args)   {
			
		diferenca();
		
		
}

	public static void diferenca ()
	{
		LocalDateTime a = LocalDateTime.of(1998, 01, 15, 10, 30, 10);
		LocalDateTime b = LocalDateTime.of(1998, 01, 15, 11, 35, 05);
		
		Duration pere = Duration.between(a, b);
		long diff = pere.toSeconds()60;
		System.out.println(diff/60);
	}

}