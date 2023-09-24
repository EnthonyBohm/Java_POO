package ufpel.enthony.trabalhofinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
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


public class JanelaPrincipal extends JFrame implements ActionListener{
    private         Mapa                mapa;
    private         Campo[][]           campo;
    private         Agente              agente;
    private         Wumpus              wumpus;
    private         NovoMonstro         novoMonstro;
    private         GridBagConstraints  c, constraints;
    protected final   int                 DIREITA = 1, ESQUERDA = 2, CIMA = 3, BAIXO = 4;

    /* Atributos referentes aos paineis */
    private         JPanel              pInferior, botoes, mensagens, acoes, botoesInventario;
    private         JButton             andaCima, andaBaixo, andaEsq, andaDir, lDir, lEsq, lCima, lBaixo;
    private         JButton             debug, pegar, usar;
    private         JTextField          vida, bateria;
    private         JTextArea           info;
    private         JComboBox           inventario, direcao;
    private         Objeto              itemSelecionado;
    private         int                 direcaoSelecionada;

    public JanelaPrincipal(){
        c           = new GridBagConstraints();
        setTitle("O Mundo de Wumpus");
        ImageIcon icone = new ImageIcon("C:\\Users\\entho\\OneDrive\\Documentos\\GitHub\\Java_POO\\UFPel.Enthony.TrabalhoFinal\\src\\ufpel\\enthony\\trabalhofinal\\IconeMonstro.png");
        setIconImage(icone.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension (1920,1080));
        setLayout(new GridBagLayout());
        pack();

    }
    
