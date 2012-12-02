/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Othello_p;
import java.util.ArrayList;
/**
 *
 * @author Chris Wells
 */
public class CON_OthelloGame
{
    //-----GlobalVaribals
    private MOD_Board board;
    public ArrayList<AvailableLocation> validLoc;
    private Boolean currentPlayer;
    private int size;
    OthelloScoreKeeper sk;
    //AI on.off varible.
    public CON_OthelloGame(int s)
    {
        sk = new OthelloScoreKeeper(s*s);
        this.size = s;
        board = new MOD_Board(size);
        currentPlayer = Boolean.TRUE; //Player Black - One
        setupBoard();
        validLoc = new ArrayList<AvailableLocation>();
        findValidLocations();
    }
    
    private void setupBoard()
    {
        placeToken(size/2 - 1, size/2 - 1, Boolean.FALSE);
        placeToken(size/2, size/2, Boolean.FALSE);
        placeToken(size/2, size/2 - 1, Boolean.TRUE);
        placeToken(size/2 - 1, size/2, Boolean.TRUE);
    }
    
    public void swapPlayer()
    {
        if(getPlayer() == Boolean.TRUE)
            currentPlayer = Boolean.FALSE;
        else
            currentPlayer = Boolean.TRUE;
    }
    
    public Boolean getLocation(int x, int y)
    {
        return board.getToken(x, y);
    }
    
