package ufpel.enthony.trabalhofinal;

import java.util.Random;

import javax.swing.ImageIcon;

public class Wumpus extends Personagem {
    //    Metodos Herdados
    //    int pv
    //    boolean visivel 
    //    Posicao position
    
    Random rand;
    int movimento;
    ImageIcon icone;
    
    public Wumpus () {
        super("Wumpus", new ImageIcon ("IconeMonstro.png"));
        rand = new Random();
        super.aleatorizaPosicao();
    }

    public void ataca (Agente e){
        e.setVida(0);
    }

    public void movimenta (Mapa mapa){
        boolean done = false;
        while (!done){
            try {
            movimento = rand.nextInt(0, 5);
            switch (movimento){
                case 1:
                    movimentaDireita(mapa);
                    break;
                case 2:
                    movimentaEsquerda(mapa);
                    break;
                case 3:
                    movimentaAcima(mapa);
                    break;
                case 4:
                    movimentaAbaixo(mapa);
                    break;
            }
            done = true;
        } catch (ImpossibleToPassTrapException e){
            continue;
        } catch(ArrayIndexOutOfBoundsException e){
            continue;
        }
        
        }
        

    }
}