    public void janelaBoasVindas(){
        JDialog boasVindas = new JDialog();
        JPanel botoesBoasVindas = new JPanel();
        JButton comecar, sair, debug;

        boasVindas.setSize(345, 150);
        boasVindas.setLayout(new GridLayout(2,0));
        boasVindas.setVisible(true);
        boasVindas.setLocationRelativeTo(null);
        boasVindas.setResizable(true);

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
            public void actionPerformed(ActionEvent e){
                boasVindas.dispose();
            }
        });

        debug = new JButton("DEBUG");
        debug.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boasVindas.dispose();
                JanelaPrincipal janela = new JanelaPrincipal();
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
        mapa        = new Mapa();
        mapa.inicializaMapa();
        
        campo       = mapa.getCampo();
        agente      = mapa.getAgente();
        wumpus      = mapa.getWumpus();
        novoMonstro     = mapa.getNovoMonstro();

        criaJanela();
    }

    private void newGame(int i) {
        JDialog painel = new JDialog();
        c  = new GridBagConstraints();
        painel.setLayout(new GridBagLayout());
        painel.setSize(500, 100);
        painel.setLocationRelativeTo(null);
        

        if (i == 0){
            JOptionPane.showMessageDialog(null, "Parabéns, Você ganhou!!!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Lamento, você perdeu!!!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
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
        pInferior = new JPanel(new GridLayout(0,2));
        pInferior.setBackground(Color.BLUE);

        
        /*          Definição dos Botões de Movimentação         */
        acoes     =     new JPanel();
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
        /*      Fim definição do Painel de Movimentção */

        // Botão de Debug
        debug = new JButton("DEBUG");
        debug.addActionListener(this::debug);

        /*      Definição do painel da Lanterna      */
        botoesInventario                =   new JPanel(new GridLayout(2,2));
        pegar                           =   new JButton("Pegar");
        usar                            =   new JButton("Usar");
        inventario                      =   new JComboBox<Objeto>();
        direcao                         =   new JComboBox<String>();

        direcao.addItem("Selecione uma direção");
        direcao.addItem("Direta");
        direcao.addItem("Esquerda");
        direcao.addItem("Cima");
        direcao.addItem("Baixo");
        direcao.addItem("Criar Flecha");
        botoesInventario.add(direcao);
        
        inventario.addItem(new Objeto("Selecione um objeto"));
        inventario.addItem(new Lanterna());
        botoesInventario.add(inventario);

        usar.addActionListener(this::usar);
        botoesInventario.add(usar);
        pegar.addActionListener(this::pegaItem);
        botoesInventario.add(pegar);
               
        /*      Fim da definição do Painel da Lanterna */
        
        //Adiciona Botões de ação ao painel inferior
        acoes.add(botoesInventario);
        acoes.add(botoes);
        acoes.add(debug);
        pInferior.add(acoes);

        // Definição do Painel de mensagens
        mensagens                       =   new JPanel(new GridBagLayout());
        CriaMensagens();
        pInferior.add(mensagens);
        

        //Adiciona Painel Inferior ao Frame
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
        constraints  =   new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy = 0;
        constraints.gridx = 2;
        mensagens.add(new JLabel("Vida"),constraints);
        constraints.gridx = 3;
        atualizaVida();
        vida.setEditable(false);
        mensagens.add(vida, constraints);

        constraints.gridy = 1;
        constraints.gridx = 2;
        mensagens.add(new JLabel("Bateria da Lanterna"), constraints);
        constraints.gridx = 3;
        atualizaBateria();
        bateria.setEditable(false);
        mensagens.add(bateria,constraints);

        constraints.gridy = 2;
        constraints.gridx = 2;
        mensagens.add(new JLabel("info"), constraints);
        constraints.gridx = 3;
        atualizaInfo("");
        mensagens.add(info, constraints);

    }

    private void atualizaInfo(String string) {
        info = new JTextArea(string, 3,30);
    }
    public void atualizaVida(){
        vida = new JTextField(String.format("%d/100",agente.getVida()), 10);
    }
    public void atualizaBateria(){
        bateria = new JTextField(String.format("%d/100",agente.getBateriaLanterna()), 10);
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        
       
        if ( agente.movimentar(campo, CIMA) == false ) return;
        turnoMonstros();
        mapa.repaint();
        if( !isAlive(agente)){
            dispose();
            newGame(1);
        }
        
    }   
    private void esquerda(ActionEvent actionevent1) {
        
        if ( agente.movimentar(campo, ESQUERDA) == false) return;
        turnoMonstros();
        mapa.repaint();
        if( !isAlive(agente)){
            newGame(1);
            dispose();
        }
            
    }
    private void baixo(ActionEvent actionevent1) {
    
        if (agente.movimentar(campo, BAIXO) == false) return;
        turnoMonstros();
        mapa.repaint();
        if( !isAlive(agente)){
            newGame(1);
            dispose();
        }      
        
    }
    private void direita(ActionEvent actionevent1) {
   
        if ( agente.movimentar (campo, DIREITA) == false) return;
        turnoMonstros();
        mapa.repaint();
        if( !isAlive(agente)){
            newGame(1);
            dispose();
        }
               
    }
    private void debug(ActionEvent actionevent1) {
        mapa.revelaMapa();
    }   


    public void turnoMonstros(){
        if (agente.hasGold() == true && campo[agente.getPosition().getX()][agente.getPosition().getY()].getStart() == true){
            dispose();
            newGame(0);
        }

        if (wumpus.isAlive()){
            wumpus.movimentar(mapa, wumpus.getPosition());
            if( wumpus.getPosition().samePosition(agente.getPosition()) ){
            wumpus.atacar(agente);
            newGame(1);
            }   
        }
        
        if (novoMonstro.isAlive()) {
            novoMonstro.movimentar(mapa, novoMonstro.getPosition());
            if( novoMonstro.getPosition().samePosition(agente.getPosition()) ){
            novoMonstro.atacar(agente);
            }
        }

        pack();
        CriaMensagens();
    }


    private void pegaItem(ActionEvent actionevent1) {
        int x, y;
        x = agente.getPosition().getX();
        y = agente.getPosition().getY();

        inventario.addItem(campo[x][y].getItem());
        agente.pegarItem(campo[x][y]);
        pack();
    }

    private void usar(ActionEvent actionevent1) {
        itemSelecionado     = (Objeto) inventario.getSelectedItem();
        direcaoSelecionada  = direcao.getSelectedIndex();

        if (itemSelecionado instanceof Madeira){
            if (direcaoSelecionada == 5){
                agente.criaFlecha();
                inventario.removeItem(itemSelecionado);
                inventario.addItem(new Flecha());
            }
            if (agente.tapaBuraco(direcaoSelecionada, campo) == false) atualizaInfo("Erro ao tapar buraco");
            else{
                atualizaInfo("Buraco tapado");
                agente.removerItem(itemSelecionado);
                inventario.removeItem(itemSelecionado);
                pack();
            }
        }

        if (itemSelecionado instanceof Lanterna){
            agente.usaLanterna(direcaoSelecionada, campo);
        }

        if (itemSelecionado instanceof Flecha) {
            agente.atirarFlecha(campo, direcaoSelecionada);
            inventario.remove(itemSelecionado);
        }

        pack();
    }    
    
    // Métodos Especiais
    public Mapa getMapa(){
        return mapa;
    }

    public boolean isAlive (Personagem e){
        if (e.getVida() == 0){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                JanelaPrincipal janela = new JanelaPrincipal();
                janela.janelaBoasVindas();
            }
        });
                
    }

    
}
