package chess;

import Frameworks.Map;
import Piece.*;
import Ui.*;
public class Chess {

    
    
    public static void main(String[] args) throws InterruptedException {
        
        
        Chess c = new Chess();
        
    }

    
    
    static public Map m = new Map();
    
    static public Board board;
    
    
    static public boolean gameover = false;
    
    public Chess() throws InterruptedException {
        
        
        m.resetBoard();
        
        board = new Board(m.getBoard());
        
        MainFrame frame = new MainFrame("Chess", 600, 600);
        
        frame.setRun(true);
        
        frame.Start();
        
        m.printBoard();
        
        
        
        
    }

    public static Board getBoard() {
        return board;
    }

    public static Map getMap() {
        return m;
    }
    
    
    
    
    
    
    
}
