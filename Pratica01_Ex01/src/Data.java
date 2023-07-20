/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe Marques
 */
public class Data {
    private final int dia;
    private final int mes;
    private final int ano;
    
    public Data(int dia, int mes, int ano) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    // Get para o dia
    public int dia() {
        return dia;
    }
    
    // Get para o mes
    public int mes() {
        return mes;
    }
    
    // Get para o ano
    public int ano() {
        return ano;
    }
    
    public void imprimir() {
        System.out.println((dia < 10 ? "0"+dia : dia) + "/" + (mes < 10 ? "0"+mes : mes) + "/" + ano);
    }
    
}