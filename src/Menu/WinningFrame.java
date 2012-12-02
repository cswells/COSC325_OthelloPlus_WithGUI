/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris Wells
 */
public class WinningFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu2
     */
    MenuController menuCon;
    
    public WinningFrame(MenuController mc, int winner){
        menuCon = mc;
        initComponents();
        backPanel.setImage(".\\src\\resources\\img\\blank.png");
        
        if(winner == 1)
            lblWinner.setText("Black Player was the Winner!");
        if(winner == 2)
            lblWinner.setText("White Player was the Winner!");
        if(winner == 0)
            lblWinner.setText("The Game ended in a Draw!");
        
    }
    
    public void setBackGround(String imgLoc){
        backPanel.setImage(imgLoc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPanel = new imagePanel(".\\src\\resources\\img\\blank.png");
        lblWinner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(600, 20));
        setResizable(false);
        setUndecorated(true);

        backPanel.setPreferredSize(new java.awt.Dimension(800, 200));
        backPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backPanelKeyPressed(evt);
            }
        });

        lblWinner.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        lblWinner.setText("XXXXXXXXXXXXX");

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(lblWinner)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWinner)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-608)/2, (screenSize.height-122)/2, 608, 122);
    }// </editor-fold>//GEN-END:initComponents

    private void backPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backPanelKeyPressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backPanelKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Menu.imagePanel backPanel;
    private javax.swing.JLabel lblWinner;
    // End of variables declaration//GEN-END:variables
}