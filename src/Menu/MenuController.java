/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


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
    
    MainMenu mainMenu;
    Splash splash;
    
    public MenuController() {
        
        
        load();
        
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ex) {
//            System.out.println("Call it quits, you cant get a sleep");
//        }
//        
//        loadMainMenu();
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
    
    
}
