package ufpel.enthony_Vitor.trabalhofinal.JanelaPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ufpel.enthony_Vitor.trabalhofinal.Campo.Campo;
import ufpel.enthony_Vitor.trabalhofinal.Campo.Mapa;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Flecha;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Lanterna;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Madeira;
import ufpel.enthony_Vitor.trabalhofinal.Objetos.Objeto;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Agente;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.NovoMonstro;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Personagem;
import ufpel.enthony_Vitor.trabalhofinal.Personagem.Wumpus;

public class JanelaPrincipal extends JFrame implements ActionListener {
    private Mapa mapa;
    private Campo[][] campo;
    private Agente agente;
    private Wumpus wumpus;
    private NovoMonstro novoMonstro;
    private GridBagConstraints c, constraints;
    protected final int DIREITA = 1, ESQUERDA = 2, CIMA = 3, BAIXO = 4;
    private static JanelaPrincipal janela;

    /* Atributos referentes aos paineis */
    private JPanel pInferior, botoes, mensagens, acoes, botoesInventario;
    private JButton andaCima, andaBaixo, andaEsq, andaDir;
    private JButton pegar, usar;
    private JTextField vida, bateria;
    private JTextArea info;
    private JComboBox<Objeto> inventario;
    private JComboBox<String> direcao;
    private Objeto itemSelecionado;
    private int direcaoSelecionada;

