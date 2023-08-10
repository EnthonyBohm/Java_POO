package com.UFPel.Enthony.MeuApp;

import java.util.ArrayList;
import java.util.Scanner;

public class AppLembretes {

	public void main(String[] args) {
		ListaLembretes lembretes = new ListaLembretes();
		
		int escolha = 0;
		while(escolha != 9) {
			escolha = menu();
			
			switch (escolha) {
			case 1:
				Lembrete novo = adicionaEvento();
				lembretes.adicionaEvento(novo);
				break;
				
			case 2:
				ArrayList <Lembrete> lembretesPorNome = buscaPorNome(lembretes);
				
				for(Lembrete lembrete: lembretesPorNome) {
					
				}
			}
		}
	
		
		
		
		
		
		
		
		

	}
	//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	//-=-=-=-=-=-=Método para interface de interação com usuário-=-=-=-=-=-=-=
			public int menu () {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("-=-=-=-=-=-=-=--==-MENU DA AGENDA-=-=-=-=-=-=-=--==-");
				System.out.println("Adicionar novo elemento (1)");
				System.out.println("Excluir lembrete por índice (2)");
				System.out.println("Buscar lembretes (3)");
				System.out.println("Buscar lembretes por mês (4)");
				System.out.println("Buscar lembretes por dia (5)");
				System.out.println("Mostrar todos lembretes (6)");
				System.out.println("Mostrar lembretes de um mês (ordem crescente) (7)");
				System.out.println("Mostrar lembretes de um dia (ordem crescente) (8)");
				System.out.println("Sair da agenda (9)");
				System.out.println("-=-=-=-=-=-=-=--==-MENU DA AGENDA-=-=-=-=-=-=-=--==-");
				
				
				return sc.nextInt();
			}
	//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
	//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	//-=-=-=-=-=-=-=-=-=-Método de adição de novo evento-=-=-=-=-=-=-=-=-=-=-=
		public Lembrete adicionaEvento () {
			String descricao;
			int dia, mes, ano;
			Scanner sc = new Scanner(System.in); 
			
			System.out.println("Descrição do novo lembrete: ");
			descricao = sc.nextLine();
			System.out.println("Dia do novo evento: ");
			dia = sc.nextInt();
			System.out.println("Mês do novo evento: ");
			mes = sc.nextInt();
			System.out.println("Ano do novo evento: ");
			ano = sc.nextInt();
			
			Lembrete novo = new Lembrete(descricao, dia, mes, ano);
			return novo;
		}
	//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	//-=-=-=-=-=-=-=-=-Método de busca de eventos por nome-=-=-=-=-=-=-=-=-=-=
		public ArrayList<Lembrete> buscaPorNome(ListaLembretes lista){
			ArrayList<Lembrete> lembretesPorNome = new ArrayList<>();
			
			return lembretesPorNome;
		}
}
