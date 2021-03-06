/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Othello_p;

/**
 *
 * @author Chris Wells
 */
public class OthelloScoreKeeper {
    int maxTurns;
    int currentTurn;
    int scoreWhite;
    int scoreBlack;
    boolean endOfGame = false; 
    
    public OthelloScoreKeeper(int m)
    {
        currentTurn = 0;
        maxTurns = m;
    }
        
    public void addPointWhite()
    {
        scoreWhite++;
    }
    
    public void addPointBlack()
    {
        scoreBlack++;
    }
    
    public void remPointWhite()
    {
        scoreWhite--;
    }
    
    public void remPointBlack()
    {
        scoreBlack--;
    }
    
    public int getPointWhite(){
        return scoreWhite;
    }
    
    public int getPointBlack(){
        return scoreBlack;
    }
    
    
    public int getCurrentTurn()
    {
        return currentTurn;
    }
    
    public void nextTurn(){
        currentTurn++;
    }
    public void setEndOfGame()
    {
        endOfGame = true;
    }
    public boolean isEndOfGame()
    {
        if(currentTurn == maxTurns || endOfGame)
            return true;
        else
            return false;
    }
}
