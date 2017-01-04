/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train_java;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Pierre
 */
public class CaseControler extends MouseAdapter{

    Plateau model;
    int x;
    int y;
    int ref;
    
    public CaseControler(Plateau _model,int _x,int _y,int _ref)
    {
        this.model = _model;        
        this.x = _x;
        this.y = _y;
        this.ref = _ref;
    }
    
    /*Méthode éffectué a chaque clic de souris*/
    @Override
    public void mouseClicked(MouseEvent e) {
        /*Si la case est vide, on y place un rail au clic (valeur 2 = rail)*/
        if(model.board[x][y] == 0 ){
            System.out.println(x + " " + y);
            ref = 2;
            model.click(this);
            int valeur = model.valeurCase(x, y);
            System.out.println(valeur);
            /*System.out.print(model.toString());*/
        } 
        /*Si on reclique sur une case contenant déjà un rail , cela enleve le rail
        et refais passé la case en tatn que case "libre"*/
        else if (model.board[x][y] == 2) {
            System.out.println(x + " " + y);
            ref = 0;
            model.click(this);
            System.out.print(model.toString());
        }
        int valeur = model.valeurCase(x, y);
            System.out.println(valeur);
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public int getR()
    {
        return this.ref;
    }

}
