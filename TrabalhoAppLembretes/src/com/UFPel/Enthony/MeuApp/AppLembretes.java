package com.UFPel.Enthony.MeuApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppLembretes {

	public static void main(String[] args) {
		ListaLembretes lembretes = new ListaLembretes();
		List <Lembrete> subLista;
		int dia, mes, ano;
		Scanner sc = new Scanner(System.in);
		
		int escolha = 0;
		while(escolha != 9) {
			escolha = menu();
			
			switch (escolha) {
			case 1:
				Lembrete novo = adicionaEvento();
				lembretes.adicionaEvento(novo);
				break;
			
			case 2:
				System.out.println("Índice do evento a ser removido: ");
				lembretes.removeEvento((sc.nextInt())-1);
				break;

			case 3:
				String palavra;
				System.out.println("Que palavra deseja procurar em seus lembretes? ");
				palavra = sc.nextLine().toLowerCase();

				subLista = lembretes.buscarPorSubstring(palavra);
				
				for(Lembrete lembrete: subLista) {
					System.out.println(lembrete);
				}
				break;

			case 4:
				System.out.println("Digite o mês que gostaria de procurar? ");
				mes = sc.nextInt();
				System.out.println("Agora o ano");
				ano = sc.nextInt();

				subLista = lembretes.buscaPorMes(mes, ano);
				
				for(Lembrete lembrete: subLista){
					System.out.println(lembrete);
				}

				break;
			case 5:
				System.out.println("Digite o dia que gostaria de procurar: ");
				dia = sc.nextInt();
				System.out.println("Agora o mês: ");
				mes = sc.nextInt();
				System.out.println("Agora o ano: ");
				ano = sc.nextInt();

				subLista = lembretes.buscaPorDia(dia, mes, ano);
				
				for(Lembrete lembrete: subLista){
					System.out.println(lembrete);
				}

				break;

			case 6:
				System.out.println(lembretes);
				break;
			
			case 7:
				System.out.println("Digite o mês que gostaria de procurar? ");
				mes = sc.nextInt();
				System.out.println("Agora o ano");
				ano = sc.nextInt();

				subLista = lembretes.buscaPorMes(mes, ano);
				
				Collections.sort(subLista);
				
				for(Lembrete lembrete: subLista){
					System.out.println(lembrete);
				}

				break;
			case 8:
				System.out.println("Digite o dia que gostaria de procurar: ");
				dia = sc.nextInt();
				System.out.println("Agora o mês: ");
				mes = sc.nextInt();
				System.out.println("Agora o ano: ");
				ano = sc.nextInt();

				subLista = lembretes.buscaPorDia(dia, mes, ano);
				
				for(Lembrete lembrete: subLista){
					System.out.println(lembrete);
				}

				break;
			case 0:
				lembretes.ordenar();
			}
			

			
		}
	
		
		
		
		
		
		
		
		

	}
	//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	//-=-=-=-=-=-=Método para interface de interação com usuário-=-=-=-=-=-=-=
			private static int menu () {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("-=-=-=-=-=-=-=--==-=-=-=-MENU DA AGENDA-=-=-=-=-=-=-=-=-=-=--==-");
				System.out.println("Adicionar novo elemento (1)");
				System.out.println("Excluir lembrete por índice (2)");
				System.out.println("Buscar lembretes (3)");
				System.out.println("Buscar lembretes por mês (4)");
				System.out.println("Buscar lembretes por dia (5)");
				System.out.println("Mostrar todos lembretes (6)");
				System.out.println("Mostrar lembretes de um mês (ordem Alfabetica crescente) (7)");
				System.out.println("Mostrar lembretes de um dia (ordem Alfabetica crescente) (8)");
				System.out.println("Ordena a agenda (ordem Crescente) (0)");
				System.out.println("Sair da agenda (9)");
				System.out.println("-=-=-=-=-=-=-=--==-=-=-=-MENU DA AGENDA-=-=-=-=-=-=-=-=-=-=--==-");
				
				
				return sc.nextInt();
			}
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
			
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//-=-=-=-=-=-=-=-=-=-Método de adição de novo evento-=-=-=-=-=-=-=-=-=-=-=
		private static Lembrete adicionaEvento () {
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
		
}
