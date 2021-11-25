package Ui;

import java.awt.Color;
import javax.swing.JPanel;




public class GamePanel extends JPanel{

    Canvas canvas;
    
    public GamePanel(int w, int h) {
        
        this.setBounds(20, 0, w, h);
        
        this.setLayout(null);
        
        canvas = new Canvas(w,h);
        
        this.add(canvas);
        
        this.setBackground(Color.gray);
        
    }
    
    
    
    public void render(){
        
        canvas.render();
        
    }
    
    
}
