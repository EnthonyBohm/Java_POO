package ufpel.enthony_Vitor.trabalhofinal.Personagem;

import javax.swing.ImageIcon;

import ufpel.enthony_Vitor.trabalhofinal.Campo.Campo;


public abstract class Monstro extends Personagem {
    private boolean alive;

    public Monstro(String classe, ImageIcon icone) {
        super(classe, icone);
        alive = true;
    }
    
    public void emanarFedor(Campo[][] mapa) {
        Campo campoAtual;

        if (x != 0) {
            campoAtual = mapa[x - 1][y];
            if (campoAtual.isVisivel() && campoAtual.HasTrap() == false)
                campoAtual.adicionaFedor();
        }
        if (x != 14) {
            campoAtual = mapa[x + 1][y];
            if (campoAtual.isVisivel() && campoAtual.HasTrap() == false)
                campoAtual.adicionaFedor();
        }
        if (y != 0) {
            campoAtual = mapa[x][y - 1];
            if (campoAtual.isVisivel() && campoAtual.HasTrap() == false)
                campoAtual.adicionaFedor();
        }
        if (y != 14) {
            campoAtual = mapa[x][y + 1];
            if (campoAtual.isVisivel() && campoAtual.HasTrap() == false)
                campoAtual.adicionaFedor();
        }
    }
    public void removerFedor(Campo[][] mapa) {

        if (x != 0) {
            mapa[x - 1][y].removeFedor();
        }
        if (x != 14) {
            mapa[x + 1][y].removeFedor();
        }
        if (y != 0) {
            mapa[x][y - 1].removeFedor();
        }
        if (y != 14) {
            mapa[x][y + 1].removeFedor();
        }

    }

    public abstract void atacar(Agente e);
    public boolean isAlive() {
        return alive;
    }
    public void kill(String fileDir) {
        alive = false;
        super.reproduzirAudio(fileDir);
    }
}
