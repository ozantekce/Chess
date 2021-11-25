package Ui;

import Frameworks.Location;
import java.awt.Graphics;


public class Board {
    
    
    private Spot spots [][];
    
    public static final int width = 70;
    
    public Board(Location [][] board) {
        
        spots = new Spot[board.length][];
        
        
        for (int i = 0; i < board.length; i++) {
            
            spots [i] = new Spot[ board[i].length];
            for (int j = 0; j < board[i].length; j++) {
                
                spots[i][j] = new Spot(i, j, board[i][j]);
                
            }
            
        }
        
    }
    
    
    public void render(Graphics g){
        
        
        for (int i = 0; i < spots.length; i++) {
            
            for (int j = 0; j < spots[i].length; j++) {
                
                
                
                spots[i][j].render(g);
                
            }
            
        }
        
    }
    
    
}
