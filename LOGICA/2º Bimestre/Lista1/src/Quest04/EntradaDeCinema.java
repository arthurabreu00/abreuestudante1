package Quest04;

import Quest03.Data;

public class EntradaDeCinema {


	
	String dataDofilme;
	String horario;
	int sala;
	float valor;  
	int idadeCli;
	Data date = new Data(dataDofilme);
	
	public EntradaDeCinema(String data, String horario, int sala, float valor) {
		
		this.dataDofilme = data;
		this.horario = horario;
		this.sala = sala;
		this.valor = valor;
		date = new Data(dataDofilme);
	}



	float calculaDesconto(String nasc) {

		if (this.idade(nasc) <= 12) {

			this.valor *= 0.5;
		}

		return this.valor;

	}

	int idade(String nasc) {

		int filme[] = date.getDataFilme(nasc);
		int cliente[] = date.getDataFilme(this.dataDofilme);
		int finala = 0;

		if (filme[1] <= cliente[1])
			
			finala = cliente[2] - (filme[2]);
		
		else if (filme[1] > cliente[1])
			finala = cliente[2] - (filme[2] + 1);
		
		else{
			if (cliente[0] <= filme[0])
				finala = cliente[2] - (filme[2]) ;
			else
				finala = cliente[2] - (filme[2] + 1); ;
		}

		return finala;

	}

	float calculaDescontoEstudante(String nasc, int cart) {
		if (cart != 0) {

			int idade = this.idade(nasc);

			if (idade > 12 && idade <= 15) {

				this.valor *= 0.4;

			}

			else if (idade >= 16 && idade <= 20) {

				this.valor *= 0.3;

			}

			else if (idade > 20) {

				this.valor *= 0.2;

			}
			
		}
		
		return this.valor;
	}
	


	float calculaDescontoHorario(String nasc, int cart) {

		this.calculaDesconto(nasc);
		this.calculaDescontoEstudante(nasc, cart);
		
		// ACIMA GARANTO QUE O METODO calculaDescontoHorario() SERA O ULTIMO A
		// SER EXECUTADO.

		if (date.getHora() < 16)
			this.valor *= 0.1;

		return this.valor;
	}

	void imprimaString(String nasc){

		System.out.println("Data do Filme: " + this.dataDofilme);
		System.out.println("Horario: " + this.horario);
		System.out.println("Idade do cliente: " + this.idade(nasc));
		System.out.println("Sala: " + this.sala);
		System.out.println("Valor: R$" + this.valor);


	}

}
