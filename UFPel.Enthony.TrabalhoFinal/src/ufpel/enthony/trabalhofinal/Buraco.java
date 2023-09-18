package ufpel.enthony.trabalhofinal;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * @author entho
 */
public class Buraco extends JLabel {
    private Posicao position;
    
    
    public Buraco () {
        this.setVisible(true);
        setText("Poço");
        setFont(new Font("Comic Sans MS", 0, 12));
        position = new Posicao();
    }


    // Metodos Especiais
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
