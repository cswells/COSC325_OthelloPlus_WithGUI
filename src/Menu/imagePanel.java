/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

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
public class imagePanel extends JPanel {

    BufferedImage backImage;
    
    public imagePanel()
    {
        super();
        try{
            backImage = ImageIO.read(new File(".\\src\\resources\\img\\backGround.png"));
        } catch (IOException fnf) {
            System.out.println("File(s) not found");
        }
    }
    
    public imagePanel(String path)
    {
        super();
        try{
            backImage = ImageIO.read(new File(path));
        } catch (IOException fnf) {
            System.out.println("File(s) not found");
        }
    }
    
    public void setImage(String imgFile)
    {
        try{
            backImage = ImageIO.read(new File(imgFile));
        } catch (IOException fnf) {
            System.out.println("File(s) not found");
        }
        
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        g.drawImage(backImage, 0,0, this.getWidth(),this.getHeight(),null);
    }
    
    
    
    
}
