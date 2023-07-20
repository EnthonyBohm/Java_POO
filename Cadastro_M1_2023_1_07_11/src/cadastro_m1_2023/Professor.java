/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro_m1_2023;

/**
 *
 * @author felipe
 */
public class Professor extends Pessoa {
    private String siape;
    
    public Professor(String nome, String cpf,
                     float altura, Data d, String siape) {
        super(nome, cpf, altura, d);
        this.siape = siape;
    }
    
    @Override
    public String toString() {
        return "Professor -> \n" +
                super.toString() +
                "\nSIAPE: " + siape;
    }
}
