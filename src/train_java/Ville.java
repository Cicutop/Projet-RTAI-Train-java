/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train_java;

/**
 *
 * @author Pierre
 */
public class Ville {
    String nom;
    Plateau model;
    int x;
    int y;
    
    public Ville(Plateau _model,String _nom,int _x, int _y)
    {
        this.model = _model;
        this.nom = _nom;
        this.x = _x;
        this.y = _y;
    }
}
