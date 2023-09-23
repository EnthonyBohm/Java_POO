
package ufpel.enthony.trabalhofinal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Personagem extends JPanel{
    protected       int                 vida;
    protected       boolean             visivel;
    protected       Posicao             position;
    protected       String              classe;
    protected       Campo[][]           mapa;
    protected       JLabel              texto;
    protected       GridBagConstraints  c;
    protected final int                 DIREITA = 1, ESQUERDA = 2, CIMA = 3, BAIXO = 4;
    
    //Métodos Especiais
    public Personagem(String classe, ImageIcon icone) {
        c               =   new GridBagConstraints();
        position        =   new Posicao();
        vida            =   100;
        this.classe     =   classe;

        //Definição do Layout
        setLayout(new GridBagLayout());
        setBackground(null);
        
        //Redimensionamento da Imagem
        Image imagem = icone.getImage();
        Image newImage = imagem.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(newImage);
        add (new JLabel(icone), c);

        //Painel definido como Visível (Painel = Campo)
        setVisible(true);
    }


    //Métodos Referentes à movimentação do Personagem
    public boolean movimenta (int movimento) {
        boolean done = false;

        switch (movimento){
            case DIREITA:         
                done = position.moveDireita();
                break;
            case ESQUERDA:         
                done = position.moveEsquerda() ;
                break;  
            case CIMA:         
                done = position.moveAcima() ;
                break;
            case BAIXO:         
                done = position.moveAbaixo();
                break;
        }

        return done;
    }


    //Métodos Referentes a posição do Personagem e outros Personagens/Objetos
    public boolean mesmoBloco (Personagem e){
        return getPosition().equals(e.getPosition());
    }
    public boolean mesmoBloco (Objeto e){
        return getPosition().equals(e.getPosition());
    }
    public boolean mesmoBloco(Buraco e){
        return position.equals(e.getPosition());
    }



    //
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isVisivel() {
        return visivel;
    }
    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
    
    public String getClasse (){
        return classe;
    }

    public Posicao getPosition() {
        return position;
    }
    public void setPosition(Posicao position) {
        this.position = position;
    }
    
    
}
