package ufpel.enthony.trabalhofinal;

import javax.swing.JLabel;

/**
 * @author entho
 */
public class Objeto extends JLabel{
    Posicao position;
    String tipo;
    
    public Objeto (String nome){
        this.tipo = nome;
        this.setText(nome);
        this.setVisible(true);
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
    
    public boolean mesmoBloco (Personagem e){
        return this.getPosition().equals(e.getPosition());
    }
    public boolean mesmoBloco (Objeto e){
        return this.getPosition().equals(e.getPosition());
    }
    public boolean mesmoBloco(Buraco e){
        return position.equals(e.getPosition());
    }
}
