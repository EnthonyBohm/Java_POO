package ufpel.enthony.trabalhofinal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author entho
 */
public class  Mapa extends JPanel{
        private     Campo[][]           campo;
        private     Objeto[]            objetos;
        private     Buraco[]            buracos;
        private     Personagem[]        personagens;
        private     GridBagConstraints  c;
        private     Campo               pAtual;
        private     Agente              agente;
        private     Wumpus              wumpus;
        private     NovoMonstro         novoMonstro;

        public Mapa() {
            personagens         =   new Personagem[]{new Agente(), new Wumpus(), new NovoMonstro()};
            objetos             =   new Objeto[]{new Madeira(), new Madeira(), new Ouro()};
            buracos             =   new Buraco[]{new Buraco () , new Buraco(), new Buraco(), new Buraco(), new Buraco()};
            campo               =   new Campo[15][15];
            c                   =   new GridBagConstraints();

            agente              =   getAgente();
            wumpus              =   getWumpus();
            novoMonstro         =   getNovoMonstro();

            setLayout(new GridBagLayout());
            setVisible(true);
        }

        public void  inicializaMapa (){
        //Inicializa o Mapa e todos Recursos que vão ser usados no jogo

        //Percorre Inicialmente colocando os blocos, o Agente e os Poços
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                //Define as características de cada campo do Mapa
                c.gridx = i;
                c.gridy = j;
                c.weightx = 1;
                c.weighty = 1;
                c.fill = GridBagConstraints.BOTH;
                c.insets = new Insets(0,1,1,1);
                pAtual = campo[i][j] = new Campo(i, j);
                        
                
                //Adiciona o Agente
                if(pAtual.samePosition(agente)){
                    pAtual.deixaVisível();
                    pAtual.adicionaPersonagem(agente);
                    pAtual.add(new JLabel("COMECO"));
                    pAtual.setStart(true);
                }

                //Adiciona os Poços
                for (Buraco buraco: buracos){
                    if (pAtual.samePosition(buraco)){
                        while (pAtual.hasCharacter()){
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
                
                // Coloca a Brisa nas posições ao redor do poço
                if ( pAtual.HasTrap() )     
                    pAtual.getBuraco().gerarBrisa(campo, pAtual.getPosition());

                //Adiciona os Itens
                for (Objeto o: objetos){
                    if( pAtual.samePosition(o) && !pAtual.hasItem() ){
                        if (pAtual.HasTrap() && o instanceof Madeira)
                            pAtual.tapaBuraco();
                        else
                            pAtual.adicionaItem(o);
                    }
                }

                //Adiciona os monstros
                if (    pAtual.samePosition(wumpus)         &&      !pAtual.HasTrap()   )
                    pAtual.adicionaPersonagem(wumpus);

                if (    pAtual.samePosition(novoMonstro)    &&      !pAtual.HasTrap()   )
                    pAtual.adicionaPersonagem(novoMonstro);

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
}
