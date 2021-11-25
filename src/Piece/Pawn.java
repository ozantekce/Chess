package Piece;

import Frameworks.ID;
import Frameworks.Location;
import Frameworks.Map;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;




public class Pawn extends Piece{
    
    public Pawn(int x, int y, ID id,int color) {
        super(x, y, id,color);
        
        setPathBlack("res/Pawn_black.png");
        setPathWhite("res/Pawn_white.png");
        if(color==-1){
            readWhitePiece();
        }
        else if(color==1){
            readBlackPiece();
        }
        
    }

    

    private boolean firstTime=true;
    

    

    @Override
    public boolean move(int tx,int ty, Map m) {
        
        boolean temp = super.move(tx,ty,m);
        
        if(temp){
                firstTime = false;

            if(getColor()==-1){
                if(ty==0){

                    m.getLocation(tx, ty).setP(new Queen(tx, ty, ID.Queen, -1));
                }
            }
            else{
                if(ty==7){

                    m.getLocation(tx, ty).setP(new Queen(tx, ty, ID.Queen, +1));
                }
            }
        }
        return temp;
    }

    @Override
    protected boolean characteristicRules(int tx, int ty, Map m) {
        
        if(tx>7||tx<0||ty>7||ty<0)
            return false;
        
        int differencex = tx-getX();
        int differencey = ty-getY();
        
        if(getColor()==1){
            
            boolean c1 = differencey ==1 && differencex==0 && collapse(tx, ty, m)==0;
            boolean c2 = differencey ==2 && differencex==0 && firstTime && collapse(tx, ty, m)==0;
            boolean c3 = differencey ==1 && differencex==1 && collapse(tx,ty,m)==1;
            boolean c4 = differencey ==1 && differencex==-1 && collapse(tx,ty,m)==1;
            
            return c1||c2||c3||c4;
            
        }
        else{
            boolean c1 = differencey ==-1 && differencex==0 && collapse(tx, ty, m)==0;
            boolean c2 = differencey ==-2 && differencex==0 && firstTime && collapse(tx, ty, m)==0;
            boolean c3 = differencey ==-1 && differencex==1 && collapse(tx,ty,m)==1;
            boolean c4 = differencey ==-1 && differencex==-1 && collapse(tx,ty,m)==1;
            
            return c1||c2||c3||c4;
        }
        
    }
    
    
    
    
    
    
}
