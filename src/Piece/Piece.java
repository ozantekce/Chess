package Piece;

import Frameworks.ID;
import Frameworks.Location;
import Frameworks.Map;
import java.util.ArrayList;
import java.util.List;
import chess.*;
import Ui.*;
import Piece.*;
import Frameworks.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public abstract class Piece {
    
    // white -1
    // black +1

    private int color;
    
    private int x;
    private int y;
    
    private ID id;
    
    private int value;
    
    private boolean alive;
    
    private String pathWhite;
    private String pathBlack;
    
    public Piece(int x,int y,ID id, int color) {
        
        this.x = x;
        this.y = y;
        this.id = id;
        this.color = color;
        this.alive=true;
        
        this.renderX = x * Board.width;
        this.renderY = y * Board.width;
        
        
        
    }

    public void setPathBlack(String pathBlack) {
        this.pathBlack = pathBlack;
    }

    public void setPathWhite(String pathWhite) {
        this.pathWhite = pathWhite;
    }

    
    private void kill(){
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }
    
    
    
    
    protected boolean canMove(int tx,int ty,Map m){
        
        if(!characteristicRules(tx,ty,m)){
            return false;
        }
        else if(this.id == id.Knight){
            return true;
        }
        
        
        
        
        Location l = m.getLocation(tx, ty);
            
            for (int a = x,b = y;a!=l.getX() || b!=l.getY();) {
                
                if(a!=l.getX()){
                    if(a>l.getX())
                        a--;
                    else
                        a++;
                }
                if(b!=l.getY()){
                    if(b>l.getY())
                        b--;
                    else
                        b++;
                }
                
                if(a==l.getX()&&b==l.getY())break;
                
                if(collepse(m.getLocation(a, b), m)!=null){
                    return false;
                }
                
            }
            
            if(collepse(l, m)==null) return true;
            
            if(collepse(l, m).getColor()==this.color){
                return false;
            }
            else if (collepse(l, m).getColor()!=0){
                return true;
            }
            
        
        
        
        return false;
    }
    
    public boolean move(int tx ,int ty,Map m){
        
        
        
        if(canMove(tx,ty,m)){
            
            Piece del = m.getLocation(tx, ty).getP();
            
            if(del!=null){
                del.kill();
            }
            
            m.getLocation(x, y).setP(null);
            
            this.x = tx;
            this.y = ty;
            
            m.getLocation(tx, ty).setP(this);
            
            
            m.setMoveListen();
            
            
            calculateRenderXY();
            return true;
        }
        else{
            
            
            calculateRenderXY();
            return false;
            
            
        }
        
    }
    
    
    
    protected Piece collepse(Location l, Map m) {
        
        return m.getLocation(l.getX(), l.getY()).getP();
        
    }
    
    protected Piece collepse(int tx,int ty, Map m) {
        
        return m.getLocation(tx, ty).getP();
        
    }
    
    
    protected int collapse(Location l, Map m){
        
        if(collepse(l, m)==null)return 0;
        else if(collepse(l, m).getColor()!=getColor())return 1;
        
        return -1;
        
    }
    
    // 0 çarpışma yok 1 düşmanla çarpışma var -1 dostla çarpışma var
    protected int collapse(int tx,int ty, Map m){
        
        if(collepse(tx,ty,m)==null)return 0;
        else if(collepse(tx,ty,m).getColor()!=getColor())return 1;
        
        return -1;
        
    }
    
    
    
    
    protected abstract boolean characteristicRules(int tx,int ty,Map m);
    
    
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public ID getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    
    public List<Location> getPotentials(){
        
        List<Location> potentials = new ArrayList<>();
        
        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 8; j++) {
                
                if(canMove(i, j, chess.Chess.getMap())){
                    
                    potentials.add(chess.Chess.getMap().getLocation(i, j));
                    
                    
                    
                }
                
            }
            
        }
        
        return potentials;
        
    }
    
    
    
    
    
    
    private static Piece selected = null;
    
    public boolean isSelected(Piece temp) {
        
        return temp==selected;
        
    }

    public void setSelected() {
        
        Piece.selected = this;
        
    }

    public static void resetSelected(){
        selected = null;
    }
    
    public static Piece getSelected() {
        return selected;
    }
    
    public boolean thisSeleceted() {
        
        return this==selected;
        
    }
    
    
    
    
    private int renderX;
    private int renderY;
    
    
    
    
    public int getRenderX() {
        return renderX;
    }

    public int getRenderY() {
        return renderY;
    }
    
    
    protected void calculateRenderXY(){
        
        this.renderX = x * Board.width;
        this.renderY = y * Board.width;
        
    }
    
    
    
    
    private BufferedImage white;
    
    protected void readWhitePiece(){
        
        String path=pathWhite;
        File file = new File(path);
        
        try {
            white = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        image = white;
        
    }
    
    
    
    private BufferedImage black;
    
    protected void readBlackPiece(){
        
        String path=pathBlack;
        File file = new File(path);
        
        try {
            black = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        image = black;
    }
    
    

    
    private BufferedImage image;
    
    public void render(Graphics g) {
        
        
        g.drawImage(image, (int)getRenderX(),(int) getRenderY(), null);
        
        
    }
    
    
    
}
