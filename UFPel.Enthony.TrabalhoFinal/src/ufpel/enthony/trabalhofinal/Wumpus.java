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
    public void movimenta(Mapa mapa, Posicao pAtual) {

        boolean done = false;
        Campo[][] campo = mapa.getCampo();
        
        super.removerFedor(campo, pAtual);
        while (!done){
            movimento = randDirection.nextInt(1, 5);
            switch (movimento){
                case 1:
                    done = movimentaDireita(campo);
                    break;
                case 2:
                    done = movimentaEsquerda(campo);
                    break;
                case 3:
                    done = movimentaAcima(campo);
                    break;
                case 4:
                    done = movimentaAbaixo(campo);
                    break;
            }
        }
        super.emanarFedor(campo, pAtual);
    }

}
