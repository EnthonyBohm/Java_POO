package aulajuly4;
public class Data extends Object{
    private final byte dia;
    private final byte mes;
    private final int ano;
    private String  nomeMes [12] ={"Janeiro", "Fevereiro", "Março", "Abril","Maio","Junho",  "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
    
    public Data(){
        this.dia = 1;
        this.mes = 1;
        this.ano = 1900;
    }
    
    public Data(byte dia, byte mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
}
