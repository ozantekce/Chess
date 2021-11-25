package Ui;

import java.awt.Color;
import javax.swing.JPanel;



public class MainPanel extends JPanel{

    GamePanel gp; 
    //  ButtonPanel
    //  InfoPanel
    
    public MainPanel(int w,int h) {
        
        this.setBounds(0, 0, w+50, h+50);
        
        this.setLayout(null);
        
        gp = new GamePanel(w, h);
        
        this.add(gp);
        
        this.setBackground(Color.yellow);
        
    }
    
    
    public void render(){
        
        gp.render();
        
        
    }
    
    
    
}
