/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lembretesapp_m2;

/**
 *
 * @author felipe
 */
public class LembretesApp_M2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlocoDeLembretes bloco = new BlocoDeLembretes();
        
        Lembrete l1 = new  Lembrete("Prova de POO", 15);
        bloco.inserir(l1);
        bloco.inserir(new Lembrete("Trabalho de POO", 30));
        bloco.inserir(new Lembrete("Aula de Coleções", 20));
        
        bloco.ordenar();
        
        //Lembrete excluido = bloco.remover(0);
        //System.out.println("Removido: " + excluido);

        Lembrete l = bloco.buscar(0);
        System.out.println("Lembrete: " + l);
                
        System.out.println(bloco);
    }
    
}
