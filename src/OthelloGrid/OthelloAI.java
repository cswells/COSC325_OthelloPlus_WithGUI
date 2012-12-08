/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OthelloGrid;

import Othello_p.AvailableLocation;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Chris Wells
 */
public class OthelloAI {
    private Random rand;
    
    public OthelloAI()
    {
        
    }
    public AvailableLocation makeMove(ArrayList<AvailableLocation> al, int mode)
    {
        
        if(mode == 0){
            return makeEasyMove(al);
        }
        else if(mode == 1){
            return makeMedMove(al);
        }
        else if(mode == 2)
        {
            return makeHardMove(al);
        }else
        {
            return makeMedMove(al);
        }
            
        
        
    }
    
    public AvailableLocation makeEasyMove(ArrayList<AvailableLocation> al)
    {
        rand = new Random(System.nanoTime());
        ArrayList<AvailableLocation> low = new ArrayList<AvailableLocation>();
        
        if(al.size() > 0){
            low.add(al.get(0));
            
            if(al.size() > 1){
                for(int i = 0; i < al.size(); i++ )
                {
                    if(al.get(i).getAiValue() == low.get(0).getAiValue())
                    {
                        low.add(al.get(i));
                    }else if(al.get(i).getAiValue() < low.get(0).getAiValue() )
                    {
                        low.clear();
                        low.add(al.get(i));
                    }
                }
            }
            else //only one move to make
            {
                return low.get(0);
            }
        }else{
            //this should never happen
            return makeMedMove(al);
            
        }
        
        return low.get(rand.nextInt(low.size()));
        
    }
    
    public AvailableLocation makeMedMove(ArrayList<AvailableLocation> al)
    {
        rand = new Random(System.nanoTime());
        
        return al.get(rand.nextInt(al.size()));
    }
    
    public AvailableLocation makeHardMove(ArrayList<AvailableLocation> al)
    {
        rand = new Random(System.nanoTime());
        ArrayList<AvailableLocation> high = new ArrayList<AvailableLocation>();
        
        if(al.size() > 0){
            high.add(al.get(0));
            
            if(al.size() > 1){
                for(int i = 0; i < al.size(); i++ )
                {
                    if(al.get(i).getAiValue() == high.get(0).getAiValue())
                    {
                        high.add(al.get(i));
                    }else if(al.get(i).getAiValue() > high.get(0).getAiValue() )
                    {
                        high.clear();
                        high.add(al.get(i));
                    }
                }
            }
            else //only one move to make
            {
                return high.get(0);
            }
        }else{
            //this should never happen
            return makeMedMove(al);
            
        }
        
        return high.get(rand.nextInt(high.size()));
    }
}
