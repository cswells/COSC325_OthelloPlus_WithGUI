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
public class Tutorial extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu2
     */
    MenuController menuCon;
    private int page = 1;
    
    public Tutorial(MenuController mc){
        menuCon = mc;
        initComponents();
        setBackGround(page);
        lblPrevious.setEnabled(false);
    }
    
    private void setBackGround(int i){
        switch(i){
            case(1): 
                backPanel.setImage("OthelloTutoralImages/1.png"); break;
            case(2): 
                backPanel.setImage("OthelloTutoralImages/2.png"); break;
            case(3): 
                backPanel.setImage("OthelloTutoralImages/3.png"); break;
            case(4): 
                backPanel.setImage("OthelloTutoralImages/4.png"); break;
            case(5): 
                backPanel.setImage("OthelloTutoralImages/5.png"); break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPanel = new Menu.imagePanel();
        lblMainMenu = new javax.swing.JLabel();
        lblPrevious = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(menuCon.defaultSize);
        setResizable(false);
        setUndecorated(true);

        backPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lblMainMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblMainMenu.setText("Main Menu");
        lblMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMainMenuMousePressed(evt);
            }
        });

        lblPrevious.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblPrevious.setText("Previous");
        lblPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPreviousMousePressed(evt);
            }
        });

        lblNext.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblNext.setText("Next");
        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNextMousePressed(evt);
            }
        });

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lblPrevious)
                .addGap(162, 162, 162)
                .addComponent(lblMainMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(lblNext)
                .addGap(82, 82, 82))
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backPanelLayout.createSequentialGroup()
                .addContainerGap(578, Short.MAX_VALUE)
                .addGroup(backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMainMenu)
                    .addComponent(lblPrevious)
                    .addComponent(lblNext))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-640)/2, 800, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void lblNextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMousePressed
        // TODO add your handling code here:
        if(page >= 1 && page < 5){
            page++;
            if(page == 5){
                lblNext.setEnabled(false);
            }
            lblPrevious.setEnabled(true);
            setBackGround(page);
            //System.out.println(page);
        }
    }//GEN-LAST:event_lblNextMousePressed

    private void lblPreviousMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPreviousMousePressed
        // TODO add your handling code here:
        if(page > 1 && page <= 5){
            page--;
            if(page == 1){
                lblPrevious.setEnabled(false);
            }
            lblNext.setEnabled(true);
            setBackGround(page);
            //System.out.println(page);
        }
        
        
    }//GEN-LAST:event_lblPreviousMousePressed

    private void lblMainMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMainMenuMousePressed
        // TODO add your handling code here:
        menuCon.closeTutorial();
        menuCon.loadMainMenu();
    }//GEN-LAST:event_lblMainMenuMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Menu.imagePanel backPanel;
    private javax.swing.JLabel lblMainMenu;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblPrevious;
    // End of variables declaration//GEN-END:variables
}
