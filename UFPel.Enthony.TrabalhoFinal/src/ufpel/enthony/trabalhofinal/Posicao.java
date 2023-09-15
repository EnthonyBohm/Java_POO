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
        posicao[0] = rand.nextInt(15);
        posicao[1] = rand.nextInt(15);
    }
    public Posicao (int x, int y){
        posicao = new int[2];
        posicao[0] = x;
        posicao[1] = y;
    }
    
    public boolean moveAcima () {
        try {
            posicao[1] -= 1;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        
    }
    public boolean moveAbaixo () {
        try {
            posicao[1] += 1;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
    public boolean moveDireita () {
        try {
            posicao[0] += 1;   
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
    public boolean moveEsquerda () {
        try {
            posicao[0] -= 1;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    // public boolean mesmoBloco( Personagem o){
    //     return e.getPosition().equals(o.getPosition());
    // }
    // public boolean mesmoBloco(Objeto o){
    //     return this.getPosition().equals(o.getPosition());
    // }
    
    
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
