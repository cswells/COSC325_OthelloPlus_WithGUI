/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OthelloGrid;

import Othello_p.AvailableLocation;
import Othello_p.CON_OthelloGame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Chris Wells
 */
public class OthelloGrid extends JPanel implements MouseListener{
    CON_OthelloGame game;
    OthelloSquare[][] square;
    final int SIZE = 8;
    public OthelloGrid()
    {
        square = new OthelloSquare[SIZE][SIZE];
        game = new CON_OthelloGame(SIZE);
        setGridSize(SIZE);
        scanBoard();
        scanAvailable();
    }
    
    private void scanBoard()
    {
        for(int y = 0; y < SIZE; y++)
            for(int x = 0; x < SIZE; x++)
                setPeice(x, y, game.getLocation(x, y));
    }
    
    private void scanAvailable()
    {
        for(int i = 0; i < game.validLoc.size(); i++)
            enableAvail(game.validLoc.get(i), game.getPlayer());
        
    }
    
    public void makeMove(AvailableLocation al)
    {
        game.makeMove(al);
        game.validLoc.clear();
        game.swapPlayer();
        game.findValidLocations();
        if(game.validLoc.isEmpty())
        {
            System.out.println("No Available Moves for current player, SKIP was made!");
            game.swapPlayer();
            game.findValidLocations();
        }
        disableAll();
        scanBoard();
        scanAvailable();
        repaint();
            
    }
    
    private void setPeice(int x, int y, Boolean bool)
    {
        if(bool == Boolean.TRUE)
            square[x][y].setBlack();
        else if(bool == Boolean.FALSE)
            square[x][y].setWhite();
        else
            square[x][y].setBlank();
    }
    
    private void enableAvail(AvailableLocation al, Boolean player)
    {
        square[al.getX()][al.getY()].enable(al, player);
    }
    
    private void disableAll()
    {
        for(int y = 0; y < SIZE; y++)
        {
            for(int x = 0; x < SIZE; x++)
            {
                square[x][y].disableSquare();
            }
        }
    }
    
    private void setGridSize(int s)
    {
        this.setPreferredSize(new Dimension(s*50 +2, s*50 +2));
        this.setLayout(new GridLayout(s,s));
        
        for(int y = 0; y < s; y++)
        {
            for(int x = 0; x < s; x++)
            {
                square[x][y] = new OthelloSquare(null);
                square[x][y].addMouseListener(this);
                this.add(square[x][y]);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try{
            if(((OthelloSquare) (e.getSource())).getAvailableLoc() != null)
                makeMove(((OthelloSquare) (e.getSource())).getAvailableLoc());
            else
            {
                //No move to be made.
            }
                //((OthelloSquare) (e.getSource())).printLocation();
        }catch(Exception empty)
        {
            //doNothing
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}