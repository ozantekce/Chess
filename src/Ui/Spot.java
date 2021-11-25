package Ui;
import Piece.*;
import Frameworks.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Spot {
    
    
    private int x;
    private int y;   
    
    private Location location;
    
    
    
    
    public Spot(int x, int y,Location location) {
        this.x = x*Board.width;
        this.y = y*Board.width;
        this.location = location;
        
    }

    
    public void render(Graphics g){
        
        if(location.getP()!=null){
            location.getP().render(g);
        }
        
        g.setColor(Color.BLACK);
        g.drawRect(x, y, Board.width, Board.width);
        
    }

    
    
    
    
    
    
    
}
