package ex03_p1;

public class Televisao {
    private byte volume;
    private short canal;
    private boolean ligada;
    private byte VOLUME_MAXIMO = 100;
    private short CANAL_MAXIMO= 230;
    
    public void ligar(){
        ligada = true;
    }
    
    public void desligar(){
        ligada = false;
    }
    
    public void trocaCanal(char sinal){
        if ( sinal ==  '+' && canal < CANAL_MAXIMO)
            canal++;
        else if(canal == '-' && canal > 1)
            canal--;
        
        System.out.println("Canal: " +  canal);
    }
    
    public void trocaCanal (short proxCanal){
        canal = proxCanal;
        System.out.println("Canal: " +  canal);
    }
    
    
    public void trocaVolume(char sinal){
        if(sinal == '+' && this.volume < VOLUME_MAXIMO)
            volume++;
        else if(sinal == '-' && this.volume > 0)
            volume--;
        System.out.println("Volume: " + volume);
    }
    
}
