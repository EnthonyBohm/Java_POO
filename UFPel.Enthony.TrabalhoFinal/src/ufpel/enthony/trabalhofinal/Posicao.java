package ufpel.enthony.trabalhofinal;

import java.util.Random;

/**
 * @author entho
 */
public class Posicao {
    int[] posicao;
    Random rand = new Random();
    
    public Posicao () {
        posicao = new int[2];
        do {
        posicao[0] = rand.nextInt(15);
        posicao[1] = rand.nextInt(15);
        } while (posicao[0] == 0 && posicao[1] == 0);
    }
    public Posicao (int x, int y){
        posicao = new int[2];
        posicao[0] = x;
        posicao[1] = y;
    }
    
    public boolean moveAcima () {
        if (getY() == 0)
            return false;
        else{
            posicao[1] -= 1;
            return true;
        }    
    }
    public boolean moveAbaixo () {
        if (getY() == 14)
            return false;

        posicao[1] += 1;
        return true;
    }
    public boolean moveDireita () {
        if (getX() == 14)
            return false;

        posicao[0] += 1;   
        return true;
    }
    public boolean moveEsquerda () {
        if (getX() == 0)
            return false;
        posicao[0] -= 1;
        return true;
    }


    
    
    //Métodos Especiais
    public int[] getPosicao (){
        return posicao;
    }
    public int getX (){
        return posicao[0];
    }
    public int getY () {
        return posicao[1];
    }
    
    @Override
    public boolean equals(Object e){
        return (this.getX() == ((Posicao)e).getX()) 
            && (this.getY() == ((Posicao)e).getY());
    }
}
