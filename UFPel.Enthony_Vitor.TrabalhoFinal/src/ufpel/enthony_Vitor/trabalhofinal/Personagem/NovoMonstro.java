package ufpel.enthony_Vitor.trabalhofinal.Personagem;

import java.util.Random;

import javax.swing.ImageIcon;

import ufpel.enthony_Vitor.trabalhofinal.Campo.Campo;
import ufpel.enthony_Vitor.trabalhofinal.Posicao.Posicao;

// Corrigir agente movimentação

public class NovoMonstro extends Monstro {
    // Variáveis utilizadas na movimentação do Personagem
    private Random randomDirection;
    private int mov1, mov2;

    // Métodos especiais
    public NovoMonstro() {
        super("NovoMonstro", new ImageIcon(
                "src/ufpel/enthony_Vitor/trabalhofinal/Icones/IconeMonstro2.png"));
        setVisible(false);
        randomDirection = new Random();
    }

    public void atacar(Agente e) {
        e.setVida(e.getVida() - 50);
        System.out.println("SLASH");
    }

    public void movimenta(Campo[][] mapa, Agente agente) {
        Campo atual, prox;
            boolean done = false;

        atual = mapa[x][y];
        super.removerFedor(mapa);
        int vidaAg = agente.getVida();

        while (!done) {
            mov1 = randomDirection.nextInt(1, 5);
            mov2 = randomDirection.nextInt(0, 2);
            agente.setVida(vidaAg);
            switch (mov1) {

                case DIREITA:

                    // Primeiro Passo
                    if (movimenta(mapa, DIREITA) == false)
                        continue;
                    if (position.samePosition(agente))
                        atacar(agente);

                    // Segundo Passo
                    if (movimenta(mapa, DIREITA) == false) {
                        movimenta(mapa, ESQUERDA);
                        continue;
                    }
                    if (position.samePosition(agente))
                        atacar(agente);

                    // Terceiro Passo
                    if (mov2 == 0) {
                        done = movimenta(mapa, CIMA);
                        if (done)
                            break;
                        done = movimenta(mapa, BAIXO);
                        if (done)
                            break;
                    } else {
                        done = movimenta(mapa, BAIXO);
                        if (done)
                            break;
                        done = movimenta(mapa, CIMA);
                        if (done)
                            break;
                    }
                    movimenta(mapa, ESQUERDA);
                    movimenta(mapa, ESQUERDA);
                    break;

                case ESQUERDA:

                    // Primeiro Passo
                    if (movimenta(mapa, ESQUERDA) == false)
                        continue;
                    if (position.samePosition(agente))
                        atacar(agente);

                    // Segundo Passo
                    if (movimenta(mapa, ESQUERDA) == false) {
                        movimenta(mapa, DIREITA);
                        continue;
                    }
                    if (position.samePosition(agente))
                        atacar(agente);

                    // Terceiro Passo
                    if (mov2 == 0) {
                        done = movimenta(mapa, CIMA);
                        if (done)
                            break;
                        done = movimenta(mapa, BAIXO);
                        if (done)
                            break;
                    } else {
                        done = movimenta(mapa, BAIXO);
                        if (done)
                            break;
                        done = movimenta(mapa, CIMA);
                        if (done)
                            break;
                    }
                    movimenta(mapa, DIREITA);
                    movimenta(mapa, DIREITA);
                    break;

                case CIMA:

                    // Primeiro Passo
                    if (movimenta(mapa, CIMA) == false)
                        continue;
                    if (position.samePosition(agente))
                        atacar(agente);

                    // Segundo Passo
                    if (movimenta(mapa, CIMA) == false) {
                        movimenta(mapa, BAIXO);
                        continue;
                    }
                    if (position.samePosition(agente))
                        atacar(agente);

                    // Terceiro Passo
                    if (mov2 == 0) {
                        done = movimenta(mapa, DIREITA);
                        if (done)
                            break;
                        done = movimenta(mapa, ESQUERDA);
                        if (done)
                            break;
                    } else {
                        done = movimenta(mapa, ESQUERDA);
                        if (done)
                            break;
                        done = movimenta(mapa, DIREITA);
                        if (done)
                            break;
                    }
                    movimenta(mapa, BAIXO);
                    movimenta(mapa, BAIXO);
                    break;

                case BAIXO:

                    // Primeiro Passo
                    if (movimenta(mapa, BAIXO) == false)
                        continue;
                    if (position.samePosition(agente))
                        atacar(agente);

                    // Segundo Passo
                    if (movimenta(mapa, BAIXO) == false) {
                        movimenta(mapa, CIMA);
                        continue;
                    }
                    if (position.samePosition(agente))
                        atacar(agente);

                    // Terceiro Passo
                    if (mov2 == 0) {
                        done = movimenta(mapa, ESQUERDA);
                        if (done)
                            break;
                        done = movimenta(mapa, DIREITA);
                        if (done)
                            break;
                    } else {
                        done = movimenta(mapa, DIREITA);
                        if (done)
                            break;
                        done = movimenta(mapa, ESQUERDA);
                        if (done)
                            break;
                    }
                    movimenta(mapa, CIMA);
                    movimenta(mapa, CIMA);

                    break;
            }
            if (position.samePosition(agente))
                atacar(agente);
        }

        super.emanarFedor(mapa);
        prox = mapa[x][y];

        // Modifica o Personagem no mapa
        atual.removePersonagem(this);
        if (prox.isVisivel() == false) {
            setVisible(false);
            prox.adicionaPersonagem(this);
        } else {
            setVisible(true);
            prox.adicionaPersonagem(this);
        }

        // Verifica se está na mesma posição do Agente
        if (position.samePosition(agente))
            atacar(agente);

    }

    public boolean movimenta(Campo[][] campo, int movimento) {
        boolean done = false;
        Posicao atual;

        atual = position;

        switch (movimento) {
            case DIREITA:
                done = position.moveDireita();
                break;
            case ESQUERDA:
                done = position.moveEsquerda();
                break;
            case CIMA:
                done = position.moveAcima();
                break;
            case BAIXO:
                done = position.moveAbaixo();
                break;
        }
        x = position.getX();
        y = position.getY();
        if (done) {
            if (campo[x][y].HasTrap()) {
                x = atual.getX();
                y = atual.getY();
                position = atual;
                done = false;
            }
        }
        return done;
    }

    public void kill (){
        super.kill("src/ufpel/enthony_Vitor/trabalhofinal/Personagem/Sons/NovoMonstroMorto.wav");
    }
}
