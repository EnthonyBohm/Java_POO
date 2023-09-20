package ufpel.enthony.trabalhofinal;

import java.util.Random;

import javax.swing.ImageIcon;

public class Wumpus extends Personagem {
    //    Metodos Herdados
    //    int pv
    //    boolean visivel 
    //    Posicao position
    
    //Variáveis para movimentação do personagem
    Random randDirection;
    int movimento;
    
    public Wumpus () {
        super("Wumpus", new ImageIcon ("C:\\Users\\entho\\OneDrive\\Documentos\\GitHub\\Java_POO\\UFPel.Enthony.TrabalhoFinal\\src\\ufpel\\enthony\\trabalhofinal\\IconeMonstro.png"));
        randDirection = new Random();
        setVisible(false);
    }

    public void ataca (Agente e){
        e.setVida(0);
    }

    public void movimenta (Mapa mapa){
        boolean done = false;
        while (!done){
            try {
            movimento = randDirection.nextInt(1, 5);
            switch (movimento){
                case 1:
                    done = movimentaDireita(mapa);
                    break;
                case 2:
                    done = movimentaEsquerda(mapa);
                    break;
                case 3:
                    done = movimentaAcima(mapa);
                    break;
                case 4:
                    done = movimentaAbaixo(mapa);
                    break;
            }
        } catch (ImpossibleToPassTrapException e){
            continue;
        } catch(ArrayIndexOutOfBoundsException e){
            continue;
        }
        
        }

    }

    public void emanarFedor (Campo[][] mapa, Posicao pAtual){
        int x,y;
        x = pAtual.getX();
        y = pAtual.getY();
        if (pAtual.moveEsquerda())
            mapa[x-1][y].setIsStinky(true);
        if (pAtual.moveDireita())
            mapa[x+1][y].setIsStinky(true);
        if (pAtual.moveAcima() )
            mapa[x][y+1].setIsStinky(true);
        if (pAtual.moveAbaixo() )
            mapa[x][y-1].setIsStinky(true);
    }
}
