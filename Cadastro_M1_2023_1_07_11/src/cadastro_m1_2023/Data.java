/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_m1_2023;

import java.time.LocalDate;

/**
 *
 * @author Felipe Marques
 */
public class Data {
    private final int dia;
    private final int mes;
    private final int ano;
    private static final String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril",
                                           "Maio", "Junho", "Julho", "Agosto",
                                           "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    public Data(int dia, int mes, int ano) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public int dia() {
        return dia;
    }
    
    public int mes() {
        return mes;
    }
    
    public int ano() {
        return ano;
    }
    
    @Override
    public String toString() {
        return (dia < 10 ? "0"+dia : dia) + "/" + (mes < 10 ? "0"+mes : mes) + "/" + ano;
    }
    
    public String porExtenso() {
        return (dia < 10 ? "0"+dia : dia) + " de " + nomeDoMes(mes) + " de " + ano;
    }
    
    public static String nomeDoMes(int mes) {
        if (mes > 0 && mes < 13)
            return meses[mes-1];
        return null;
    }
    
    public int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - ano;
        if (dataAtual.getMonthValue() < mes)
            idade--;
        else if (dataAtual.getMonthValue() == mes &&
                 dataAtual.getDayOfMonth() < dia)
            idade--;
        return idade;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) {  
           return true;  
       }  
       if (o instanceof Data) {  
           Data outraData = (Data) o;  
           if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia == outraData.dia) {  
               return true;  
           }  
       }  
       return false;              
    }
}