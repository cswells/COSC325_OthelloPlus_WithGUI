/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OthelloGrid;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Chris Wells
 */
public class GameImages {
        private BufferedImage blank;
        private BufferedImage white;
        private BufferedImage black;
        private BufferedImage whiteAvail;
        private BufferedImage blackAvail;
        
    public GameImages(){
            try{
            blank = ImageIO.read(new File(".\\src\\resources\\img\\blank.png"));
            white = ImageIO.read(new File(".\\src\\resources\\img\\white.png"));
            whiteAvail = ImageIO.read(new File(".\\src\\resources\\img\\white_move.png"));
            black = ImageIO.read(new File(".\\src\\resources\\img\\black.png"));
            blackAvail = ImageIO.read(new File(".\\src\\resources\\img\\black_move.png"));
        } catch (IOException fnf) {
            System.out.println("File(s) not found");
        }
    }
    
    public BufferedImage getBlank()
    {
        return blank;
    }
    
    public BufferedImage getWhite()
    {
        return white;
    }
    
    public BufferedImage getBlack()
    {
        return black;
    }
    
    public BufferedImage getWhiteAvail()
    {
        return whiteAvail;
    }
    
    public BufferedImage getBlackAvail()
    {
        return blackAvail;
    }
    
}
