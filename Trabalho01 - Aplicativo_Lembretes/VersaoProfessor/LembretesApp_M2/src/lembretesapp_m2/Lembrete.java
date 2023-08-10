/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lembretesapp_m2;

/**
 *
 * @author felipe
 */
public class Lembrete implements Comparable<Lembrete> {
    private String descricao;
    // Devera ser expandido para uma data completa;
    // utilizar a classe Data do cadastro de pessoas;
    private int dia; 
    
    public Lembrete(String descricao, int dia) {
        this.descricao = descricao;
        this.dia = dia;
    }
    
    @Override
    public String toString() {
        return dia + " - " + descricao + "\n";
    }

    @Override
    public int compareTo(Lembrete l) {
        //return this.descricao.compareTo(l.descricao);
        return this.dia - l.dia;
    }
}
