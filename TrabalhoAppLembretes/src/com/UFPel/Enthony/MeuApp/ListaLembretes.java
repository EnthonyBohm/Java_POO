package com.UFPel.Enthony.MeuApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaLembretes {
	private List<Lembrete> lista;
	
	
	/*=======================================
	 		 Adiciona um Evento à Lista
	  =======================================*/
	public void adicionaEvento(Lembrete evento) {
		lista.add(evento);
	}
	
	/*=======================================
			Remove um evento da Lista Atráves
			Do índice do evento
	  =======================================*/
	public void removeEvento (int position) {
		lista.remove(position);
	}
	
	/*==========================================
	  Dado uma posição(indice), busca o elemento
	  Presente nessa posição
	  ==========================================*/
	public Lembrete buscar (int position) {
		return lista.get(position);
	}


	/*===========================================
	  Retorna todas os eventos que tenham a
	  Subpalavra do argumento
	  ===========================================*/
	public List<Lembrete> buscarPorSubstring(String nome) {
		List <Lembrete> eventos = new ArrayList<>();

		for(Lembrete evento: lista){
			String minusculo = evento.getNomeEvento().toLowerCase();

			if(minusculo.contains(nome))
				eventos.add(evento);
		}

		return eventos;
	}


	/*==============================================
	  Retorna todos os eventos de um determinado mês
	  ==============================================*/
	public List<Lembrete> buscaPorMes(int mes, int ano) {
		List<Lembrete> novaLista = new ArrayList<>();

		for (Lembrete evento: lista){
			if(evento.getData().getMes() == mes && evento.getData().getAno() == ano)
				novaLista.add(evento);
		}

		return novaLista;
	}



	/*==============================================
	  Retorna todos os eventos de um determinado dia
	  ==============================================*/
	public List<Lembrete> buscaPorDia(int dia, int mes, int ano) {
		List <Lembrete> novaLista = new ArrayList<>();
		Data novaData = new Data(dia, mes, ano);

		for(Lembrete lembrete: lista){
			if(lembrete.getData().equals(novaData))
				novaLista.add(lembrete);
		}

		return novaLista;
	}


	/*===============================================
	  				Ordena os eventos
	  ===============================================*/
	public void ordenar() {
		Collections.sort(lista);
	}



	//Métodos Especiais
	@Override
	public String toString(){
		return  lista.toString() + "\n";
	}
	
	public ListaLembretes () {
		lista = new ArrayList<>();
	}
	
	
}
