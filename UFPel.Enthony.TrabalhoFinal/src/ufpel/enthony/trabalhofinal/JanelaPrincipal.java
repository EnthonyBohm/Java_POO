package ufpel.enthony.trabalhofinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author entho
 */
public class JanelaPrincipal extends JFrame implements ActionListener{
    private     Mapa        mapa;
    private     Agente      agente;
    private     Wumpus      wumpus;
    private     NovoMonstro monstro;
    private     JButton     andaCima, andaBaixo, andaEsq, andaDir, debug;
        
    public void abreJanela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(false);
        setPreferredSize(new Dimension (1920,1080));
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        pack();
        
        
        // Definição do mapa
        mapa = new Mapa();
        mapa.inicializaMapa();
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1;
        add(mapa, c);
        
        // Definição do Painel inferior
        JPanel pInferior = new JPanel();
        pInferior.setBackground(Color.BLUE);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.1;
        
        //Definição dos Botões de Movimentação
        agente = mapa.getAgente();
        wumpus = mapa.getWumpus();
        monstro = mapa.getNovoMonstro();
        JPanel botoes = new JPanel(new BorderLayout());
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
        // Botão de Debug
        debug = new JButton("DEBUG");
        debug.addActionListener(this::debug);

        //Adiciona Botões ao painel inferior
        pInferior.add(botoes);
        pInferior.add(debug);
        
        //Adiciona Painel Inferior ao Frame
        add(pInferior, c);
        
        setVisible(true);

    }

    public Mapa getMapa(){
        return mapa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run (){
                agente.movimentaAcima(mapa);
                turnoMonstros();
                mapa.repaint();
                if( !isAlive(agente)){
                    System.out.println("Você Morreu");
                    dispose();
                }
            } 
        });
        
    }
    private void esquerda(ActionEvent actionevent1) {
        SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run (){
                agente.movimentaEsquerda(mapa);
                turnoMonstros();
                mapa.repaint();
                if( !isAlive(agente)){
                    System.out.println("Você Morreu");
                    dispose();
                }
           } 
        });   
    }

    private void baixo(ActionEvent actionevent1) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run (){
            agente.movimentaAbaixo(mapa);
            turnoMonstros();
            mapa.repaint();
            if( !isAlive(agente)){
                System.out.println("Você Morreu");
                dispose();
            }
        } 
    });
        
        
    }
    private void direita(ActionEvent actionevent1) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run (){
                agente.movimentaDireita(mapa);
                turnoMonstros();
                mapa.repaint();
                if( !isAlive(agente)){
                    System.out.println("Você Morreu");
                    dispose();
                }
            } 
        });
        
        
    }
    private void debug(ActionEvent actionevent1) {
        mapa.revelaMapa();
    }   

    public void turnoMonstros(){
        wumpus.movimenta(mapa);
        if(wumpus.mesmoBloco(agente)){
            wumpus.ataca(agente);
            System.out.println("GRAW");
            System.out.println("Você Perdeu");
            this.dispose();
        }
            
        monstro.movimenta(mapa);
        if(monstro.mesmoBloco(agente));
    }

    public boolean isAlive (Personagem e){
        if (e.getVida() == 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JanelaPrincipal janela = new JanelaPrincipal();

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                janela.abreJanela();
            }
        });
                
    }

     
}
