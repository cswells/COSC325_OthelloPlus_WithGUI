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
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu2
     */
    MenuController menuCon;
    
    public MainMenu(MenuController mc){
        menuCon = mc;
        initComponents();
        
        backPanel.setImage(".\\src\\resources\\img\\backGround.png");
        
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

        backPanel = new Menu.imagePanel();
        btnMainMenu = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        btnOnePlayer = new javax.swing.JLabel();
        btnTutorial = new javax.swing.JLabel();
        btnTwoPlayer = new javax.swing.JLabel();
        logoOthello = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(menuCon.defaultSize);
        setPreferredSize(menuCon.defaultSize);
        setResizable(false);
        setUndecorated(true);

        btnMainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/btnMainMenu.png"))); // NOI18N

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/btnExit.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExitMousePressed(evt);
            }
        });

        btnOnePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/btnOnePlayer.png"))); // NOI18N
        btnOnePlayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOnePlayerMousePressed(evt);
            }
        });

        btnTutorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/btnTutorial.png"))); // NOI18N
        btnTutorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTutorialMousePressed(evt);
            }
        });

        btnTwoPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/btnTwoPlayer.png"))); // NOI18N
        btnTwoPlayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTwoPlayerMousePressed(evt);
            }
        });

        logoOthello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/logoOthelloPlus.png"))); // NOI18N

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoOthello)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnTwoPlayer)
                        .addComponent(btnOnePlayer)
                        .addComponent(btnMainMenu)
                        .addComponent(btnTutorial)
                        .addComponent(btnExit)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(logoOthello)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOnePlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTwoPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTutorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addGap(46, 46, 46))
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

    private void btnExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMousePressed
        // TODO add your handling code here:
        menuCon.closeMainMenu();
    }//GEN-LAST:event_btnExitMousePressed

    private void btnOnePlayerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOnePlayerMousePressed
        // TODO add your handling code here:
        menuCon.closeMainMenu();
        menuCon.loadOnePlayerMenu();
    }//GEN-LAST:event_btnOnePlayerMousePressed

    private void btnTwoPlayerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTwoPlayerMousePressed
        menuCon.loadTwoPlayerMenu();
        menuCon.closeMainMenu();
    }//GEN-LAST:event_btnTwoPlayerMousePressed

    private void btnTutorialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTutorialMousePressed
        // TODO add your handling code here:
        menuCon.loadTutorial();
        menuCon.closeMainMenu();
    }//GEN-LAST:event_btnTutorialMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Menu.imagePanel backPanel;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMainMenu;
    private javax.swing.JLabel btnOnePlayer;
    private javax.swing.JLabel btnTutorial;
    private javax.swing.JLabel btnTwoPlayer;
    private javax.swing.JLabel logoOthello;
    // End of variables declaration//GEN-END:variables
}
