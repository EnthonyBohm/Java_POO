
package ufpel.enthony_Vitor.trabalhofinal.Personagem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ufpel.enthony_Vitor.trabalhofinal.Campo.Campo;
import ufpel.enthony_Vitor.trabalhofinal.Posicao.Posicao;

// Testar se da pra remover o GridBagConstraints de boa

public abstract class Personagem extends JPanel {
    protected int vida;
    protected int x, y;
    protected boolean visivel;
    protected Posicao position;
    protected String classe;
    protected Campo[][] mapa;
    protected final int DIREITA = 1, ESQUERDA = 2, CIMA = 3, BAIXO = 4;

    // Métodos Especiais
    public Personagem(String classe, ImageIcon icone) {
        vida = 100;
        this.classe = classe;
        aleatorizPosicao();

        // Definição do Layout
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBackground(null);

        // Redimensionamento da Imagem
        Image imagem = icone.getImage();
        Image newImage = imagem.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(newImage);
        add(new JLabel(icone), c);

        // Painel definido como Visível (Painel = Campo)
        setVisible(true);
    }

    private void aleatorizPosicao() {
        position = new Posicao();
        x = position.getX();
        y = position.getY();
    }

    // Métodos Referentes à movimentação do Personagem
    public boolean movimenta(int movimento) {
        boolean done = false;

        switch (movimento) {
            case DIREITA:
                done = position.moveDireita();
                break;
            case ESQUERDA:
                done = position.moveEsquerda();
                break;
            case CIMA:
                done = position.moveAcima();
                break;
            case BAIXO:
                done = position.moveAbaixo();
                break;
        }
        if (done) {
            x = position.getX();
            y = position.getY();
        }
        return done;
    }

    public boolean reproduzirAudio(String fileDir){
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File (fileDir).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao executar som");
            ex.printStackTrace();
            return false;
        }
    }
    // Métodos Especiais
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isVisivel() {
        return visivel;
    }
    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public String getClasse() {
        return classe;
    }

    public Posicao getPosition() {
        return position;
    }
    public void setPosition(Posicao position) {
        this.position = position;
    }

}
