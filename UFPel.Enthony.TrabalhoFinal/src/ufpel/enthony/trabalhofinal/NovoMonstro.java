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
    public void movimentar(Mapa mapa, Posicao pAtual) {
        Agente a = mapa.getAgente();
        Posicao pAgente = a.getPosition();
        Campo   atual, prox;
        Campo[][] campo = mapa.getCampo();
        boolean done = false;

        atual = campo[position.getX()][position.getY()];
        super.removerFedor(campo, pAtual);
        while (!done){
            mov1 = randomDirection.nextInt(1, 5);
            mov2 = randomDirection.nextInt(0, 2);
            switch(mov1){

                case DIREITA:

                    //Primeiro Passo
                    if (movimenta(campo, DIREITA) == false) continue;
                    if (position.equals(pAgente))         atacar(a);

                    //Segundo Passo
                    if (movimenta(campo, DIREITA) == false){
                        movimenta(campo, ESQUERDA);
                        continue;
                    }
                    if (position.equals(pAgente))         atacar(a);
                    
                    //Terceiro Passo
                    if (mov2 == 0){
                        done = movimenta(campo, CIMA) ; if (done) break;
                        done = movimenta(campo, BAIXO); if (done) break;
                    } else{
                        done = movimenta(campo, BAIXO); if (done) break;
                        done = movimenta(campo, CIMA) ; if (done) break;
                    }
                    movimenta(campo, ESQUERDA);
                    movimenta(campo, ESQUERDA);
                    break;
                
            case ESQUERDA:
                
                //Primeiro Passo
                if (movimenta(campo, ESQUERDA) == false ) continue;
                if (position.equals(pAgente))         atacar(a);

                //Segundo Passo
                if (movimenta(campo, ESQUERDA) == false ){
                    movimenta(campo, DIREITA);
                    continue;
                }
                if (position.equals(pAgente))         atacar(a);

                //Terceiro Passo
                if (mov2 == 0){
                    done = movimenta(campo, CIMA) ; if (done) break;
                    done = movimenta(campo, BAIXO);if (done) break;
                } else{
                    done = movimenta(campo, BAIXO); if (done) break;
                    done = movimenta(campo, CIMA) ; if (done) break;
                }
                movimenta(campo, DIREITA);    
                movimenta(campo, DIREITA);
                break;

            case 3:
                
                //Primeiro Passo
                if (movimenta(campo, CIMA) == false) continue;    
                if (position.equals(pAgente))         atacar(a);
                
                //Segundo Passo
                if (movimenta(campo, CIMA) == false){
                    movimenta(campo, BAIXO);
                    continue;
                }
                if (position.equals(pAgente))         atacar(a);

                //Terceiro Passo
                if (mov2 == 0){
                    done = movimenta(campo, DIREITA) ; if (done) break;
                    done = movimenta(campo, ESQUERDA); if (done) break;
                } else{
                    done = movimenta(campo, ESQUERDA); if (done) break;
                    done = movimenta(campo, DIREITA) ; if (done) break;
                }
                movimenta(campo, BAIXO);
                movimenta(campo, BAIXO);
                break;

            case 4:
                
                //Primeiro Passo
                if (movimenta(campo, BAIXO) == false) continue;
                if (position.equals(pAgente))         atacar(a);

                //Segundo Passo
                if (movimenta(campo, BAIXO) == false){
                    movimenta(campo, CIMA);
                    continue;
                }
                if (position.equals(pAgente))         atacar(a);
                
                //Terceiro Passo
                if (mov2 == 0){
                    done = movimenta(campo, ESQUERDA); if (done) break;
                    done = movimenta(campo, DIREITA); if (done) break;
                } else{
                    done = movimenta(campo, DIREITA); if (done) break;
                    done = movimenta(campo, ESQUERDA) ; if (done) break;
                }
                movimenta(campo, CIMA);
                movimenta(campo, CIMA);
        
                break;

            }        
        }
        super.emanarFedor(campo, pAtual);
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

    public boolean movimenta (Campo[][] campo, int movimento) {
        boolean done = false;
        Posicao atual, prox;

        atual = position;

        switch (movimento){
            case DIREITA:         
                done = position.moveDireita();
                break;
            case ESQUERDA:         
                done = position.moveEsquerda() ;
                break;  
            case CIMA:         
                done = position.moveAcima() ;
                break;
            case BAIXO:         
                done = position.moveAbaixo();
                break;
        }

        if (done){
            if ( campo[position.getX()][position.getY()].HasTrap()){
                position = atual;
                done = false;
            }
        }
        return done;
    }
}
    
