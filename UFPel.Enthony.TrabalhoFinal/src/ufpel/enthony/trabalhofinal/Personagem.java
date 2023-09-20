
package ufpel.enthony.trabalhofinal;

import java.awt.Font;
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
    
    //Métodos Especiais
    public Personagem(String classe, ImageIcon icone) {
        position = new Posicao();
        vida = 100;
        this.classe = classe;
        c = new GridBagConstraints();

        /* Métodos substituidos pelo Ícone
        // texto = new JLabel(classe);
        // texto.setFont(new Font("Comic Sans Ms", 0, 12));
        // add(texto);
         */

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
        
        atualizaPosicoes(mapa, pAtual, pProx);

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
        
       atualizaPosicoes(mapa, pAtual, pProx);

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

        atualizaPosicoes(mapa, pAtual, pProx);


        return true;
    }
    public boolean movimentaAcima (Mapa mapa){
        Campo[][] map = mapa.getCampo();
        Campo pAtual, pProx;
        pAtual = map[position.getX()][position.getY()];

        if (position.moveAcima() == false) 
            return false;
        pProx = mapa.getCampo()[position.getX()][position.getY()];
        if (pProx.HasTrap()){
            position.moveAbaixo();
            return false;
        }
        
        atualizaPosicoes(mapa, pAtual, pProx);

        return true;
    }

    public void atualizaPosicoes(Mapa map, Campo pAtual, Campo pProx){
        pAtual.removePersonagem(this);
        pAtual.repaint();

        if (  ((pProx.isVisivel() == false) ) && ( this.getClass().equals(Agente.class) )  )
            pProx.deixaVisível();
        if ( getClass().equals(Wumpus.class))
            map.getWumpus().emanarFedor(map.getCampo(), position);
            
        pProx.adicionaPersonagem(this);
        pProx.repaint();
        
    }


    //Métodos Referentes a posição do Personagem e outros Personagens/Objetos
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
