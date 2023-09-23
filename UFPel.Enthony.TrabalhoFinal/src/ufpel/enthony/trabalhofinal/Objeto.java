package ufpel.enthony.trabalhofinal;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author entho
 */
public class Objeto extends JPanel{
    protected       Posicao     position;
    protected       String      tipo;
    protected       JLabel      texto;

    
    public Objeto (String nome, ImageIcon icone){
        tipo = nome;

        Image imagem = icone.getImage();
        Image newImage = imagem.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(newImage);
        add (new JLabel(icone));


        setLayout(new GridBagLayout());
        setBackground(null);
        setVisible(true);
        position = new Posicao();
    }

    public Objeto (String nome){
        this.tipo = nome;
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
