package exercicio02.pkg05;
public class Agenda {
    EntradaNaAgenda[] eventos;
    private byte segundo, minuto, hora, dia, mes;
    short ano;
    
    public Agenda(byte dia, byte mes, short ano, byte seg, byte min, byte hr){
        this.segundo =seg; this.minuto = min; this.hora = hr;
        this.dia  = dia; this.mes = mes; this.ano = ano;
    }
    
    public void NovoEvento(String evento){
        eventos = new EntradaNaAgenda[](getDia(), getMes(), getAno(), getSegundo(), getMinuto(), getHora(), evento);
    }

    public EntradaNaAgenda[] getEventos() {
        return eventos;
    }

    public byte getSegundo() {
        return segundo;
    }

    public byte getMinuto() {
        return minuto;
    }

    public byte getHora() {
        return hora;
    }

    public byte getDia() {
        return dia;
    }

    public byte getMes() {
        return mes;
    }

    public short getAno() {
        return ano;
    }
    
    
}
