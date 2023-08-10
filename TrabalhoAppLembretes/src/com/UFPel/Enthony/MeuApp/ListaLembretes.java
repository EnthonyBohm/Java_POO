package com.UFPel.Enthony.MeuApp;

import java.util.ArrayList;
import java.util.List;

public class ListaLembretes {
	private List<Lembrete> lista;
	
	public ListaLembretes () {
		lista = new ArrayList<>();
	}
	
	public void adicionaEvento(Lembrete evento) {
		lista.add(evento);
	}
	
	public void removeEvento (int position) {
		lista.remove(position);
	}
	
	public Boolean removeEvento (String nomeEvento) {
		for(Lembrete evento: lista) {
			if(evento.getNomeEvento() == nomeEvento) {
				lista.remove(evento);
				return true;
			}
		}
		return false;
	}
	
	
	
}
