package ufpel.enthony.trabalhofinal;

import java.util.Random;

import javax.swing.ImageIcon;

public class Wumpus extends Monstro {
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


    @Override
    public void atacar(Agente e) {
        e.setVida(0);
    }

    @Override
    public void movimentar(Mapa mapa, Posicao pAtual) {

        boolean done = false;
        Campo[][] campo = mapa.getCampo();
        Campo   atual, prox;
        
        atual = campo[position.getX()][position.getY()];
        super.removerFedor(campo, position);
        while (!done){
            movimento = randDirection.nextInt(1, 5);
            switch (movimento){
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
            if (done){
                if ( campo[position.getX()][position.getY()].HasTrap()){
                    position = atual.getPosition();
                    done = false;
                }
            }
            
        }
        super.emanarFedor(campo, position);
        prox = campo[position.getX()][position.getY()];
        
        atual.removePersonagem(this);
        if (prox.isVisivel()==false){
            setVisible(false);
            prox.adicionaPersonagem(this);
        }else{
            setVisible(true);
            prox.adicionaPersonagem(this);
        }
    }

}
