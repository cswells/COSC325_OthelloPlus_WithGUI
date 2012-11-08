/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Othello_p;

/**
 *
 * @author Chris Wells
 */
public class AvailableLocation 
{
    int xCoord;
    int yCoord;
    int[] intCompass;

    public AvailableLocation(int x, int y, int[] comp) 
    {
        xCoord = x;
        yCoord = y;
        intCompass = comp;
    }
    
    public int getX()
    {
        return xCoord;
    }
    
    public int getY()
    {
        return yCoord;
    }
    
    public int[] getCompass()
    {
        return intCompass;
    }
    
    public int getCompassTotal()
    {
        int t = 0;
        for(int i = 0; i < 8; i++)
        {
            if(intCompass[i] > 0)
                t += intCompass[i];
        }
        return t;
    }
    
    public String getDetails()
    {
        String tempInt = "";
        for(int i = 0; i < 8; i ++)
        {
            tempInt += intCompass[i];
        }
        
        return "("+xCoord+", "+yCoord+") --> "+tempInt;
    }
    
}
