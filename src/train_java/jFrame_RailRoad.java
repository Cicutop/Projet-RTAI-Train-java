/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train_java;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Pierre
 */
public class jFrame_RailRoad extends javax.swing.JFrame implements Observateur {
    
    /*Déclaration des variables d'images et autres*/
    private static final ImageIcon BLANC = new ImageIcon("./src/imgs/blanc.jpg");
    private static final ImageIcon VILLE = new ImageIcon("./src/imgs/ville.jpg");
    private static final ImageIcon RAIL = new ImageIcon("./src/imgs/rail.jpg");
    private static final ImageIcon CROIX = new ImageIcon("./src/imgs/croix.jpg");
    
    /*Initialisation des variables définissant la longeur et la largeur de la fenetre de jeu*/
    Plateau model;
    final int largeur = 10;
    final int longeur = 20;
    JLabel[][] jboard;
    /**
     * Creates new form jFrame_RailRoad
     * @param _model
     */
    public jFrame_RailRoad(Plateau _model) {
        model = _model;
        initComponents();
        
        jPanel1.setLayout(new java.awt.GridLayout(10, 20));
        
        jboard = new JLabel[largeur][longeur];
        
        for(int i=0;i<largeur;i++)
        {
            for(int j=0;j<longeur;j++)
            {
                // init case
                jboard[i][j] = new JLabel(BLANC);
                jboard[i][j].setIcon(BLANC);
                jPanel1.add(jboard[i][j]);
                jboard[i][j].addMouseListener(new CaseControler(model, i, j, 0));
            }
        }
    }
    
    void initBoard()
    {
        updateBoard();
    }
    
    void updateBoard() {
        for(int i=0;i<largeur;i++){
            for(int j=0;j<longeur;j++){
                switch (model.board[i][j]) {
                    case 0:
                        jboard[i][j].setIcon(BLANC);
                        break;
                    case 1:
                        jboard[i][j].setIcon(VILLE);
                        break;
                    case 2:
                        jboard[i][j].setIcon(RAIL);
                        break; 
                    case 3:
                        jboard[i][j].setIcon(CROIX);
                        break;
                }
            }
        }
    }
    
    /**
     *
     */    
    @Override
    public void avertirNewGame()
    {
        initBoard();
    }
    
    @Override
    public void avertir()
    {
        updateBoard();
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 200, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrame_RailRoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrame_RailRoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrame_RailRoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrame_RailRoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Plateau model = new Plateau();
                jFrame_RailRoad uneFrame = new jFrame_RailRoad(model);                
                uneFrame.setVisible(true);
                model.register(uneFrame);
                model.nouvellePartie();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
