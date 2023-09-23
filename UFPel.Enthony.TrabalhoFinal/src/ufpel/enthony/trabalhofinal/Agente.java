
package ufpel.enthony.trabalhofinal;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Agente extends Personagem {
    // Metodos Herdados
    // int pv
    // boolean visivel
    // Posicao position
    private     ArrayList<Objeto>   itens;
    private     int                 bateriaLanterna;
    private     boolean             hasGold;

    ImageIcon icone;

    public Agente() {
        super("Agente", new ImageIcon( "C:\\Users\\entho\\OneDrive\\Documentos\\GitHub\\Java_POO\\UFPel.Enthony.TrabalhoFinal\\src\\IconeAgente.png"));
        super.setPosition(new Posicao(0, 14));

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

    public void usaLanterna(int direction, Campo[][] mapa, Posicao pAtual) {
        if (bateriaLanterna == 0)
            return;
        int x, y, i;
        x = pAtual.getX();
        y = pAtual.getY();

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

    public boolean movimentar (Campo[][] mapa, int movimento){
        Campo pAtual, pProx;
        int x, y;
        x = position.getX();
        y = position.getY();

        pAtual = mapa[x][y]; 

        if (movimenta(movimento) == false)
            return false;

        x = position.getX();
        y = position.getY();
        pProx = mapa[x][y];

        if (pProx.HasTrap()){
            boolean hasWood = false;
            for(Objeto o : itens) {
                if (o instanceof Madeira){
                    hasWood = true;
                    pProx.tapaBuraco();
                    itens.remove(o);
                }    
            }
            if (!hasWood){
                System.out.println("Você morreu");
                vida = 0;
            }
        } 
        
        pAtual.removePersonagem(this);
        if (pProx.isVisivel() == false)
            pProx.deixaVisível();
        pProx.adicionaPersonagem(this);
        
        return true;
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
