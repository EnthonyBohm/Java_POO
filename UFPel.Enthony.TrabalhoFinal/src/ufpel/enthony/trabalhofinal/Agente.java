
package ufpel.enthony.trabalhofinal;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Agente extends Personagem {
    // Metodos Herdados
    // int pv
    // boolean visivel
    // Posicao position
    private     ArrayList<Objeto>   itens;
    private     int                 bateriaLanterna;
    private     boolean             hasGold;
    private     int                 x, y;

    ImageIcon icone;

    public Agente() {
        super("Agente", new ImageIcon( "C:\\Users\\entho\\OneDrive\\Documentos\\GitHub\\Java_POO\\UFPel.Enthony.TrabalhoFinal\\src\\IconeAgente.png"));
        super.setPosition(new Posicao(0, 14));
        x = 0;
        y = 14;

        bateriaLanterna = 100;
        itens = new ArrayList<>();

        setVisible(true);
    }

    public boolean adicionaItem (Objeto item){
        if (itens.size() == 3)
            return false;
        itens.add(item);
        return true;
    }

    public void pegarItem (Campo pAtual){
        if (pAtual.hasItem()){
            Objeto item = pAtual.getItem();
            if (item instanceof Ouro)
                hasGold = true;

            itens.add(item);
            pAtual.removeItem();
        }
        
    }
    public void removerItem (Objeto item){
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
                if (mapa[x+1][y].HasTrap()){
                    mapa[x+1][y].tapaBuraco(mapa);
                    sucessful = true;
                }
                break;
            case ESQUERDA:
                if (mapa[x-1][y].HasTrap()){
                    mapa[x-1][y].tapaBuraco(mapa);
                    sucessful = true;
                }
                break;
            case CIMA:
                if (mapa[x][y-1].HasTrap()){
                    mapa[x][y-1].tapaBuraco(mapa);
                    sucessful = true;
                }
                break;
            case BAIXO:
                if (mapa[x][y+1].HasTrap()){
                    mapa[x][y+1].tapaBuraco(mapa);
                    sucessful = true;
                }
                break;
         }

         if (!sucessful){
            return false;
         }

         Iterator<Objeto> iterador = itens.iterator();
         while (iterador.hasNext()){
            Objeto item = iterador.next();
            if(item instanceof Madeira){
                iterador.remove();
            }
         }

        return true;
    }

    public boolean movimentar (Campo[][] mapa, int movimento){
        Campo pAtual, pProx;

        pAtual = mapa[x][y]; 

        if (movimenta(movimento) == false)
            return false;

        x = position.getX();
        y = position.getY();
        pProx = mapa[x][y];

        if (pProx.HasTrap()){
                vida = 0;
        } 
        
        pAtual.removePersonagem(this);
        if (pProx.isVisivel() == false)
            pProx.deixaVisível();
        pProx.adicionaPersonagem(this);
        
        return true;
    }

    public boolean atirarFlecha(Campo[][] mapa, int movimento){
        Campo pAtual = null;
        switch(movimento){
            case 1:
                pAtual = mapa[x+1][y];
                break;
            case 2:
                pAtual = mapa[x-1][y];
                break;
            case 3:
                pAtual = mapa[x][y-1];
                break;
            case 4:
                pAtual = mapa[x][y+1];
                break;
            default:
                return false;
        }

        if (pAtual == null)
            return false;
        for (Personagem p : pAtual.getPersonagens()){
            p.setVida(0);
            ((Monstro)p).kill();
            pAtual.removePersonagem(p);
            break;
        }
        return true;
    }
    public void criaFlecha(){
        for (Objeto item : itens){
            if (item instanceof Madeira){
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

    public boolean hasGold(){
        return hasGold;
    }
    
}
