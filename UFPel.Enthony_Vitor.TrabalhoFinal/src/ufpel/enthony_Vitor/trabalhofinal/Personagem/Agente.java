
package ufpel.enthony_Vitor.trabalhofinal.Personagem;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import ufpel.enthony_Vitor.trabalhofinal.Campo.Campo;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Flecha;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Madeira;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Objeto;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Ouro;
import ufpel.enthony_Vitor.trabalhofinal.Posicao.Posicao;

public class Agente extends Personagem {
    private ArrayList<Objeto> itens;
    private int bateriaLanterna;
    private boolean hasGold;

    public Agente() {
        super("Agente", new ImageIcon(
                "src/ufpel/enthony_Vitor/trabalhofinal/Icones/Agente.png"));
        super.setPosition(new Posicao(0, 14));
        x = 0;
        y = 14;

        bateriaLanterna = 100;
        itens = new ArrayList<>();

        setVisible(true);
    }

    public void pegarItem(Campo pAtual) {
        if (pAtual.hasItem() && itens.size() < 3) {
            Objeto item = pAtual.getItem();
            pAtual.removeItem();
            itens.add(item);

            if (item instanceof Ouro)
                hasGold = true;
        }

    }

    public void removerItem(Objeto item) {
        itens.remove(item);
    }

    public void usaLanterna(int direction, Campo[][] mapa) {
        if (bateriaLanterna == 0)
            return;
        int i;

        if (bateriaLanterna > 0) {
            switch (direction) {
                case 1:
                    for (i = x; i < 15; i++)
                        mapa[i][y].deixaVisível();
                    break;
                case 2:
                    for (i = x; i >= 0; i--)
                        mapa[i][y].deixaVisível();
                    break;
                case 3:
                    for (i = y; i >= 0; i--)
                        mapa[x][i].deixaVisível();
                    break;
                case 4:
                    for (i = y; i < 15; i++)
                        mapa[x][i].deixaVisível();
                    break;
            }
        }
        bateriaLanterna -= 50;
    }

    public boolean tapaBuraco(int direction, Campo[][] mapa) {
        boolean sucessful = false;

        switch (direction) {
            case DIREITA:
                if (mapa[x + 1][y].HasTrap()) {
                    mapa[x + 1][y].tapaBuraco(mapa);
                    sucessful = true;
                }
                break;
            case ESQUERDA:
                if (mapa[x - 1][y].HasTrap()) {
                    mapa[x - 1][y].tapaBuraco(mapa);
                    sucessful = true;
                }
                break;
            case CIMA:
                if (mapa[x][y - 1].HasTrap()) {
                    mapa[x][y - 1].tapaBuraco(mapa);
                    sucessful = true;
                }
                break;
            case BAIXO:
                if (mapa[x][y + 1].HasTrap()) {
                    mapa[x][y + 1].tapaBuraco(mapa);
                    sucessful = true;
                }
                break;
        }

        if (!sucessful) {
            return false;
        }

        Iterator<Objeto> iterador = itens.iterator();
        while (iterador.hasNext()) {
            Objeto item = iterador.next();
            if (item instanceof Madeira) {
                iterador.remove();
            }
        }

        return true;
    }

    public boolean movimenta(Campo[][] mapa, int movimento) {
        Campo pAtual, pProx;

        pAtual = mapa[x][y];

        if (movimenta(movimento) == false)
            return false;

        x = position.getX();
        y = position.getY();
        pProx = mapa[x][y];

        if (pProx.HasTrap()) {
            vida = 0;
            reproduzirAudio("src/ufpel/enthony_Vitor/trabalhofinal/Personagem/Sons/CairPoço.wav");
        }

        pAtual.removePersonagem(this);
        if (pProx.isVisivel() == false)
            pProx.deixaVisível();
        pProx.adicionaPersonagem(this);

        reproduzirAudio("src/ufpel/enthony_Vitor/trabalhofinal/Personagem/Sons/Passo.wav");

        return true;
    }

    public boolean atirarFlecha(Campo[][] mapa, int movimento) {
        Campo pAtual = null;
        switch (movimento) {
            case 1:
                pAtual = mapa[x + 1][y];
                break;
            case 2:
                pAtual = mapa[x - 1][y];
                break;
            case 3:
                pAtual = mapa[x][y - 1];
                break;
            case 4:
                pAtual = mapa[x][y + 1];
                break;
            default:
                return false;
        }

        if (pAtual == null)
            return false;
        if (pAtual.hasCharacter() == false)
            return false;
        for (Personagem p : pAtual.getPersonagens()) {
            p.setVida(0);
            if (p instanceof Wumpus)
                ((Wumpus)p).kill();
            else
                ((NovoMonstro)p).kill();
            ((Monstro) p).removerFedor(mapa);
            pAtual.removePersonagem(p);
            break;
        }
        return true;
    }

    public void criaFlecha() {
        for (Objeto item : itens) {
            if (item instanceof Madeira) {
                itens.remove(item);
                itens.add(new Flecha());
                return;
            }
        }
    }

    // Métodos Especiais
    public ArrayList<Objeto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Objeto> itens) {
        this.itens = itens;
    }

    public int getBateriaLanterna() {
        return bateriaLanterna;
    }

    public boolean hasGold() {
        return hasGold;
    }

}
