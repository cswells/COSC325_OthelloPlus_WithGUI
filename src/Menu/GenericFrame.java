/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Chris Wells
 */
public class GenericFrame extends javax.swing.JFrame {
    private JPanel backPanel;
    private BufferedImage backImage;
    protected Dimension genericSize;
    protected MenuController menuCon;
    
    
    
    /**
     * Creates new form GenericFrame
     */
    public GenericFrame(MenuController mc) {
        try{
            backImage = ImageIO.read(new File(".\\src\\resources\\img\\background.jpg"));
        } catch (IOException fnf) {
            System.out.println("File(s) not found");
        }
        
        
        menuCon = mc;
        genericSize = new Dimension(menuCon.getWidth(), menuCon.getHeight());
        my_initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(genericSize);
        setMinimumSize(genericSize);
        setPreferredSize(genericSize);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void my_initComponents() {

        backPanel = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g)
            {
            super.paintComponent(g);
            g.drawImage(backImage, 0,0, backPanel.getWidth(),backPanel.getHeight(),null);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(genericSize);
        setResizable(false);
        setUndecorated(true);

        javax.swing.GroupLayout jPanSplashLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(jPanSplashLayout);
        jPanSplashLayout.setHorizontalGroup(
            jPanSplashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, menuCon.getWidth(), Short.MAX_VALUE)
        );
        jPanSplashLayout.setVerticalGroup(
            jPanSplashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, menuCon.getHeight(), Short.MAX_VALUE)
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
        setBounds((screenSize.width-menuCon.getWidth())/2, (screenSize.height-menuCon.getHeight())/2, menuCon.getWidth(), menuCon.getHeight());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
