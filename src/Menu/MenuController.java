/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.Dimension;


/**
 *
 * @author Chris Wells
 */
public class MenuController {

    //------------START MAIN-------------------
    public static void main(String args[]){
        MenuController mc = new MenuController();
    }
    
    
    //------------END MAIN---------------
    
    protected MainMenu mainMenu;
    protected GameWindow gameWin;
    protected boolean GameWindowOpen = false;
    private int Width = 800;
    private int Height = 640;
    public Dimension defaultSize;
    Splash splash;
    
    public MenuController() {
        defaultSize = new Dimension(Width, Height);
        
        load();
        
    }
    
    public int getHeight()
    {
        return Height;
    }
    
    public int getWidth()
    {
        return Width;
    }
    
    private void load()
    {
        splash = new Splash(this);
        splash.setVisible(true);
        
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println("Call it quits, you cant get a sleep");
        }
        
        splash.dispose();
        loadMainMenu();
        
        
    }
    
    
    public void loadMainMenu(){
        
        mainMenu = new MainMenu(this);
        mainMenu.setVisible(true);

    }
    
    public void closeMainMenu(){
        mainMenu.dispose();
    }
    
    public void loadGameWindow(){
        if(GameWindowOpen == false){
            gameWin = new GameWindow(this);
            GameWindowOpen = true;
        }
        gameWin.setVisible(true);

    }
    
    public void hideGameWindow(){
        gameWin.setVisible(false);
    }
    
    public void closeGameWindow(){
        gameWin.dispose();
    }
    
    
}
