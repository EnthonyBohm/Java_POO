/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro_m1_2023;

/**
 *
 * @author felipe
 */
public class Cadastro {
    private Pessoa[] lista;
    private int numeroDePessoas;
    
    public Cadastro(int tamanho) {
        lista = new Pessoa[tamanho];
        numeroDePessoas = 0;
    }
    
    public int tamanhoDaLista() {
        return numeroDePessoas;
    }
    
    public void inserir(Pessoa p) {
        if (numeroDePessoas < lista.length) {
            lista[numeroDePessoas] = p;
            numeroDePessoas++;
        } else { // Duplicar tamanho do vetor
            Pessoa[] novaLista = new Pessoa[lista.length * 2];
            for (int i=0; i < numeroDePessoas; i++)
                novaLista[i] = lista[i];
            lista = novaLista;
            lista[numeroDePessoas] = p;
            numeroDePessoas++;
        }
    }
    
    public Pessoa remover(int posicao) {
        if (posicao >= 0 && posicao < numeroDePessoas) {
            int i;
            Pessoa p = lista[posicao];
            for(i = posicao; i < numeroDePessoas-1; i++) {
                lista[i] = lista[i+1];
            }
            numeroDePessoas--;
            return p;
        }
        return null;
    }
    
    public int buscaPorNone(String nome) {
        int i = 0;
        while (i < numeroDePessoas) {
            if (lista[i].getNome().equals(nome))
                return i;
            i++;
        }
        return -1;
    }
    
    public int busca(Pessoa p) {
        int i = 0;
        while (i < numeroDePessoas) {
            if (lista[i].equals(p))
                return i;
            i++;
        }
        return -1;
    }
    
    public void imprimir() {
        int i;
        for(i = 0; i < numeroDePessoas; i++) {
            System.out.println(lista[i]);
        }
    }
}



