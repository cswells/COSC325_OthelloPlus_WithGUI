/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OthelloGrid;


import Othello_p.AvailableLocation;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Chris Wells
 */
public class OthelloSquare extends JPanel implements MouseListener{
    
    
    private BufferedImage blank;
    private BufferedImage black;
    private BufferedImage blackAvail;
    private BufferedImage white;
    private BufferedImage whiteAvail;
    private BufferedImage current;
    
//    private int xcoord;
//    private int ycoord;
    private boolean enabled;
    public AvailableLocation al;
    private boolean isSet;
    private OthelloGrid parent;
    
    public OthelloSquare(AvailableLocation al)
    {
        
        //---- Image Loading Phase (START)
        try{
            blank = ImageIO.read(new File(".\\src\\resources\\img\\blank.png"));
            white = ImageIO.read(new File(".\\src\\resources\\img\\white.png"));
            whiteAvail = ImageIO.read(new File(".\\src\\resources\\img\\white_move.png"));
            black = ImageIO.read(new File(".\\src\\resources\\img\\black.png"));
            blackAvail = ImageIO.read(new File(".\\src\\resources\\img\\black_move.png"));
        } catch (IOException fnf) {
            System.out.println("File(s) not found");
        }
        //---- Image Loading Phase (END)
        
        //----Set Defaults
        current = blank;
        enabled = false;
        isSet = false;
        addMouseListener(this);
        
        this.al = al;
        //----Apply Varables
//        xcoord = x;
//        ycoord = y;
        
    }
    public void setBlank()
    {
        current = blank;
    }
    public void setBlack()
    {
        current = black;
        isSet = true;
    }
    
    public void setWhite()
    {
        current = white;
        isSet = true;
    }
    
    public void makeAvailableWhite()
    {
        current = whiteAvail;
    }
    
    public void makeAvailableBlack()
    {
        current = blackAvail;
    }
    
    public void enable(AvailableLocation al, Boolean bool)
    {
        this.al = al;
        if(bool == Boolean.TRUE)
        {
            makeAvailableBlack();
        }else{
            makeAvailableWhite();
        }
        enabled = true;
    }
    public void disableSquare()
    {
        if(isSet == false)
        {
            setBlank();
        }
        enabled = false;
        this.al = null;
    }
    private void cyclePieces()
    {
        if(current == blank)
        {
            current = whiteAvail;
        }
        else if(current == whiteAvail)
        {
            current = blackAvail;
        }
        else if(current == blackAvail)
        {
            current = white;
        }
        else if(current == white)
        {
            current = black;
        }
        else
        {
            current = blank;
        }
        
        repaint();
    }
    
    public AvailableLocation getAvailableLoc()
    {
        return al;
    }
    
    public void printLocation()
    {
        System.out.println("Xlocation : "+al.getX());
        System.out.println("Ylocation : "+al.getY());
    
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(current, 0,0, null);
    }
    
    //---------START of Event Liseners------------
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        e.setSource(this);
        
        if(enabled == true)
        {
            cyclePieces();
            //parent.makeMove(al);
            repaint();
        }
        else
        {
            System.out.println("Failed");
            //doNothing
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    //---------END of Event Liseners------------


    
}
