package Quest04;

import java.util.Scanner;
import Quest03.Data;

public class TestarCinema {

	public static void main(String[] args) {
		


		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite os dados da sess�o");
		
		String data = "";
		
		while(true){
			System.out.print("Data: (DD/MM/AAAA) ");
			data = input.next();
			if(data.length() == 10)
				break;
			else
				System.out.println("Data invalida");
		}


		System.out.print("Horario: (00:00) ");
		String horario = input.next();

		System.out.print("Sala: ");
		int sala = input.nextInt();

		System.out.print("Valor: ");
		float valor = input.nextFloat();

		EntradaDeCinema ent = new EntradaDeCinema(data, horario, sala, valor);
		
		
		System.out.println("Dados do cliente");
		  
		String nasc = "";
		
		while(true){
			System.out.print("Data: (DD/MM/AAAA) ");
			nasc = input.next();
			if(nasc.length() == 10)
				break;
			else
				System.out.println("Data invalida");
		}
		
		System.out.print("N�mero da carteira de estudante: "); 
		int cart = input.nextInt();
	
		ent.calculaDescontoHorario(nasc, cart); 
		ent.imprimaString(nasc); 
		

	}

}
