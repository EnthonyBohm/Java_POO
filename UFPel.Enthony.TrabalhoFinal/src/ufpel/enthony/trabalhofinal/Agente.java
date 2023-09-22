
package ufpel.enthony.trabalhofinal;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Agente extends Personagem{ 
//    Metodos Herdados
//    int pv 
//    boolean visivel 
//    Posicao position
    private         ArrayList<Objeto>   objetos;
    private         int                 bateriaLanterna;

    ImageIcon icone;
    
    public Agente(){
        super("Agente", new ImageIcon ("C:\\Users\\entho\\OneDrive\\Documentos\\GitHub\\Java_POO\\UFPel.Enthony.TrabalhoFinal\\src\\IconeAgente.png"));
        super.setPosition(new Posicao(0, 0));

        bateriaLanterna = 100;
        objetos = new ArrayList<>();

        setVisible(true);
    }

    public void usaLanterna(int direction, Campo[][] mapa, Posicao pAtual){
        int x, y, i;
        x = pAtual.getX();
        y = pAtual.getY();

        if (bateriaLanterna > 0){
            switch (direction){
                case 1:
                    for(i = x; i < 15; i++)
                        mapa[i][y].deixaVisível();
                    break;
                case 2:
                    for(i = x; i > 0; i--)
                        mapa[i][y].deixaVisível();
                    break;
                case 3:
                    for(i = y; i < 15; i++)
                        mapa[x][i].deixaVisível();
                    break;
                case 4:
                    for(i = y; i > 0; i--)
                        mapa[x][i].deixaVisível();
                    break;
            }
        }
    }


    


}
