package ufpel.enthony_Vitor.trabalhofinal.Posicao;

import java.util.Random;

import ufpel.enthony_Vitor.trabalhofinal.Buraco.Buraco;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Objeto;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Personagem;
import ufpel.enthony_Vitor.trabalhofinal.Posicao.Posicao;

// Completo

public class Posicao {
    int[] posicao;
    Random rand = new Random();

    public Posicao() {
        posicao = new int[2];
        do {
            posicao[0] = rand.nextInt(15);
            posicao[1] = rand.nextInt(15);
        } while (posicao[0] == 0 && posicao[1] == 14 || posicao[0] == 0 && posicao[1] == 13 || posicao[0] == 1 && posicao[1] == 14 || posicao[0] == 1 && posicao[1] == 13);      // Garante que não Spawna na memsa posição que o Agente
    }

    public Posicao(int x, int y) {
        posicao = new int[2];
        posicao[0] = x;
        posicao[1] = y;
    }

    public boolean moveAcima() {
        if (getY() == 0)
            return false;
        else {
            posicao[1] -= 1;
            return true;
        }
    }

    public boolean moveAbaixo() {
        if (getY() == 14)
            return false;

        posicao[1] += 1;
        return true;
    }

    public boolean moveDireita() {
        if (getX() == 14)
            return false;

        posicao[0] += 1;
        return true;
    }

    public boolean moveEsquerda() {
        if (getX() == 0)
            return false;
        posicao[0] -= 1;
        return true;
    }

    public boolean samePosition(Object e) {
        if (e instanceof Objeto) {
            return this.equals(((Objeto) e).getPosition());
        } else if (e instanceof Personagem) {
            return this.equals(((Personagem) e).getPosition());
        } else if (e instanceof Buraco) {
            return this.equals(((Buraco) e).getPosition());
        }
        return false;
    }

    // Métodos Especiais
    public int[] getPosicao() {
        return posicao;
    }

    public int getX() {
        return posicao[0];
    }

    public int getY() {
        return posicao[1];
    }

    @Override
    public boolean equals(Object e) {
        return (this.getX() == ((Posicao) e).getX())
                && (this.getY() == ((Posicao) e).getY());
    }
}
