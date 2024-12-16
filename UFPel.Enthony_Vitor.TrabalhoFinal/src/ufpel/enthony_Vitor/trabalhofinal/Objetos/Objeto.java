package ufpel.enthony_Vitor.trabalhofinal.Objetos;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ufpel.enthony_Vitor.trabalhofinal.Campo.Campo;
import ufpel.enthony_Vitor.trabalhofinal.Posicao.Posicao;


public class Objeto extends JPanel{
    protected       Posicao     position;
    protected       String      tipo;
    protected       JLabel      texto;
    protected       int         x,y;

    
    public Objeto (String nome, ImageIcon icone){
        tipo = nome;

        // Adiciona e redimensiona a imagem de Ícone
        Image imagem = icone.getImage();
        Image newImage = imagem.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(newImage);
        add (new JLabel(icone));

        // Adiciona o Layout certo
        setLayout(new GridBagLayout());
        setBackground(null);
        setVisible(true);

        // Adiciona o Objeto em uma posição aleatória
        posicaoAleatoria();
        x = position.getX();
        y = position.getY();
    }

        // Construtor para objetos que só o nome importa
    public Objeto (String nome){
        this.tipo = nome;
    }

    public void posicaoAleatoria () {
        position = new Posicao();
    }
    public void posicaoAleatoria (Campo[][] mapa){
        do{
            position = new Posicao();
            x = position.getX();
            y = position.getY();
        } while (mapa[x][y].HasTrap() || mapa[x][y].hasCharacter() || mapa[x][y].hasItem());
        
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

    @Override
    public String toString() {
        return tipo;
    }
}
