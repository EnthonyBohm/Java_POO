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

/**
 * @author entho
 */
public class JanelaPrincipal extends JFrame implements ActionListener{
    private     Mapa        mapa;
    private     Agente      agente;
    private     Wumpus      wumpus;
    private     NovoMonstro monstro;
    private     JButton     andaCima, andaBaixo, andaEsq, andaDir;
        
    public void abreJanela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(false);
        setPreferredSize(new Dimension (1000,800));
        
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
        c.weighty = 0.60;
        add(mapa, c);
        
        // Definição do Painel inferior
        JPanel pInferior = new JPanel();
        pInferior.setBackground(Color.red);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.40;
        
        //Definição dos Botões de Movimentação
        agente = mapa.getAgente();
        wumpus = mapa.getWumpus();
        monstro = mapa.getNovoMonstro();
        JPanel botoes = new JPanel(new BorderLayout());

        andaCima = new JButton("Cima");
        andaCima.addActionListener(this);
        botoes.add(andaCima, BorderLayout.NORTH);

        andaBaixo = new JButton("Baixo");
        andaBaixo.addActionListener(this::baixo);
        botoes.add(andaBaixo, BorderLayout.SOUTH);

        andaEsq = new JButton("Esquerda");
        andaEsq.addActionListener(this::esquerda);
        botoes.add(andaEsq, BorderLayout.WEST);

        andaDir = new JButton("Direita");
        andaDir.addActionListener(this::direita);
        botoes.add(andaDir, BorderLayout.EAST);

        pInferior.add(botoes);
        

        add(pInferior, c);
        
        setVisible(true);

    }

    public Mapa getMapa(){
        return mapa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        agente.movimentaAcima(mapa);
        turnoMonstros();
    }
    private void esquerda(ActionEvent actionevent1) {
        agente.movimentaEsquerda(mapa);
        turnoMonstros();
    }
    private void baixo(ActionEvent actionevent1) {
        agente.movimentaAbaixo(mapa);
        turnoMonstros();
    }
    private void direita(ActionEvent actionevent1) {
        agente.movimentaDireita(mapa);
        turnoMonstros();
    }

    public void turnoMonstros(){
        // wumpus.movimenta(mapa);
        if(wumpus.mesmoBloco(agente)){
            wumpus.ataca(agente);
            System.out.println("GRAW");
            System.out.println("Você Perdeu");
            this.dispose();
        }
            
        // monstro.movimenta(mapa);
    }


    public static void main(String[] args) {
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.abreJanela();

                
    }    
}
