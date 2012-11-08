/*
 * BoardModel Class is a 'dumb' data object to be controlled by the 
 * 'BoardController' class. BoardModel will contain basic functions such as
 * Flip, Report Location, and Place a Peice.
 * 
 * 
 * 
 */
package Othello_p;

/**
 *
 * @author Chris Wells
 */
public class MOD_Board 
{
    //The array represents the Gird of the Board.
    private int size = 8;
    private Boolean[][] square;
    //Boolean Null = Empty
    //Boolean True = Player One
    //Boolean False = Player Two
    
    public MOD_Board()
    {
        square = new Boolean[size][size];
    }
    
    public MOD_Board(int evenNumber)
    {
        size = evenNumber;
        square = new Boolean[size][size];
    }
    
//    public BoardModel(int s)
//    {
//        square = new Boolean[s][s];
//    }
    
    public Boolean getToken(int x, int y)
    {
        return square[x][y];
    }
    
    public void flipToken(int x, int y)
    {
        if(square[x][y] == null)
            return;
        square[x][y] = !square[x][y];
    }
    
    public void placeToken(int x, int y, Boolean token)
    {
            square[x][y] = token;
    }
    
    @Override
    public String toString()
    {
        String temp = "";
        for(int y = 0; y < size; y++)
        {
            for(int x = 0; x < size; x++)
            {
                temp += " >";
                if(square[x][y] == Boolean.TRUE)
                    temp += "B";
                else if(square[x][y] == Boolean.FALSE)
                    temp += "W";
                else
                    temp += "_";
            }
            temp += "\n";
        }
        return temp;
    }
    
}
