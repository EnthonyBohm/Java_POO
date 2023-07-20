/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastro_m1_2023;

/**
 *
 * @author felipe
 */
public class Cadastro_M1_2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cadastro c = new Cadastro(2);
        
        System.out.println("Comprimento do vetor: " + c.tamanhoDaLista());
        
        Pessoa p1 = new Pessoa("Joao", "999", 1.70f, new Data(4,5,2015));
        Pessoa p2 = new Pessoa("Maria", "888", 1.60f, new Data(4,5,2016));
        Pessoa p3 = new Pessoa("Bruxa", "666", 1.60f, new Data(9,5,2016));

        Pessoa p4 = new Professor("Mago", "333", 1.60f,
                                new Data(9,5,2016), "12345");
        
        c.inserir(p1);
        c.inserir(p2);
        c.inserir(p3);
        c.inserir(p4);
        c.imprimir();
        
        System.out.println("-------------------------------------------------");
        int posicao = c.buscaPorNone("Maria");
        System.out.println("Qual a posição da Maria? " + posicao);
        
        System.out.println("-------------------------------------------------");
        c.remover(posicao);
        c.imprimir();
        
        System.out.println("-------------------------------------------------");
        System.out.println("Indice da Bruxa: " + c.busca(p2));
    }
    
}
