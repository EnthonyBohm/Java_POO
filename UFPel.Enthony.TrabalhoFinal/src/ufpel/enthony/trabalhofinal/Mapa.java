package ufpel.enthony.trabalhofinal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 * @author entho
 */
public class  Mapa extends JPanel{
        Campo[][] campo;
        Objeto[] objetos;
        Buraco[] buracos;
        Personagem[] personagens;
        GridBagConstraints c;

        public void  inicializaMapa (){
        //Inicializa o Mapa e todos Recursos que vão ser usados no jogo
        personagens = new Personagem[]{new Agente(), new Wumpus(), new NovoMonstro()};
        objetos = new Objeto[]{new Madeira(), new Madeira()};
        buracos = new Buraco[]{new Buraco () , new Buraco(), new Buraco(), new Buraco(), new Buraco()};
        campo = new Campo[15][15];
        Campo pAtual;
        c       = new GridBagConstraints();
        Agente agente  = getAgente();
        Wumpus wumpus = getWumpus();
        NovoMonstro novoMonstro = getNovoMonstro();
        
        setLayout(new GridBagLayout());
        setVisible(true);
        
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                //Define as características de cada campo do Mapa
                c.gridx = i;
                c.gridy = j;
                c.weightx = 10;
                c.weighty = 10;
                c.fill = GridBagConstraints.BOTH;
                c.insets = new Insets(0,1,1,1);
                pAtual = campo[i][j] = new Campo(i, j);
                        
                
                //Adiciona o Agente
                if(pAtual.getPosition().equals(agente.getPosition())){
                    pAtual.deixaVisível();
                    pAtual.adicionaPersonagem(agente);
                }

                //Adiciona os Buracos
                for (Buraco buraco: buracos){
                    if (buraco.getPosition().equals(pAtual.getPosition())){
                        while (pAtual.isHasCharacter()){
                            buraco = new Buraco();
                        }
                        pAtual.adicionaPoco(buraco);
                    }
                        
                }
                
                add(pAtual, c);

            }
        }
        
        for(int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                pAtual = campo[i][j];
                
                if (pAtual.HasTrap())     setBreeze(pAtual);

                //Adiciona os Itens
                for (Objeto o: objetos){

                    if(o.position.equals(pAtual.getPosition())){
                        if(pAtual.isHasTrap() ){
                            if ( o.getClass().equals(Madeira.class) )
                                pAtual.tapaBuraco(pAtual.getBuraco());
                        } else
                            pAtual.adicionaItem(o);
                    }
                    
                }

                if ( !(pAtual.HasTrap()) && wumpus.getPosition().equals(pAtual.getPosition())){
                    pAtual.adicionaPersonagem(wumpus);
                    System.out.printf("Wumpus adicionado na Posição [%d,%d] \n",pAtual.getPosition().getX(), pAtual.getPosition().getY());
                }
                    
                if ( !(pAtual.HasTrap()) && novoMonstro.getPosition().equals(pAtual.getPosition())){
                    pAtual.adicionaPersonagem(novoMonstro);
                    System.out.printf("NovoMonstro adicionado na Posição [%d,%d] \n",pAtual.getPosition().getX(), pAtual.getPosition().getY());
                }
                    

            }
        }
    }

    public void revelaMapa()  {
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                campo[i][j].deixaVisível();
            }
        }
    }

    // Metodos Especiais
    public Agente getAgente (){
        for(Personagem p: personagens){
            if(p.getClass().equals(Agente.class))
                return (Agente) p;
        }
        return null;
    }
    public Wumpus getWumpus () {
        for(Personagem p: personagens){
            if(p.getClass().equals(Wumpus.class))
                return (Wumpus) p;
        }
        return null;
    }
    public NovoMonstro getNovoMonstro() {
        for(Personagem p: personagens){
            if(p.getClass().equals(NovoMonstro.class))
                return (NovoMonstro) p;
        }
        return null;
    }
    public Campo[][] getCampo () {
        return campo;
    }

    public void setBreeze(Campo pAtual){
        int x, y;
        x = pAtual.getPosition().getX();
        y = pAtual.getPosition().getY();

        if ( x != 0)    campo[x-1][y].setHasBreeze(true);
        if ( x != 14)   campo[x+1][y].setHasBreeze(true);
        if ( y != 0)    campo[x][y-1].setHasBreeze(true);
        if ( y != 14)   campo[x][y+1].setHasBreeze(true);
        
    }
}
