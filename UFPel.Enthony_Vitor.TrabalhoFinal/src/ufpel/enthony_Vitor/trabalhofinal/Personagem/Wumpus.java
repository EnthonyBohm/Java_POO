package ufpel.enthony_Vitor.trabalhofinal.Personagem;

import java.util.Random;

import javax.swing.ImageIcon;

import ufpel.enthony_Vitor.trabalhofinal.Campo.Campo;


public class Wumpus extends Monstro {
    private Random randDirection;
    private int movimento;

    public Wumpus() {
        super("Wumpus", new ImageIcon( "src\\ufpel\\enthony_Vitor\\trabalhofinal\\Icones\\IconeMonstro.png" ));
        randDirection = new Random();
        setVisible(false);
    }

    @Override
    public void atacar(Agente e) {
        e.setVida(0);
    }
    
    public void movimenta(Campo[][] mapa, Agente a) {

        boolean done = false;
        Campo atual = null, prox = null;

        atual = mapa[x][y];
        super.removerFedor(mapa);
        while (!done) {
            movimento = randDirection.nextInt(1, 5);

            switch (movimento) {
                case DIREITA:
                    done = movimenta(movimento);
                    break;
                case ESQUERDA:
                    done = movimenta(movimento);
                    break;
                case CIMA:
                    done = movimenta(movimento);
                    break;
                case BAIXO:
                    done = movimenta(movimento);
                    break;
            }

            if (done) {
                prox = mapa[x][y];
                if (prox.HasTrap()) {
                    position = atual.getPosition();
                    done = false;
                }
            }

        }
        super.emanarFedor(mapa);

        if (prox != null) {
            atual.removePersonagem(this);
            if (prox.isVisivel() == false) {
                setVisible(false);
                prox.adicionaPersonagem(this);
            } else {
                setVisible(true);
                prox.adicionaPersonagem(this);
            }
        }

        if (position.samePosition(a)) {
            atacar(a);
        }
    }

    public void kill (){
        super.kill("src\\ufpel\\enthony_Vitor\\trabalhofinal\\Personagem\\Sons\\WumpusMorto.wav");        
    }
}
