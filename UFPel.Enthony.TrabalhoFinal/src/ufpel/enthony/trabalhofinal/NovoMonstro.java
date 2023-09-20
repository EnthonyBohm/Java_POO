package ufpel.enthony.trabalhofinal;

import java.util.Random;

import javax.swing.ImageIcon;

public class NovoMonstro extends Personagem{
    //    Metodos Herdados
    //    int pv
    //    boolean visivel
    //    Posicao position
    
    // Variáveis utilizadas na movimentação do Personagem
    private Random  randomDirection;
    private int     mov1,mov2;

    // Métodos especiais
    public NovoMonstro() {
        super("NovoMonstro", new ImageIcon ("C:\\Users\\entho\\OneDrive\\Documentos\\GitHub\\Java_POO\\UFPel.Enthony.TrabalhoFinal\\src\\ufpel\\enthony\\trabalhofinal\\IconeMonstro2.png"));
        setVisible(false);
        randomDirection = new Random();
    }
    

    public void atacar (Agente e){
        e.setVida(e.getVida() - 50);
        System.out.println("SLASSHHH");
    }

    public void movimenta (Mapa mapa){
        Agente a = mapa.getAgente();
        Posicao p = a.getPosition();
        boolean done = false;
        while (!done){
            mov1 = randomDirection.nextInt(1, 5);
            mov2 = randomDirection.nextInt(0, 2);

            switch(mov1){

                case 1:

                    //Primeiro Passo
                    if (movimentaDireita(mapa) == false) continue;
                    if (position.equals(p))         atacar(a);

                    //Segundo Passo
                    if (movimentaDireita(mapa) == false){
                        movimentaEsquerda(mapa);
                        continue;
                    }
                    if (position.equals(p))         atacar(a);
                    
                    //Terceiro Passo
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
                
                //Primeiro Passo
                if (movimentaEsquerda(mapa) == false ) continue;
                if (position.equals(p))         atacar(a);

                //Segundo Passo
                if (movimentaEsquerda(mapa) == false ){
                    movimentaDireita(mapa);
                    continue;
                }
                if (position.equals(p))         atacar(a);

                //Terceiro Passo
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
                
                //Primeiro Passo
                if (movimentaAcima(mapa) == false) continue;    
                if (position.equals(p))         atacar(a);
                
                //Segundo Passo
                if (movimentaAcima(mapa) == false){
                    movimentaAbaixo(mapa);
                    continue;
                }
                if (position.equals(p))         atacar(a);

                //Terceiro Passo
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
                
                //Primeiro Passo
                if (movimentaAbaixo(mapa) == false) continue;
                if (position.equals(p))         atacar(a);

                //Segundo Passo
                if (movimentaAbaixo(mapa) == false){
                    movimentaAcima(mapa);
                    continue;
                }
                if (position.equals(p))         atacar(a);
                
                //Terceiro Passo
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
    
