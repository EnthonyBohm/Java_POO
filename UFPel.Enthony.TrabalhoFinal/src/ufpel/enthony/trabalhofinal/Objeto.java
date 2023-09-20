package ufpel.enthony.trabalhofinal;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author entho
 */
public class Objeto extends JPanel{
    protected       Posicao     position;
    protected       String      tipo;
    protected       JLabel      texto;

    
    public Objeto (String nome){
        tipo = nome;
        texto = new JLabel(nome, 2);
        texto.setVerticalAlignment(3);
        texto.setFont(new Font("Comic Sans MS", 0, 12));
        add(texto);

        setLayout(new GridBagLayout());
        setBackground(null);
        setVisible(true);
        position = new Posicao();
    }

    public Posicao getPosition() {
        return position;
    }
    public void setPosition(Posicao position) {
        this.position = position;
    } 
    public String getTipo() {
        return tipo;
    }
}
