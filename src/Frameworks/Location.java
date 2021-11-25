package Frameworks;

import Piece.Piece;
import java.awt.Graphics;



public class Location {
    
    private int x;
    private int y;

    public Location(int x, int y, Piece p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }
    
    
    
    
    private Piece p;
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setP(Piece p) {
        this.p = p;
    }

    public Piece getP() {
        return p;
    }

    @Override
    public String toString() {
        return x+"|"+y;
    }
    
    
    
    
    
}