    public final void findValidLocations()
    {
        
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                if(isOppPlayer(x, y) == 1)
                {
                    emptyLocationHelper(x, y);
                }
            }
        }
    }
    //Checks around a opposite players peice for empty spaces
    private void emptyLocationHelper(int x, int y)
    {
        boolean e, ne, n, nw, w, sw, s, se;
        e = ne = n = nw = w = sw = s = se = true;
        //Checks for board boundries
        if(x + 1 >= size)
        {
            ne = e = se = false;
        }
        if(y - 1 < 0)
        {
            nw = n = ne = false;
        }
        if(x - 1 < 0)
        {
            nw = w = sw = false;
        }
        if(y + 1 >= size)
        {
            sw = s = se = false;
        }
        //End of BoardBoundries Check
        //If the Remaining are found True, it sends this infomation to AvailableLocationHelper
        if(e == true && isOppPlayer(x+1, y) == -1)
            availbleLocationHelper(x+1, y);
        
        if(ne == true && isOppPlayer(x+1, y-1) == -1)
            availbleLocationHelper(x+1, y-1);
        
        if(n == true && isOppPlayer(x, y-1) == -1)
            availbleLocationHelper(x, y-1);
        
        if(nw == true && isOppPlayer(x-1, y-1) == -1)
            availbleLocationHelper(x-1, y-1);
        
        if(w == true && isOppPlayer(x-1, y) == -1)
            availbleLocationHelper(x-1, y);
        
        if(sw == true && isOppPlayer(x-1, y+1) == -1)
            availbleLocationHelper(x-1, y+1);
        
        if(s == true && isOppPlayer(x, y+1) == -1)
            availbleLocationHelper(x, y+1);
        
        if(se == true && isOppPlayer(x+1, y+1) == -1)
            availbleLocationHelper(x+1, y+1);
        
    }
    //once an empty space around a opposites players peice is found, this function 
    //looks for valid moves and make an entry in the valid moves array.
    private void availbleLocationHelper(int x, int y)
    {
        int compass[] = new int[8];
        AvailableLocation newLoc;
        //boolean e, ne, n, nw, w, sw, s, se;
        //e = ne = n = nw = w = sw = s = se = true;
        //Checks for board boundries
        for(int i = 0; i < 8; i++)
        {
            compass[i] = 0;
        }
        
        if(x + 1 >= size)
        {
            //ne = e = se = false;
            compass[7]--;
            compass[0]--;
            compass[1]--;
        }
        if(y - 1 < 0)
        {
            //nw = n = ne = false;
            compass[1]--;
            compass[2]--;
            compass[3]--;
        }
        if(x - 1 < 0)
        {
            //nw = w = sw = false;
            compass[3]--;
            compass[4]--;
            compass[5]--;
        }
        if(y + 1 >= size)
        {
            //sw = s = se = false;
            compass[5]--;
            compass[6]--;
            compass[7]--;
        }
        //Validation
        if(compass[0] == 0)
        {
            compass[0] = testE(x, y);
        }
        if(compass[1] == 0)
        {
            compass[1] = testNE(x, y);
        }
        if(compass[2] == 0)
        {
            compass[2] = testN(x, y);
        }
        if(compass[3] == 0)
        {
            compass[3] = testNW(x, y);
        }
        if(compass[4] == 0)
        {
            compass[4] = testW(x, y);
        }
        if(compass[5] == 0)
        {
            compass[5] = testSW(x, y);
        }
        if(compass[6] == 0)
        {
            compass[6] = testS(x, y);
        }
        if(compass[7] == 0)
        {
            compass[7] = testSE(x, y);
        }
        newLoc = new AvailableLocation(x, y, compass);
        
        if(newLoc.getCompassTotal() > 0)
            validLoc.add(newLoc);
        
        
        
    }
    private int testE(int x, int y)
    {
        int n = 0;
        do
            {
                if(isOppPlayer(x+1, y) == 1)
                {
                    n++;
                    x++;
                }
                else if(isOppPlayer(x+1, y) == 0)
                {
                    break;
                }
                else
                {
                    n = 0;
                    break;
                }
            }while(true);
        
        return n;
    }
    
    private int testNE(int x, int y)
    {
        int n = 0;
        do
            {
                if(isOppPlayer(x+1, y-1) == 1)
                {
                    n++;
                    x++;
                    y--;
                }
                else if(isOppPlayer(x+1, y-1) == 0)
                {
                    break;
                }
                else
                {
                    n = 0;
                    break;
                }
            }while(true);
        
        return n;
    }
    
    private int testN(int x, int y)
    {
        int n = 0;
        do
            {
                if(isOppPlayer(x, y-1) == 1)
                {
                    n++;
                    y--;
                }
                else if(isOppPlayer(x, y-1) == 0)
                {
                    break;
                }
                else
                {
                    n = 0;
                    break;
                }
            }while(true);
        
        return n;
    }
    
    private int testNW(int x, int y)
    {
        int n = 0;
        do
            {
                if(isOppPlayer(x-1, y-1) == 1)
                {
                    n++;
                    x--;
                    y--;
                }
                else if(isOppPlayer(x-1, y-1) == 0)
                {
                    break;
                }
                else
                {
                    n = 0;
                    break;
                }
            }while(true);
        
        return n;
    }
    
    private int testW(int x, int y)
    {
        int n = 0;
        do
            {
                if(isOppPlayer(x-1, y) == 1)
                {
                    n++;
                    x--;
                }
                else if(isOppPlayer(x-1, y) == 0)
                {
                    break;
                }
                else
                {
                    n = 0;
                    break;
                }
            }while(true);
        
        return n;
    }
    
    private int testSW(int x, int y)
    {
        int n = 0;
        do
            {
                if(isOppPlayer(x-1, y+1) == 1)
                {
                    n++;
                    x--;
                    y++;
                }
                else if(isOppPlayer(x-1, y+1) == 0)
                {
                    break;
                }
                else
                {
                    n = 0;
                    break;
                }
            }while(true);
        
        return n;
    }
    
    private int testS(int x, int y)
    {
        int n = 0;
        do
            {
                if(isOppPlayer(x, y+1) == 1)
                {
                    n++;
                    y++;
                }
                else if(isOppPlayer(x, y+1) == 0)
                {
                    break;
                }
                else
                {
                    n = 0;
                    break;
                }
            }while(true);
        
        return n;
    }
    
    private int testSE(int x, int y)
    {
        int n = 0;
        do
            {
                if(isOppPlayer(x+1, y+1) == 1)
                {
                    n++;
                    x++;
                    y++;
                }
                else if(isOppPlayer(x+1, y+1) == 0)
                {
                    break;
                }
                else
                {
                    n = 0;
                    break;
                }
            }while(true);
        
        return n;
    }
    
    public void makeMove(AvailableLocation al)
    {
        int x = al.getX();
        int y = al.getY();
        int[] compass = al.getCompass();
        placeToken(x, y, currentPlayer);
        for(int i = 0; i < 8; i++)
        {
            makeMoveHelper(x, y, i, compass[i]);
        }

    }
    
    private void placeToken(int x, int y, Boolean cP){
        if(cP == Boolean.TRUE)
        {
            sk.addPointBlack();
        }
        else if(cP == Boolean.FALSE)
        {
            sk.addPointWhite();
        }
        sk.nextTurn();
        board.placeToken(x, y, cP);
    }
    
    private int makeMoveHelper(int x, int y, int dir, int pnt)
    {
        if(pnt > 0)
        {
            pnt--;
            if(dir == 0)
            {
                x++;
            }
            if(dir == 1)
            {
                x++;
                y--;
            }
            if(dir == 2)
            {
                y--;
            }
            if(dir == 3)
            {
                x--;
                y--;
            }
            if(dir == 4)
            {
                x--;
            }
            if(dir == 5)
            {
                x--;
                y++;
            }
            if(dir == 6)
            {
                y++;
            }
            if(dir == 7)
            {
                x++;
                y++;
            }
            flipToken(x, y);
            return makeMoveHelper(x, y, dir, pnt);
        }
        return 0;
        
    }
    
    private void flipToken(int x, int y)
    {
        board.flipToken(x, y);
        if(board.getToken(x, y) == Boolean.TRUE)
        {
            sk.addPointBlack();
            sk.remPointWhite();
        }
        else
        {
            sk.remPointBlack();
            sk.addPointWhite();
        }
    }
    /** Locates information to the current player.
     *  
     * @param x - The x coord on the board
     * @param y - The y coord on the board
     * @return - returns -2 for out of bounds, returns -1 for null, 0 for current player, and 1 for opposite player
     */
    private int isOppPlayer(int x, int y)
    {
        if(x < 0 || y < 0 || x >= size || y >= size)
            return -2;
        
        if(board.getToken(x, y) == currentPlayer)
                {
                    return 0;
                }
                else if(board.getToken(x, y) == null)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
    
    }
    public Boolean getPlayer()
    {
        return currentPlayer;
    }
    
    public OthelloScoreKeeper passScoreKeeper()
    {
        return sk;
    }
    
    public String printAvailable()
    {
        String temp = "";
        for(int i = 0; i < validLoc.size(); i++)
        {
            temp += i+" : "+validLoc.get(i).getDetails() + "\n";
        }
        
        return temp;
    }
    
    public boolean endGameTest()
    {
        int currentMove = validLoc.size();
        swapPlayer();
        validLoc.clear();
        findValidLocations();
        int nextMove = validLoc.size();
        swapPlayer();
        validLoc.clear();
        findValidLocations();
        
        if(currentMove == 0 && nextMove == 0)
        {
            sk.setEndOfGame();
            return true;
        }
        return false;
        
        
    }
    
    public String printBoard()
    {
        return board.toString();
    }
    
    
}
