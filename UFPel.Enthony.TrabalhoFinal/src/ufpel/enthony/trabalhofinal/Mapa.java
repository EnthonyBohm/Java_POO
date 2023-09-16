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
        personagens = new Personagem[]{new Agente(), new Wumpus(), new NovoMonstro()};
        objetos = new Objeto[]{new Madeira(), new Madeira()};
        buracos = new Buraco[]{new Buraco () , new Buraco(), new Buraco(), new Buraco(), new Buraco()};
        campo = new Campo[15][15];
        Campo pAtual;
        c       = new GridBagConstraints();
        Agente agente  = getAgente();
        
        setLayout(new GridBagLayout());
        setVisible(true);
        
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                c.gridx = i;
                c.gridy = j;
                c.weightx = 10;
                c.weighty = 10;
                c.fill = GridBagConstraints.BOTH;
                c.insets = new Insets(0,1,1,1);
                pAtual = campo[i][j] = new Campo(i, j);
                        
                
                if(pAtual.getPosition().equals(agente.getPosition())){
                    pAtual.deixaVisível();
                    add(agente);
                }

                for (Buraco buraco: buracos){
                    if (buraco.getPosition().equals(pAtual.getPosition()))
                        pAtual.add(buraco);
                }
                
                add(pAtual, c);

            }
        }
        return;
    }

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

        public void revelaMapa()  {
            for (int i = 0; i < 15; i++){
                for (int j = 0; j < 15; j++){
                    //
                }
            }
        }
}
