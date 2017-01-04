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
public class Plateau {
    int[][] board;
    final int largeur = 10;
    final int longeur = 20;
    int[] produitDepart = {0, 0, 0, 0};
    int[] produitFini;   
    ArrayList<Observateur> listeObservateur;
    
    /*ArrayList<LigneTrain> lignes;
    ArrayList<Train> train;
    ArrayList<Ville> villes;*/
    
    public Plateau() {
        board = new int[largeur][longeur];
        listeObservateur = new ArrayList<Observateur>();
        /*lignes = new ArrayList<LigneTrain>();
        train = new ArrayList<Train>();
        villes = new ArrayList<Ville>();*/
        
        produitFini = produitDepart;
        
        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTrain(this), 0, 1000);
        timer.scheduleAtFixedRate(new TimerMonstre(this), 0, 1000);*/
    }
    
    /*Méthode permettant d'ajouter un observateur à la liste*/
    public void register(Observateur unObservateur)
    {
        listeObservateur.add(unObservateur);
    }
    
    /*Méthode permettant de retirer un observateur de la liste*/
    public void unRegister(Observateur unObservateur)
    {
        listeObservateur.remove(unObservateur);
    }
    
    /*Méthode permettant d'avertir tout les observateur de la liste d'une action effectuée*/
    public void avertirAllObservateur()
    {
        for(Observateur unObs : listeObservateur)
        {
            unObs.avertir();
        }
    }
    
    /*Méthode permettant d'avertir tout les observateurs de la liste de la création d'une nouvelle partie*/
    public void avertirAllObservateurNewGame()
    {
        for(Observateur unObs : listeObservateur)
        {
            unObs.avertirNewGame();
        }
    }
    
    void nouvellePartie(){
        for(int i=0;i<largeur;i++){
            for(int j=0;j<longeur;j++){
                board[i][j] = 0;
                //couronne de montagne autour du plateau 
                /*if(i==0 || j == 0 || i == tailleX-1|| j == tailleY-1){
                    action(new CaseControler(this, i, j, 8));
                } */
            }
        }        
        click(new CaseControler(this,5,7,1));
        Ville ville1 = new Ville (this,"Montas",5,7);
        click(new CaseControler(this,8,12,1));
        Ville ville2 = new Ville (this,"Castel",10,12);
        click(new CaseControler(this,4,11,1));
        Ville ville3 = new Ville (this,"Garidech",8,7);
        avertirAllObservateurNewGame();
        avertirAllObservateur();
    }
    
    public int valeurCase(int i, int j)
    {
        int val = board[i][j];
        return val;
    }
    
    public void majPlateau()
    {
        for(int i=0;i<largeur;i++)
        {
            for(int j=0;j<longeur;j++)
            {
                /*On ne peut poser un rail que si il y a une ville ou un autre rail à coté*/
                if(board[i][j]==2)
                {
                    if(board[i-1][j]== 1 ||board[i+1][j]== 1 || board[i][j-1]== 1 ||board[i][j+1]== 1
                        || board[i-1][j]== 2 ||board[i+1][j]== 2 || board[i][j-1]== 2 ||board[i][j+1]== 2)
                    {
                        board[i][j]=2;                        
                    }          
                    else
                    {
                        board[i][j]=0;
                    }
                    if(board[i][j] == 2) 
                    {
                    int[] adjacents = new int[4];
                    int adjacentCompt = 0;  
                    if((board[i-1][j] == 2) || (board[i-1][j] == 1)) 
                    {
                        adjacents[0] = 1;
                        adjacentCompt++;
                    }
                    if((board[i+1][j] == 2) || (board[i+1][j] == 1)) 
                    {
                        adjacents[1] = 1;
                        adjacentCompt++;
                    }
                    if((board[i][j-1] == 2) || (board[i][j-1] == 1)) 
                    {
                        adjacents[2] = 1;
                        adjacentCompt++;
                    }
                    if((board[i][j+1] == 2) || (board[i][j+1] == 1)) 
                    {
                        adjacents[3] = 1;
                        adjacentCompt++;
                    }
                    if(adjacentCompt == 2) 
                    {
                        for(int k=0;k<adjacents.length;k++) 
                        {
                            if(adjacents[0] == 0) 
                            {
                                if(board[i-1][j] == 0)
                                {
                                    board[i-1][j] = 3;
                                }
                            }
                            if(adjacents[1] == 0) 
                            {
                                if(board[i+1][j] == 0)
                                {
                                    board[i+1][j] = 3;
                                }
                            }
                            if(adjacents[2] == 0) 
                            {
                                if(board[i][j-1] == 0)
                                {
                                    board[i][j-1] = 3;
                                }
                            }
                            if(adjacents[3] == 0) 
                            {
                                if(board[i][j+1] == 0)
                                {
                                    board[i][j+1] = 3;                                    
                                }
                            }
                        }
                    }
                }                
                }
                // retirer case grise si plus de rail autour
                if(board[i][j] == 3) 
                {
                    if(board[i-1][j] != 2 && board[i+1][j] != 2 && board[i][j-1] != 2 && board[i][j+1] != 2) 
                    {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    
    public void creationLigne()
    {
        
    }
    
    /**
     *
     * @param z
     */
    public void click(CaseControler z)
    {
       /*Lors du clic del'utilisateur sur la map, 
       on indique au modele(plateau) quelle case est concerné et quelle valeur elle doit contenir*/
       board[z.getX()][z.getY()]=z.getR();
       majPlateau();
       avertirAllObservateur();
    }
        
    
}
