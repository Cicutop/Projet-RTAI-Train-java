/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train_java;

import java.util.ArrayList;

/**
 *
 * @author Pierre
 */
public class ligneRail {
    ArrayList<int[]> uneLigneRail;
    boolean ligneComplete;
    
    public ligneRail()
    {
        uneLigneRail = new ArrayList<int[]>();
        ligneComplete = false;
    }
    
    /*Ajoute un rail a la liste de rail contenu par la ligne de rail*/
    public void ajouterRail(int[] unRail)
    {
        uneLigneRail.add(unRail);
    }
    
    /*Passe a true la valeur du boleen une fois que les deux villes sont reliées*/
    public void ligneTermine()
    {
        this.ligneComplete = true;
    }
}
