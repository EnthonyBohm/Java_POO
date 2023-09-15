
package ufpel.enthony.trabalhofinal;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Agente extends Personagem{ 
//    Metodos Herdados
//    int pv 
//    boolean visivel 
//    Posicao position
    
    ImageIcon icone;
    
    public Agente(){
        super("Agente", new ImageIcon ("IconeAgente.png"));
        super.setPosition(new Posicao(0, 0));
        setSize(10,10);
        setBackground(Color.BLACK);
        
        setVisible(true);
    }


    


}
