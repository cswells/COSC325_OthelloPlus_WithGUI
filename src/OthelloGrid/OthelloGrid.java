/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OthelloGrid;

import Othello_p.AvailableLocation;
import Othello_p.CON_OthelloGame;
import Othello_p.OthelloScoreKeeper;
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
    OthelloScoreKeeper score;
    private GameImages gi;
    public OthelloSquare[][] square;
    private int size = 8;
    public OthelloGrid()
    {
        gi = new GameImages();
        square = new OthelloSquare[size][size];
        game = new CON_OthelloGame(size);
        //this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        setGridSize(size);
        scanBoard();
        scanAvailable();
        score = game.passScoreKeeper();
    }
    
    public OthelloGrid(int s)
    {
        size = s;
        gi = new GameImages();
        square = new OthelloSquare[size][size];
        game = new CON_OthelloGame(size);
        //this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        setGridSize(size);
        scanBoard();
        scanAvailable();
        score = game.passScoreKeeper();
    }
    public OthelloGrid(int size, int black, int white){
        this.size = size;
        gi = new GameImages();
        square = new OthelloSquare[size][size];
        game = new CON_OthelloGame(size);
        //this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        setGridSize(size);
        scanBoard();
        scanAvailable();
        score = game.passScoreKeeper();
    }
    
    public void passMouseListeners(MouseListener obj)
    {
        for(int x = 0; x < size; x++)
            for(int y = 0; y < size; y++)
                square[x][y].addMouseListener(obj);
    }
    
    private void scanBoard()
    {
        for(int y = 0; y < size; y++)
            for(int x = 0; x < size; x++)
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
            game.endGameTest();
            
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
        for(int y = 0; y < size; y++)
        {
            for(int x = 0; x < size; x++)
            {
                square[x][y].disableSquare();
            }
        }
    }
    
    public OthelloScoreKeeper passScoreKeeper()
    {
        return score;
    }
    
    private void setGridSize(int s)
    {
        this.setPreferredSize(new Dimension(400, 400));
        this.setSize(400, 400);
        this.setLayout(new GridLayout(s,s));
        
        for(int y = 0; y < s; y++)
        {
            for(int x = 0; x < s; x++)
            {
                square[x][y] = new OthelloSquare(gi);
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
            {
                makeMove(((OthelloSquare) (e.getSource())).getAvailableLoc());
            }
            else
            {
                
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
