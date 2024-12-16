package ufpel.enthony_Vitor.trabalhofinal.Campo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ufpel.enthony_Vitor.trabalhofinal.Buraco.Buraco;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Objeto;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Agente;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Monstro;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Personagem;
import ufpel.enthony_Vitor.trabalhofinal.Posicao.Posicao;

/**
 * @author entho
 */
public class Campo extends JPanel {
    private Set<Personagem> personagens;
    private Objeto item;
    private Posicao position;
    private boolean visivel;
    private boolean hasItem, hasCharacter, hasTrap;
    private boolean stinky, hasBreeze, hasShine, isStart;
    private GridBagConstraints c;
    private Buraco poco;
    private JPanel painel, mensagens;
    private JLabel fedor, brisa;

    public Campo(int x, int y) {
        // Inicializa as variáveis
        c = new GridBagConstraints();
        painel = new JPanel();
        personagens = new HashSet<>();
        position = new Posicao(x, y);
        mensagens = new JPanel(new GridBagLayout());

        // Inicializa as informações do Campo
        setPreferredSize(new Dimension(1, 1));
        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);
        setVisible(true);

        // Inicializa as informações do painel (conteúdo do campo)
        painel.setLayout(new GridBagLayout());
        painel.setPreferredSize(new Dimension(45, 45));
        painel.setBackground(null);
        painel.setVisible(true);
        add(painel);

        // Inicializa Informações do JPanel mensagens
        mensagens.setBackground(null);
        painel.add(mensagens);

    }

    public void deixaVisível() {
        // Define a cor da posição Visível como Cinza
        setBackground(Color.LIGHT_GRAY);
        visivel = true;

        // Adiciona os Personagens que estavam no Quadro mas não estavam Visíveis
        if (hasCharacter) {
            for (Personagem p : personagens) {
                painel.add(p);
                p.setVisible(true);
            }
        }

        if (hasItem) {
            item.setVisible(true);
        }

        // Coloca o poço como um buraco escuro
        if (hasTrap) {
            setBackground(Color.BLACK);
            poco.setVisible(true);
            poco.getLabel().setVisible(true);
        }

        // Adiciona Mensagem de brisa
        if (hasBreeze) {
            adicionaBrisa();
        }
        if (stinky)
            adicionaFedor();
    }

    public void adicionaItem(Objeto o) {
        hasItem = true;
        item = o;
        o.setVisible(false);
        painel.add(o);
    }

    public Objeto getItem() {
        return item;
    }

    public void removeItem() {
        if (hasItem) {
            hasItem = false;
            painel.remove(item);
            item = null;
        }
    }

    public void adicionaPersonagem(Personagem e) {

        if (e instanceof Monstro && !visivel) {
            e.setVisivel(false);
        }

        // Adiciona Personagem a Conjunto de Personagens
        hasCharacter = true;
        personagens.add(e);

        if (e instanceof Agente)
            painel.add(e);
        else {
            painel.add(e, c);
            if (visivel)
                e.setVisible(true);
        }

    }

    public void removePersonagem(Personagem e) {
        // Remove Personagem do painel e do Conjunto
        personagens.remove(e);
        painel.remove(e);

        // Atualiza Flag
        if (this.personagens.size() == 1)
            this.hasCharacter = false;
    }

    public void adicionaPoco(Buraco buraco) {
        // Atualiza Flag e aidiciona o poço a uma variável, para ser possível utilizar
        // em outros métodos
        hasTrap = true;
        poco = buraco;
        poco.setVisible(true);

        // Adiciona o Poço ao painel;
        painel.add(poco);
    }

    public void tapaBuraco(Campo[][] mapa) {
        painel.remove(poco);
        hasTrap = false;
        poco.removerBrisa(mapa, position);
        painel.setBackground(Color.decode("#964b00"));
    }

    public Buraco getBuraco() {
        return poco;
    }

    public void adicionaFedor() {
        if (!stinky) {
            fedor = new JLabel("Fedor");
            fedor.setFont(new Font("Comic Sans MS", 0, 10));
            fedor.setVisible(true);
            mensagens.add(fedor);
            stinky = true;
        }
    }

    public void removeFedor() {
        if (stinky && visivel) {
            mensagens.remove(fedor);
            stinky = false;
        }
    }

    public void adicionaBrisa() {
        brisa = new JLabel("Brisa");
        brisa.setFont(new Font("Comic Sans MS", 0, 10));
        brisa.setVisible(true);
        mensagens.add(brisa);
        repaint();
    }

    public void removeBrisa() {
        if (hasBreeze && visivel) {
            mensagens.remove(brisa);
            hasBreeze = false;
        }

    }

    // Métodos Especiais
    public Posicao getPosition() {
        return position;
    }

    public void setPosition(Posicao position) {
        this.position = position;
    }

    public boolean HasTrap() {
        return hasTrap;
    }

    public void setTrap(boolean hasTrap) {
        this.hasTrap = hasTrap;
    }

    public Set<Personagem> getPersonagens() {
        return personagens;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public boolean hasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public boolean hasCharacter() {
        return hasCharacter;
    }

    public boolean isStinky() {
        return stinky;
    }

    public void setIsStinky(boolean isStinky) {
        this.stinky = isStinky;
    }

    public boolean hasBreeze() {
        return hasBreeze;
    }

    public void setBreeze(boolean hasBreeze) {
        this.hasBreeze = hasBreeze;
    }

    public boolean hasShine() {
        return hasShine;
    }

    public void setShine(boolean hasShine) {
        this.hasShine = hasShine;
    }

    public void setStart(boolean isStart) {
        this.isStart = isStart;
    }

    public boolean getStart() {
        return isStart;
    }

}
