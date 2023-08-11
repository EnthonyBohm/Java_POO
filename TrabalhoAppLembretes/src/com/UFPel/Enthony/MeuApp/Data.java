package com.UFPel.Enthony.MeuApp;

public class Data implements Comparable <Data> {
	private int			 dia, mes, ano;
	
	public Data () {
		dia = 1;
		mes = 1;
		ano = 1899;
	}
	
	public Data (int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	@Override
	public String toString () {
		return ((dia < 10 ? "0"+dia : dia)+ "/" + (mes < 10 ? "0"+mes : mes)+ "/" + "/" + ano);
	}

	@Override
	public int compareTo(Data o) {
		if (this.ano < o.ano)
			return -1;
		else if(this.ano > o.ano)
			return +1;
		
		// Anos iguais
		if (this.mes < o.mes)
			return -1;
		else if(this.mes > o.mes)
			return +1;
		
		// Meses iguais
		if ( this.dia < o.dia )
			return -1;
		else if ( this.dia > o.dia )
			return +1;
		
		//Dias iguais
		return 0;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}


	// Métodos Especiais
	
	
}
