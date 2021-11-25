package Piece;

import Frameworks.ID;
import Frameworks.Map;
import java.awt.Graphics;




public class Rook extends Piece {

    public Rook(int x, int y, ID id,int color) {
        super(x, y, id,color);
        setPathBlack("res/Rook_black.png");
        setPathWhite("res/Rook_white.png");
        if(color==-1){
            readWhitePiece();
        }
        else if(color==1){
            readBlackPiece();
        }
        
    }

    @Override
    protected boolean characteristicRules(int tx, int ty, Map m) {
        
        if(tx>7||tx<0||ty>7||ty<0)
            return false;
        
        int differencex = tx-getX();
        int differencey = ty-getY();
        
        
        boolean c5 = differencex==0 && differencey>0
                && collapse(tx, ty, m)!=-1;
        boolean c6 = differencex==0 && differencey<0
                && collapse(tx, ty, m)!=-1;
        boolean c7 = differencex>0 && differencey==0
                && collapse(tx, ty, m)!=-1;
        boolean c8 = differencex<0 && differencey==0
                && collapse(tx, ty, m)!=-1;
        
        
        return c5||c6||c7||c8;
    }
    
    
    
    
}
