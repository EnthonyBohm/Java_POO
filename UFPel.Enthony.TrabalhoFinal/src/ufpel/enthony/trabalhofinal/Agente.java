
package ufpel.enthony.trabalhofinal;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Agente extends Personagem{ 
//    Metodos Herdados
//    int pv 
//    boolean visivel 
//    Posicao position
    ArrayList<Objeto>   objetos;
    int                 bateriaLanterna;
    ImageIcon icone;
    
    public Agente(){
        super("Agente", new ImageIcon ("IconeAgente.png"));
        super.setPosition(new Posicao(0, 0));

        bateriaLanterna = 100;
        objetos = new ArrayList<>();

        setVisible(true);
    }


    


}
