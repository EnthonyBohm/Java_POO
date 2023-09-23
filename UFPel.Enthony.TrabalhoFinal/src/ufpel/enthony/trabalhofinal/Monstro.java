package ufpel.enthony.trabalhofinal;

import javax.swing.ImageIcon;

public abstract class Monstro extends Personagem{

    public Monstro (String classe, ImageIcon icone){
        super(classe, icone);
    }

    public abstract void atacar (Agente e);
    public abstract void movimentar (Mapa mapa, Posicao pAtual);
    public void emanarFedor(Campo[][] mapa, Posicao pAtual){
        int x,y;
        Campo campoAtual;
        
        x = pAtual.getX();
        y = pAtual.getY();
        if (x != 0){
            campoAtual = mapa[x-1][y];
            if (campoAtual.isVisivel())
                campoAtual.adicionaFedor();
            
                
        }   
        if (x != 14){
            campoAtual = mapa[x+1][y];
            if (campoAtual.isVisivel())
                campoAtual.adicionaFedor();
        }
        if (y != 0){
            campoAtual = mapa[x][y-1];
            if (campoAtual.isVisivel())
                campoAtual.adicionaFedor();
        }
        if (y != 14){
            campoAtual = mapa[x][y+1];
            if (campoAtual.isVisivel()){
                campoAtual.adicionaFedor();
            }
        }
    }
    public void removerFedor(Campo[][] mapa, Posicao pAtual){
        int x, y;
        Campo campoAtual;

        x = pAtual.getX();
        y = pAtual.getY();

        if (x != 0){
            campoAtual = mapa[x-1][y];
            campoAtual.removeFedor();
        }   
        if (x != 14){
            campoAtual = mapa[x+1][y];
            campoAtual.removeFedor();
        }
        if (y != 0){
            campoAtual = mapa[x][y-1];
            campoAtual.removeFedor();
        }   
        if (y != 14){
            campoAtual = mapa[x][y+1];
            campoAtual.removeFedor();
        }
    }
}