    public JanelaPrincipal() {
        c = new GridBagConstraints();
        setTitle("O Mundo de Wumpus");
        ImageIcon icone = new ImageIcon(
                "src\\ufpel\\enthony_Vitor\\trabalhofinal\\Icones\\IconeMonstro.png");
        setIconImage(icone.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1920, 1080));
        setLayout(new GridBagLayout());
        pack();

    }

    public void janelaBoasVindas() {
        JDialog boasVindas = new JDialog();
        JPanel botoesBoasVindas = new JPanel();
        JButton comecar, sair, debug;

        boasVindas.setSize(345, 150);
        boasVindas.setLayout(new GridLayout(2, 0));
        boasVindas.setVisible(true);
        boasVindas.setLocationRelativeTo(null);
        boasVindas.setResizable(true);
        boasVindas.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        boasVindas.add(new JLabel("  Bem Vindo ao íncrivel mundo do Wumpus, o que deseja?  "));

        comecar = new JButton("COMEÇAR");
        comecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boasVindas.dispose();
                JanelaPrincipal janela = new JanelaPrincipal();
                janela.iniciaJogo();
            }
        });

        sair = new JButton("SAIR");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boasVindas.dispose();
                System.exit(0);
            }
        });

        debug = new JButton("DEBUG");
        debug.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boasVindas.dispose();
                janela = new JanelaPrincipal();
                janela.iniciaJogo();
                janela.getMapa().revelaMapa();
            }

        });

        botoesBoasVindas.add(comecar);
        botoesBoasVindas.add(debug);
        botoesBoasVindas.add(sair);

        boasVindas.add(botoesBoasVindas);
    }

    public void iniciaJogo() {
        mapa = new Mapa();
        mapa.inicializaMapa();

        campo = mapa.getCampo();
        agente = mapa.getAgente();
        wumpus = mapa.getWumpus();
        novoMonstro = mapa.getNovoMonstro();

        criaJanela();
    }

    private void newGame(int i) {
        JDialog painel = new JDialog();
        c = new GridBagConstraints();
        painel.setLayout(new GridBagLayout());
        painel.setSize(500, 100);
        painel.setLocationRelativeTo(null);

        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Parabéns, Você ganhou!!!", "Fim de Jogo",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Lamento, você perdeu!!!", "Fim de Jogo",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        JanelaPrincipal janela = new JanelaPrincipal();
        janela.janelaBoasVindas();
    }

    public void criaJanela() {
        // Definição do mapa (pSuperior)
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1;
        add(mapa, c);

        // Definição do Painel inferior
        pInferior = new JPanel(new GridLayout(0, 2));
        pInferior.setBackground(Color.BLUE);

        /* Definição dos Botões de Movimentação */
        acoes = new JPanel();
        acoes.setBackground(null);

        botoes = new JPanel(new BorderLayout());

        // Movimento Cima
        andaCima = new JButton("Cima");
        andaCima.addActionListener(this);
        botoes.add(andaCima, BorderLayout.NORTH);
        // movimento baixo
        andaBaixo = new JButton("Baixo");
        andaBaixo.addActionListener(this::baixo);
        botoes.add(andaBaixo, BorderLayout.SOUTH);
        // movimento Esquerda
        andaEsq = new JButton("Esquerda");
        andaEsq.addActionListener(this::esquerda);
        botoes.add(andaEsq, BorderLayout.WEST);
        // movimento Direita
        andaDir = new JButton("Direita");
        andaDir.addActionListener(this::direita);
        botoes.add(andaDir, BorderLayout.EAST);
        botoes.add(new JLabel("Movimentação"), BorderLayout.CENTER);
        pack();
        /* Fim definição do Painel de Movimentção */

        /* Definição dos botões de Inventário e Ação */
        botoesInventario = new JPanel(new GridLayout(2, 2));
        pegar = new JButton("Pegar");
        usar = new JButton("Usar");
        inventario = new JComboBox<Objeto>();
        direcao = new JComboBox<String>();

        direcao.addItem("Selecione uma direção");
        direcao.addItem("Direta");
        direcao.addItem("Esquerda");
        direcao.addItem("Cima");
        direcao.addItem("Baixo");
        direcao.addItem("Criar Flecha");
        direcao.addItem("Ficar parado");
        botoesInventario.add(direcao);

        inventario.addItem(new Objeto("Selecione um objeto"));
        inventario.addItem(new Lanterna());
        botoesInventario.add(inventario);

        usar.addActionListener(this::usar);
        botoesInventario.add(usar);
        pegar.addActionListener(this::pegaItem);
        botoesInventario.add(pegar);

        /* Fim da definição dos botões de Inventário e ação */

        // Adiciona Botões de ação ao painel inferior
        acoes.add(botoesInventario);
        acoes.add(botoes);
        pInferior.add(acoes);

        // Definição do Painel de mensagens
        mensagens = new JPanel(new GridBagLayout());
        CriaMensagens();
        pInferior.add(mensagens);

        // Adiciona Painel Inferior ao Frame
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.1;
        add(pInferior, c);

        setVisible(true);
    }

    public void CriaMensagens() {
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy = 0;
        constraints.gridx = 2;
        mensagens.add(new JLabel("Vida"), constraints);
        constraints.gridx = 3;
        vida = new JTextField(String.format("%d/100", agente.getVida()), 10);
        vida.setEditable(false);
        mensagens.add(vida, constraints);

        constraints.gridy = 1;
        constraints.gridx = 2;
        mensagens.add(new JLabel("Bateria da Lanterna"), constraints);
        constraints.gridx = 3;
        bateria = new JTextField(String.format("%d/100", agente.getBateriaLanterna()), 10);
        bateria.setEditable(false);
        mensagens.add(bateria, constraints);

        constraints.gridy = 2;
        constraints.gridx = 2;
        mensagens.add(new JLabel("info"), constraints);
        constraints.gridx = 3;
        info = new JTextArea(" ", 3, 30);
        mensagens.add(info, constraints);

    }

    private void atualizaInfo(String string) {
        info.setText(string);
    }

    public void atualizaVida() {
        vida.setText(String.format("%s/100", agente.getVida()));
    }

    public void atualizaBateria() {
        bateria.setText(String.format("%s/100", agente.getBateriaLanterna()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (agente.movimenta(campo, CIMA) == false)
            return;
        turnoMonstros();

    }

    private void esquerda(ActionEvent actionevent1) {

        if (agente.movimenta(campo, ESQUERDA) == false)
            return;
        turnoMonstros();

    }

    private void baixo(ActionEvent actionevent1) {

        if (agente.movimenta(campo, BAIXO) == false)
            return;
        turnoMonstros();
    }

    private void direita(ActionEvent actionevent1) {

        if (agente.movimenta(campo, DIREITA) == false)
            return;
        turnoMonstros();

    }

    public void turnoMonstros() {
        if (agente.getPosition().samePosition(wumpus))
            wumpus.atacar(agente);
        if (agente.getPosition().samePosition(novoMonstro))
            novoMonstro.atacar(agente);
        
        if (!isAlive(agente)) {
            pack();
            newGame(1);
            dispose();
            return;
        }

        
        if (agente.hasGold() == true
                && campo[agente.getPosition().getX()][agente.getPosition().getY()].getStart() == true) {
            dispose();
            newGame(0);
        }

        if (wumpus.isAlive()) {
            wumpus.movimenta(campo, agente);
            if (wumpus.getPosition().samePosition(agente)) {
                wumpus.atacar(agente);
            }

        }

        if (novoMonstro.isAlive()) {
            novoMonstro.movimenta(campo, agente);
        }

        atualizaVida();
        pack();
        mapa.repaint();

        if (!isAlive(agente)) {
            newGame(1);
            dispose();
        }
    }

    private void pegaItem(ActionEvent actionevent1) {
        int x, y;
        x = agente.getPosition().getX();
        y = agente.getPosition().getY();

        if (campo[x][y].hasItem()) {
            inventario.addItem(campo[x][y].getItem());
            agente.pegarItem(campo[x][y]);
            pack();
            atualizaInfo("Item coletado");
        } else
            atualizaInfo("Sem Itens nessa posição");

        turnoMonstros();
    }

    private void usar(ActionEvent actionevent1) {
        itemSelecionado = (Objeto) inventario.getSelectedItem();
        direcaoSelecionada = direcao.getSelectedIndex();

        if (direcaoSelecionada == 6) {
            turnoMonstros();
        }

        else if (itemSelecionado instanceof Madeira) {
            if (direcaoSelecionada == 5) {
                agente.criaFlecha();
                inventario.removeItem(itemSelecionado);
                inventario.addItem(new Flecha());
            }
            if (agente.tapaBuraco(direcaoSelecionada, campo) == false)
                atualizaInfo("Erro ao tapar buraco");
            else {
                atualizaInfo("Buraco tapado");
                agente.removerItem(itemSelecionado);
                inventario.removeItem(itemSelecionado);
            }
            turnoMonstros();
        }

        else if (itemSelecionado instanceof Lanterna) {
            agente.usaLanterna(direcaoSelecionada, campo);
            atualizaBateria();
        }

        else if (itemSelecionado instanceof Flecha) {
            agente.atirarFlecha(campo, direcaoSelecionada);
            inventario.removeItem(itemSelecionado);
            agente.removerItem(itemSelecionado);
            turnoMonstros();
        }

        pack();
    }

    // Métodos Especiais
    public Mapa getMapa() {
        return mapa;
    }

    public boolean isAlive(Personagem e) {
        if (e.getVida() == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                janela = new JanelaPrincipal();
                janela.janelaBoasVindas();
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }

}
