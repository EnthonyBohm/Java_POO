package ufpel.enthony.trabalhofinal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author entho
 */
public class Buraco extends JPanel {
    private Posicao position;
    private JLabel label;
    
    public Buraco () {
        this.setVisible(false);
        label = new JLabel("Poço");
        label.setForeground(Color.WHITE);
        label.setVisible(this.isVisible());;
        setBackground(null);
        setFont(new Font("Comic Sans MS", 0, 12));
        add(label);
        position = new Posicao();
    }

    public void  gerarBrisa(Campo[][] mapa, Posicao position){
        int x = position.getX();
        int y = position.getY();

        if (x != 0 )  mapa[x-1][y].setBreeze(true);
        if (x != 14)  mapa[x+1][y].setBreeze(true);
        if (y != 0 )  mapa[x][y-1].setBreeze(true);
        if (y != 14)  mapa[x][y+1].setBreeze(true);
    }


    public JLabel getLabel() {
        return label;
    }
    // Metodos Especiais
    public Posicao getPosition() {
        return position;
    }
    public void setPosition(Posicao position) {
        this.position = position;
    }
    
}
