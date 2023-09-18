
package ufpel.enthony.trabalhofinal;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Personagem extends JLabel{
    protected     int         vida;
    protected     boolean     visivel;
    protected     Posicao     position;
    protected     String      classe;
    protected     Campo[][]   mapa;
    
    //Métodos Especiais
    public Personagem(String classe, ImageIcon icone) {
        vida = 100;
        this.classe = classe;
        setText(classe);
        setVisible(true);
        setFont(new Font("Comic Sans MS", 0, 12));
    }
    
    public void aleatorizaPosicao(){
        position = new Posicao();
    }

    public boolean movimentaDireita (Mapa mapa){
        this.mapa = mapa.getCampo();
        Campo pAtual, pProx;
        pAtual = this.mapa[position.getX()][position.getY()];
        
        if (position.moveDireita() == false)
            return false;
        pProx = this.mapa[position.getX()][position.getY()];
        if (pProx.HasTrap()){
            position.moveEsquerda();
            return false;
        }
        
        pAtual.removePersonagem(this);
        pAtual.repaint();
        pProx.adicionaPersonagem(this);
        if (!(pProx.isVisivel()))  
            pProx.deixaVisível();
        
        

        return true;
    }

    public boolean movimentaAbaixo (Mapa mapa){
        this.mapa = mapa.getCampo();
        Campo pAtual, pProx;
        pAtual = this.mapa[position.getX()][position.getY()];
        if (position.moveAbaixo() == false )
            return false;
        pProx = this.mapa[position.getX()][position.getY()];
        if (pProx.HasTrap()){
            position.moveAcima();
            return false;
        }
        
        pAtual.removePersonagem(this);
        pAtual.repaint();
        if (!(pProx.isVisivel()))  
            pProx.deixaVisível();
        pProx.adicionaPersonagem(this);
        

        return true;
    }

    public boolean movimentaEsquerda (Mapa mapa){
        Campo pAtual, pProx;
        
        this.mapa = mapa.getCampo();
        pAtual = this.mapa[position.getX()][position.getY()];
        if (position.moveEsquerda() == false)
            return false;    
        pProx = this.mapa[position.getX()][position.getY()];

        if (pProx.HasTrap()){
            position.moveDireita();
            return false;
        }

        pAtual.removePersonagem(this);
        pAtual.repaint();
        if (!(pProx.isVisivel()))  
            pProx.deixaVisível();
        pProx.adicionaPersonagem(this);
        


        return true;
    }

    public boolean movimentaAcima (Mapa mapa){
        this.mapa = mapa.getCampo();
        Campo pAtual, pProx;
        pAtual = this.mapa[position.getX()][position.getY()];

        if (position.moveAcima() == false) 
            return false;
        pProx = this.mapa[position.getX()][position.getY()];
        if (pProx.HasTrap()){
            position.moveAbaixo();
            return false;
        }
        
        pAtual.removePersonagem(this);
        pAtual.repaint();
        if (!(pProx.isVisivel()))  
            pProx.deixaVisível();
        pProx.adicionaPersonagem(this);


        return true;
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
        return this.classe;
    }

    public Posicao getPosition() {
        return position;
    }
    public void setPosition(Posicao position) {
        this.position = position;
    }
    
    
}
