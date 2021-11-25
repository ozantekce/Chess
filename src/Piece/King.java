package Piece;

import Frameworks.ID;
import Frameworks.Map;
import java.awt.Graphics;




public class King extends Piece{

    public King(int x, int y, ID id,int color) {
        super(x, y, id,color);
        setPathBlack("res/King_black.png");
        setPathWhite("res/King_white.png");
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
        
        boolean c1 = differencex==1 && differencey==-1 && differencex == (-1*differencey)
                && collapse(tx, ty, m)!=-1;
        
        boolean c2 = differencex==-1 && differencey==-1 && differencex == (1*differencey)
                && collapse(tx, ty, m)!=-1;
        
        boolean c3 = differencex==-1 && differencey==1 && differencex == (-1*differencey)
                && collapse(tx, ty, m)!=-1;
        
        boolean c4 = differencex==1 && differencey==1 && differencex == (1*differencey)
                && collapse(tx, ty, m)!=-1;
        
        
        boolean c5 = differencex==0 && differencey==1
                && collapse(tx, ty, m)!=-1;
        boolean c6 = differencex==0 && differencey==-1
                && collapse(tx, ty, m)!=-1;
        boolean c7 = differencex==1 && differencey==0
                && collapse(tx, ty, m)!=-1;
        boolean c8 = differencex==-1 && differencey==0
                && collapse(tx, ty, m)!=-1;
        
        
        return c1||c2||c3||c4||c5||c6||c7||c8;
        
    }


    
}
