package ufpel.enthony.trabalhofinal;

import java.util.Random;

import javax.swing.ImageIcon;

public class NovoMonstro extends Personagem{
    //    Metodos Herdados
    //    int pv
    //    boolean visivel
    //    Posicao position
    private Random  rand;
    private int     mov1,mov2;

    // Métodos especiais
    public NovoMonstro() {
        super("NovoMonstro", new ImageIcon ("IconeMonstro2.png"));
        super.aleatorizaPosicao();
        rand = new Random();
    }
    

    public void atacar (Agente e){
        e.setVida(e.getVida() - 50);
    }

    public void movimenta (Mapa mapa){
        //Agente a = mapa.getAgente();
        boolean done = false;
        while (!done){
            mov1 = rand.nextInt(1, 5);
            mov2 = rand.nextInt(0, 2);

            switch(mov1){

                case 1:

                    if (movimentaDireita(mapa) == false) continue;
                    if (movimentaDireita(mapa) == false){
                        movimentaEsquerda(mapa);
                        continue;
                    }
                    if (mov2 == 0){
                        done = movimentaAcima(mapa) ; if (done) break;
                        done = movimentaAbaixo(mapa); if (done) break;
                    } else{
                        done = movimentaAbaixo(mapa); if (done) break;
                        done = movimentaAcima(mapa) ; if (done) break;
                    }
                    movimentaEsquerda(mapa);    
                    movimentaEsquerda(mapa);
                    break;
                
            case 2:

                if (movimentaEsquerda(mapa) == false ) continue;
                if (movimentaEsquerda(mapa) == false ){
                    movimentaDireita(mapa);
                    continue;
                }
                if (mov2 == 0){
                    done = movimentaAcima(mapa) ; if (done) break;
                    done = movimentaAbaixo(mapa); if (done) break;
                } else{
                    done = movimentaAbaixo(mapa); if (done) break;
                    done = movimentaAcima(mapa) ; if (done) break;
                }
                movimentaDireita(mapa);    
                movimentaDireita(mapa);
                break;

            case 3:

                if (movimentaAcima(mapa) == false) continue;
                if (movimentaAcima(mapa) == false){
                    movimentaAbaixo(mapa);
                    continue;
                }
                if (mov2 == 0){
                    done = movimentaDireita(mapa) ; if (done) break;
                    done = movimentaEsquerda(mapa); if (done) break;
                } else{
                    done = movimentaDireita(mapa); if (done) break;
                    done = movimentaEsquerda(mapa) ; if (done) break;
                }
                movimentaAbaixo(mapa);
                movimentaAbaixo(mapa);
                break;

            case 4:
                if (movimentaAbaixo(mapa) == false) continue;
                if (movimentaAbaixo(mapa) == false){
                    movimentaAcima(mapa);
                    continue;
                }
                
                if (mov2 == 0){
                    done = movimentaDireita(mapa) ; if (done) break;
                    done = movimentaEsquerda(mapa); if (done) break;
                } else{
                    done = movimentaDireita(mapa); if (done) break;
                    done = movimentaEsquerda(mapa) ; if (done) break;
                }
                movimentaAcima(mapa);
                movimentaAcima(mapa);
        
                break;

            }        
        }
    }
}
    
