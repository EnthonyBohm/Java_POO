/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s1_ex01;

/**
 *
 * @author entho
 */
public class Pessoa {
    private String nome;
    private Data dataNacimento;
    private float altura;

    Pessoa() {
        this.nome = "Fulano";
        this.dataNacimento = new Data(dia: 1, mes: 1, ano: 1900);
        this.altura = 0.0f;
    }
    
    
}
