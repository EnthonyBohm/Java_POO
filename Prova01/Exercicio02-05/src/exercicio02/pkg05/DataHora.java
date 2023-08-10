package exercicio02.pkg05;
class DataHora extends Data{
    private Hora hora;
    
    public DataHora(byte dia, byte mes, short ano, byte s, byte m, byte h){
        super(dia, mes, ano);
        hora = new Hora(s, m, h);
    }
    
}
