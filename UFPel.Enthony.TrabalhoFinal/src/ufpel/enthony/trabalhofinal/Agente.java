
package ufpel.enthony.trabalhofinal;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Agente extends Personagem{ 
//    Metodos Herdados
//    int pv 
//    boolean visivel 
//    Posicao position
    private         ArrayList<Objeto>   objetos;
    private         int                 bateriaLanterna;

    ImageIcon icone;
    
    public Agente(){
        super("Agente", new ImageIcon ("C:\\Users\\entho\\OneDrive\\Documentos\\GitHub\\Java_POO\\UFPel.Enthony.TrabalhoFinal\\src\\IconeAgente.png"));
        super.setPosition(new Posicao(0, 0));

        bateriaLanterna = 100;
        objetos = new ArrayList<>();

        setVisible(true);
    }


    


}
