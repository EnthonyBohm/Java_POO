package exercicio02.pkg05;
public class EntradaNaAgenda extends DataHora{
    private String evento;
    
    public EntradaNaAgenda ( byte dia, byte mes, short ano, byte segundo, byte minuto, byte hora, String evento){
        super(dia, mes, ano, segundo, minuto, hora);
        this.evento = evento;
    }
}
