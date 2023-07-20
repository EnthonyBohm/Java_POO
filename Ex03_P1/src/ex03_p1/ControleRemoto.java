
package ex03_p1;


public class Controle{
    private Televisao tv;
    String botao;
    
    public void ligaTv(char botão){
            tv.ligar();
    }
    
    public void desligaTv(char botão){
        tv.desligar();
    }
    
    public void trocaCanal(char botão){
        tv.trocaCanal(botão);
    }
    
    public void trocaVolume(char botão){
        tv.trocaVolume(botão);
    }

}
