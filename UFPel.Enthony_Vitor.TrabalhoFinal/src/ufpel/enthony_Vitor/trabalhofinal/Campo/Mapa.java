package ufpel.enthony_Vitor.trabalhofinal.Campo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ufpel.enthony_Vitor.trabalhofinal.Buraco.Buraco;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Madeira;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Objeto;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Ouro;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Agente;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.NovoMonstro;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Personagem;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Wumpus;

/**
 * @author entho
 */
public class Mapa extends JPanel {
    private Campo[][] campo;
    private Objeto[] objetos;
    private Buraco[] buracos;
    private Personagem[] personagens;
    private GridBagConstraints c;
    private Campo pAtual;
    private Agente agente;
    private Wumpus wumpus;
    private NovoMonstro novoMonstro;

    public Mapa() {
        personagens = new Personagem[] { new Agente(), new Wumpus(), new NovoMonstro() };
        objetos = new Objeto[] { new Madeira(), new Madeira(), new Ouro() };
        buracos = new Buraco[] { new Buraco(), new Buraco(), new Buraco(), new Buraco(), new Buraco()};
        campo = new Campo[15][15];
        c = new GridBagConstraints();

        agente = getAgente();
        wumpus = getWumpus();
        novoMonstro = getNovoMonstro();

        setLayout(new GridBagLayout());
        setVisible(true);
    }

    public void inicializaMapa() {
        // Inicia todas as posições do mapa
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                // Define as características de cada campo do Mapa
                c.gridx = i;
                c.gridy = j;
                c.weightx = 1;
                c.weighty = 1;
                c.fill = GridBagConstraints.BOTH;
                c.insets = new Insets(0, 1, 1, 1);
                pAtual = campo[i][j] = new Campo(i, j);

                // Adiciona o Agente
                if (pAtual.getPosition().samePosition(agente)) {
                    pAtual.deixaVisível();
                    pAtual.adicionaPersonagem(agente);
                    pAtual.add(new JLabel("COMECO"));
                    pAtual.setStart(true);
                }

                // Adiciona ao mapa o campo atual
                add(pAtual, c);
            }
        }

        for  (Buraco buraco : buracos) {
            int x, y;
            buraco.posicaoAleatoria(campo);
            
            x = buraco.getPosition().getX();
            y = buraco.getPosition().getY();

            campo[x][y].adicionaPoco(buraco);
        }

        for (Objeto item : objetos) {
            int x, y;
            item.posicaoAleatoria(campo);

            x = item.getPosition().getX();
            y = item.getPosition().getY();

            campo[x][y].adicionaItem(item);
        }


        // Percorre o mapa denovo adicionando objetos e Brisa
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                pAtual = campo[i][j];

                // Coloca a Brisa nas posições ao redor do poço
                if (pAtual.HasTrap()) {
                    pAtual.getBuraco().gerarBrisa(campo, pAtual.getPosition());
                    continue;
                }


                // Adiciona os monstros
                if (pAtual.getPosition().samePosition(wumpus) && !pAtual.HasTrap()) {
                    pAtual.adicionaPersonagem(wumpus);
                    wumpus.emanarFedor(campo);
                }

                if (pAtual.getPosition().samePosition(novoMonstro) && !pAtual.HasTrap()) {
                    pAtual.adicionaPersonagem(novoMonstro);
                    novoMonstro.emanarFedor(campo);
                }

            }
        }
    }

    public void revelaMapa() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                campo[i][j].deixaVisível();
            }
        }
    }

    // Metodos Especiais
    public Agente getAgente() {
        for (Personagem p : personagens) {
            if (p.getClass().equals(Agente.class))
                return (Agente) p;
        }
        return null;
    }

    public Wumpus getWumpus() {
        for (Personagem p : personagens) {
            if (p.getClass().equals(Wumpus.class))
                return (Wumpus) p;
        }
        return null;
    }

    public NovoMonstro getNovoMonstro() {
        for (Personagem p : personagens) {
            if (p.getClass().equals(NovoMonstro.class))
                return (NovoMonstro) p;
        }
        return null;
    }

    public Campo[][] getCampo() {
        return campo;
    }
}
