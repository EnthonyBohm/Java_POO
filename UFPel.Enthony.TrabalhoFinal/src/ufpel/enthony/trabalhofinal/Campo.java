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
    
    public Campo (int x, int y) {
        setVisible(true);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        setPreferredSize(new Dimension(20, 20));
        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);
        
        
        
        
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
        
        this.hasItem = true;
        itens.add(o);
        this.add(o);
        repaint();
        return true;
    }
    public Objeto pegaItem (String nome){
        for (Objeto item: itens){
            if (item.getTipo().equals(nome)){
                if (itens.size() == 1) hasItem = false;
                return item;
            }
        }
        return null;
    }
    
    public boolean adicionaPersonagem (Personagem e) {
        if (hasTrap)
            return false;
        
        this.hasCharacter = true;
        personagens.add(e);

        if (e.getClass().equals(Agente.class)){
            add(e,c);
        }else {
            if (visivel){
            c.anchor = GridBagConstraints.SOUTH;
            add(e,c);
            }
        }
        
            

        return true;
    }
    public void removePersonagem (Personagem e) {
        if (this.personagens.size() == 1)
            this.hasCharacter = false;
        personagens.remove(e);
    }
    
    public void adicionaPoco (Buraco e){
        hasTrap = true;
        add(e);
        poco = e;
    }
    public void tapaBuraco (Buraco e){
        hasTrap = false;
        remove(poco);
    }
    public Buraco getBuraco  (){
        return poco;
    }

    
    public void deixaVisível (){
        setBackground(Color.LIGHT_GRAY);
        visivel = true;
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        add(new JLabel("Azul"));
        
        if (hasCharacter) {
            for(Personagem p: personagens){
                if (p.getPosition().equals(position))
                    adicionaPersonagem(p);  
            }
        }
        repaint();
        
        if (hasTrap){
            setBackground(Color.BLACK);
            add( new JLabel ("Poço"), c);
        }    
        if (hasBreeze){
            JLabel label = new JLabel("Brisa");
            label.setFont(new Font("Comic Sans MS", 0, 12));
            System.out.println("Você sente uma Briza");
        }  
        if (hasShine)   add    ( new JLabel ("Brilho") );
        if (isStinky)   add    ( new JLabel ("Fedor")  );
        
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
