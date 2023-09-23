package ufpel.enthony.trabalhofinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class JanelaPrincipal extends JFrame implements ActionListener{
    private         Mapa                mapa;
    private         Campo[][]           campo;
    private         Agente              agente;
    private         Wumpus              wumpus;
    private         NovoMonstro         novoMonstro;
    private         GridBagConstraints  c, constraints;
    private final   int                 DIREITA = 1, ESQUERDA = 2, CIMA = 3, BAIXO = 4;

    /* Atributos referentes aos paineis */
    private         JPanel              pInferior, botoes, mensagens, acoes;
    private         JButton             andaCima, andaBaixo, andaEsq, andaDir, lDir, lEsq, lCima, lBaixo, debug, pegar, usar;
    private         JTextField          vida, bateria, posicao;
    private         JComboBox           inventario;
    private         Objeto              itenSelecionado;

    public JanelaPrincipal(){
        c           = new GridBagConstraints();
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension (1920,1080));
        setLayout(new GridBagLayout());
        pack();

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

        JPanel              botoes = new JPanel(new BorderLayout());
        

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
        JPanel                  lanternaBotoes = new JPanel(new BorderLayout());

        //LanternaDireita
        lDir = new JButton("Direita");
        lDir.addActionListener(this:: lDir);
        lanternaBotoes.add(lDir, BorderLayout.EAST);
        // Lanterna Esquerda
        lEsq = new JButton("Esquerda");
        lEsq.addActionListener(this:: lEsq);
        lanternaBotoes.add(lEsq, BorderLayout.WEST);
        // Lanterna Cima
        lCima = new JButton("Cima");
        lCima.addActionListener(this::lCima);
        lanternaBotoes.add(lCima, BorderLayout.NORTH);
        // Lanterna Baixo
        lBaixo = new JButton("Baixo", null);
        lBaixo.addActionListener(this::lBaixo);
        lanternaBotoes.add(lBaixo, BorderLayout.SOUTH);

        lanternaBotoes.add(new JLabel("Lanterna"), BorderLayout.CENTER);
        /*      Fim da definição do Painel da Lanterna */
        
        //Adiciona Botões de ação ao painel inferior
        acoes.add(lanternaBotoes, 0);
        acoes.add(botoes, 1);
        acoes.add(debug, 2);
        pInferior.add(acoes);

        // Definição do Painel de mensagens
        mensagens                       =   new JPanel(new GridBagLayout());
        inventario                      =   new JComboBox<Objeto>();
        pegar                           =   new JButton("Pegar");
        
        atualizaMensagens();
        pegar.addActionListener(this:: pegaItem );
        constraints.gridy = 4;
        constraints.gridx = 0;
        mensagens.add(pegar, constraints);
        

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

    private void atualizaMensagens() {
        constraints  =   new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy = 0;
        constraints.gridx = 0;
        mensagens.add(new JLabel("Vida"),constraints);
        constraints.gridx = 1;
        vida = new JTextField(String.format("%d/100",agente.getVida()), 10);
        vida.setEditable(false);
        mensagens.add(vida, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        mensagens.add(new JLabel("Bateria da Lanterna"), constraints);
        constraints.gridx = 1;
        bateria = new JTextField(String.format("%d/100",agente.getBateriaLanterna()), 10);
        bateria.setEditable(false);
        mensagens.add(bateria,constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        mensagens.add(new JLabel("Info"), constraints);
        constraints.gridx = 1;
        posicao = new JTextField(String.format("%s", "a"));
        posicao.setEditable(false);
        mensagens.add(posicao, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        mensagens.add(new JLabel ("Inventario"), constraints);
        constraints.gridx = 1;
        mensagens.add(inventario, constraints);
        itenSelecionado = (Objeto) inventario.getSelectedItem();

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
            JOptionPane.showMessageDialog(null, "Você Ganhou", "PARABENS", JOptionPane.INFORMATION_MESSAGE);
            newGame(1);
        }


        wumpus.movimentar(mapa, wumpus.getPosition());
        if(wumpus.mesmoBloco(agente)){
            wumpus.atacar(agente);
            System.out.println("GRAW");
            System.out.println("Você Perdeu");
            newGame(1);
        }   
        novoMonstro.movimentar(mapa, novoMonstro.getPosition());
        if(novoMonstro.mesmoBloco(agente));

        pack();
        atualizaMensagens();
    }

    private void newGame(int i) {
        JDialog painel = new JDialog();
        JPanel botoes = new JPanel();
        JButton sim, nao;
        c  = new GridBagConstraints();
        painel.setLayout(new GridBagLayout());
        painel.setSize(500, 100);
        painel.setLocationRelativeTo(null);
        

        if (i == 0){
            JOptionPane.showMessageDialog(null, "Parabéns, Você ganhou!!!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Lamento, você perdeu!!!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
        }
        
        c.gridy=0;
        c.gridx=0;
        painel.add(new JLabel("Deseja Jogar mais alguma vez???"), c);

        
        sim = new JButton("SIM");
        sim.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                painel.dispose();
                JanelaPrincipal janela = new JanelaPrincipal();
                janela.iniciaJogo();
            }

        });
        botoes.add(sim);
        
        nao = new JButton("NAO");
        nao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                painel.dispose();
            }
            
        });
        botoes.add(nao);

        c.gridy = 1;
        c.gridx = 0;
        painel.add(botoes,c);
        
        painel.setVisible(true);
    }

    private void lDir(ActionEvent actionevent1) {
        agente.usaLanterna(DIREITA, campo, agente.getPosition());
        atualizaMensagens();
    }
    private void lEsq(ActionEvent actionevent1) {
        agente.usaLanterna(ESQUERDA, campo, agente.getPosition());
        atualizaMensagens();
    }
    private void lCima(ActionEvent actionevent1) {
        agente.usaLanterna(CIMA, campo, agente.getPosition());
        atualizaMensagens();
    }
    private void lBaixo(ActionEvent actionevent1) {
        agente.usaLanterna(BAIXO, campo, agente.getPosition());
        atualizaMensagens();
    }

    private void pegaItem(ActionEvent actionevent1) {
        int x, y;
        x = agente.getPosition().getX();
        y = agente.getPosition().getY();

        agente.pegarItem(campo[x][y]);
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
                janela.iniciaJogo();
            }
        });
                
    }    
}
