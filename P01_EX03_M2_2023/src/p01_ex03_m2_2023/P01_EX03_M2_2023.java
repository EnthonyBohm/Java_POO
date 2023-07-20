/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p01_ex03_m2_2023;

/**
 *
 * @author felipe
 */
public class P01_EX03_M2_2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Televisao tv = new Televisao();
        
        ControleRemoto controle = new ControleRemoto(tv);
        
        controle.info();
        controle.aumentarVolume();
        controle.aumentarVolume();
        controle.aumentarVolume();
        controle.aumentarVolume();
        controle.aumentarVolume();
        controle.trocarCanal(12);
        controle.info();
        tv.aumentarVolume();
        controle.info();
    }
    
}
