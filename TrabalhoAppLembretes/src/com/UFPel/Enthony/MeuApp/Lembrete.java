package com.UFPel.Enthony.MeuApp;

public class Lembrete implements Comparable<Lembrete> {
	private String 			nomeEvento;
	private Data			data;
	
	public Lembrete ( String nome, int dia, int mes, int ano ) {
		this.nomeEvento = nome ;
		data = new Data(dia, mes, ano);
	}
	
	public String getNomeEvento() { return nomeEvento; }
	
	public Data getData() {return this.data;}

	
	@Override
	public String toString() {
		return nomeEvento + ": " + data.toString();
	}
	@Override
	public int compareTo(Lembrete o) {
		return data.compareTo(o.getData());
	}
	
	@Override
	public boolean equals(Object o) {
		if( this.nomeEvento == ((Lembrete) o).getNomeEvento() )
			return true;
		return false;
	}
	
	
//	public boolean equals(Object o) {
//		if( this.nomeEvento == ((Lembrete) o).getNomeEvento() )
//			if( this.compareTo( ((Lembrete) o) ) == 0 )
//				return true;
//		
//		return false;
//	}
}
