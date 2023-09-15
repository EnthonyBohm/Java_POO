package ufpel.enthony.trabalhofinal;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author entho
 */
public class Buraco extends JPanel {
    Posicao position;
    
    
    public Buraco () {
        this.add (new JLabel ("Poço"));
        this.setVisible(true);
        position = new Posicao();
    }

    public Posicao getPosition() {
        return position;
    }
    public void setPosition(Posicao position) {
        this.position = position;
    }
    
    
    
    @Override
    public String toString() {
        return "Poço";
    }
}
