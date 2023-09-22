package ufpel.enthony.trabalhofinal;

import java.util.Random;

import javax.swing.ImageIcon;

public class NovoMonstro extends Monstro{
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

    @Override
    public void movimenta(Mapa mapa, Posicao pAtual) {
        Agente a = mapa.getAgente();
        Posicao pAgente = a.getPosition();
        Campo[][] campo = mapa.getCampo();
        boolean done = false;

        super.removerFedor(campo, pAtual);
        while (!done){
            mov1 = randomDirection.nextInt(1, 5);
            mov2 = randomDirection.nextInt(0, 2);
            switch(mov1){

                case 1:

                    //Primeiro Passo
                    if (movimentaDireita(campo) == false) continue;
                    if (position.equals(pAgente))         atacar(a);

                    //Segundo Passo
                    if (movimentaDireita(campo) == false){
                        movimentaEsquerda(campo);
                        continue;
                    }
                    if (position.equals(pAgente))         atacar(a);
                    
                    //Terceiro Passo
                    if (mov2 == 0){
                        done = movimentaAcima(campo) ; if (done) break;
                        done = movimentaAbaixo(campo); if (done) break;
                    } else{
                        done = movimentaAbaixo(campo); if (done) break;
                        done = movimentaAcima(campo) ; if (done) break;
                    }
                    movimentaEsquerda(campo);    
                    movimentaEsquerda(campo);
                    break;
                
            case 2:
                
                //Primeiro Passo
                if (movimentaEsquerda(campo) == false ) continue;
                if (position.equals(pAgente))         atacar(a);

                //Segundo Passo
                if (movimentaEsquerda(campo) == false ){
                    movimentaDireita(campo);
                    continue;
                }
                if (position.equals(pAgente))         atacar(a);

                //Terceiro Passo
                if (mov2 == 0){
                    done = movimentaAcima(campo) ; if (done) break;
                    done = movimentaAbaixo(campo); if (done) break;
                } else{
                    done = movimentaAbaixo(campo); if (done) break;
                    done = movimentaAcima(campo) ; if (done) break;
                }
                movimentaDireita(campo);    
                movimentaDireita(campo);
                break;

            case 3:
                
                //Primeiro Passo
                if (movimentaAcima(campo) == false) continue;    
                if (position.equals(pAgente))         atacar(a);
                
                //Segundo Passo
                if (movimentaAcima(campo) == false){
                    movimentaAbaixo(campo);
                    continue;
                }
                if (position.equals(pAgente))         atacar(a);

                //Terceiro Passo
                if (mov2 == 0){
                    done = movimentaDireita(campo) ; if (done) break;
                    done = movimentaEsquerda(campo); if (done) break;
                } else{
                    done = movimentaDireita(campo); if (done) break;
                    done = movimentaEsquerda(campo) ; if (done) break;
                }
                movimentaAbaixo(campo);
                movimentaAbaixo(campo);
                break;

            case 4:
                
                //Primeiro Passo
                if (movimentaAbaixo(campo) == false) continue;
                if (position.equals(pAgente))         atacar(a);

                //Segundo Passo
                if (movimentaAbaixo(campo) == false){
                    movimentaAcima(campo);
                    continue;
                }
                if (position.equals(pAgente))         atacar(a);
                
                //Terceiro Passo
                if (mov2 == 0){
                    done = movimentaDireita(campo) ; if (done) break;
                    done = movimentaEsquerda(campo); if (done) break;
                } else{
                    done = movimentaDireita(campo); if (done) break;
                    done = movimentaEsquerda(campo) ; if (done) break;
                }
                movimentaAcima(campo);
                movimentaAcima(campo);
        
                break;

            }        
        }
        super.emanarFedor(campo, pAtual);
    }
}
    
