package ufpel.enthony.trabalhofinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author entho
 */
public class Campo extends JPanel{
    private     Set <Personagem>    personagens;
    private     Set <Objeto>        itens;
    private     Posicao             position;
    private     boolean             visivel;
    private     boolean             hasItem, hasCharacter, hasTrap;
    private     boolean             isStinky, hasBreeze, hasShine;
    private     GridBagConstraints  c;
    private     Buraco              poco;
    private     JPanel              painel;
    private     JLabel              fedor, brisa, brilho;
    
    public Campo (int x, int y) {
        setVisible(true);
        c = new GridBagConstraints();
        
        setPreferredSize(new Dimension(0, 0));
        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);
        painel = new JPanel();
        painel.setVisible(true);
        add(painel);
        painel.setBackground(null);
        
        
        
        this.visivel = false;
        this.hasCharacter = false;
        this.hasItem = false;
        this.hasBreeze = false;
        this.hasShine = false;
        this.hasTrap = false;
        this.isStinky = false;
        
        personagens = new HashSet<>();
        itens = new HashSet<>();
        position = new Posicao(x,y);
    }
    
    public boolean adicionaItem(Objeto o){
        if (hasTrap)
            return false;
        
        hasItem = true;
        itens.add(o);
        c.weightx=1;
        c.anchor = GridBagConstraints.SOUTH;
        painel.add(o, c);

        return true;
    }
    public Objeto pegaItem (String nome){
        for (Objeto item: itens){
            if (item.getTipo().equals(nome)){
                if (itens.size() == 1) hasItem = false;
                painel.remove(item);
                itens.remove(item);
                return item;
            }
        }
        return null;
    }
    
    public boolean adicionaPersonagem (Personagem e) {
        if (hasTrap)
            return false;
        
        hasCharacter = true;
        personagens.add(e);

        if (e.getClass().equals(Agente.class)){
            painel.add(e,c);
        }else {
            painel.add(e,c);
            if (visivel) e.setVisible(true);    
        }   
        add(painel);
        repaint();
        return true;   
    }
    public void removePersonagem (Personagem e) {
        if (this.personagens.size() == 1)
            this.hasCharacter = false;
        personagens.remove(e);
        painel.remove(e);
        repaint();
    }
    
    public void adicionaPoco (Buraco e){
        hasTrap = true;
        painel.add(e);
        repaint();
        poco = e;
    
        poco.setVisible(true);
    }
    public void tapaBuraco (Buraco e){
        hasTrap = false;
        remove(poco);
    }
    public Buraco getBuraco  (){
        return poco;
    }

    
    public void deixaVisível (){
        // Define a cor da posição Visível como Cinza
        setBackground(Color.LIGHT_GRAY);
        visivel = true;
        // Define as restrições da adição
        
        //Adiciona os Personagens que estavam no Quadro mas não estavam Visíveis
        if (hasCharacter) {
            for(Personagem p: personagens){
                if (p.getPosition().equals(position))
                    painel.add(p);
                    repaint();
            }
        }
        
        
        //Coloca o poço como um buraco escuro
        if (hasTrap){
            setBackground(Color.BLACK);
            poco.setVisible(true);
            poco.getLabel().setVisible(true);
        }

        //Adiciona Mensagem de brisa
        if (hasBreeze){
            brisa = new JLabel("Brisa");
            brisa.setFont(new Font("Comic Sans MS", 0, 12));
            painel.add(brisa);
        }  

        if (hasShine) {
            brilho = new JLabel("Brilho");
        }
        if (isStinky) {
            fedor = new JLabel("Fedor");
            fedor.setFont(new Font("Comic Sans MS", 0, 12));
            painel.add(fedor);
        }
        repaint();
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

    public void setPersonagens(Set<Personagem> personagens) {
        this.personagens = personagens;
    }

    public Set<Objeto> getItens() {
        return itens;
    }

    public void setItens(Set<Objeto> itens) {
        this.itens = itens;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public boolean isHasCharacter() {
        return hasCharacter;
    }

    public void setHasCharacter(boolean hasCharacter) {
        this.hasCharacter = hasCharacter;
    }

    public boolean isHasTrap() {
        return hasTrap;
    }

    public void setHasTrap(boolean hasTrap) {
        this.hasTrap = hasTrap;
    }

    public boolean isIsStinky() {
        return isStinky;
    }

    public void setIsStinky(boolean isStinky) {
        this.isStinky = isStinky;
    }

    public boolean isHasBreeze() {
        return hasBreeze;
    }

    public void setHasBreeze(boolean hasBreeze) {
        this.hasBreeze = hasBreeze;
    }

    public boolean isHasShine() {
        return hasShine;
    }

    public void setHasShine(boolean hasShine) {
        this.hasShine = hasShine;
    }
    
    
} 
