/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lembretesapp_m2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class BlocoDeLembretes {
    private List<Lembrete> lista;
    
    public BlocoDeLembretes() {
        lista = new ArrayList<>();
    }
    
    public void inserir(Lembrete l) {
        lista.add(l);
    }
    
    public Lembrete remover(int posicao) {
        return lista.remove(posicao);
    }
    
    public Lembrete buscar(int posica) {
        return lista.get(posica);
    }
    
    public void ordenar() {
        Collections.sort(lista);
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }
}
