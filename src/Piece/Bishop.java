package Piece;

import Frameworks.ID;
import Frameworks.Map;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Bishop extends Piece {

    public Bishop(int x, int y, ID id,int color) {
        super(x, y, id,color);
        
        setPathBlack("res/Bishop_black.png");
        setPathWhite("res/Bishop_white.png");
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
        
        boolean c1 = differencex>0 && differencey<0 && differencex == (-1*differencey)
                && collapse(tx, ty, m)!=-1;
        
        boolean c2 = differencex<0 && differencey<0 && differencex == (1*differencey)
                && collapse(tx, ty, m)!=-1;
        
        boolean c3 = differencex<0 && differencey>0 && differencex == (-1*differencey)
                && collapse(tx, ty, m)!=-1;
        
        boolean c4 = differencex>0 && differencey>0 && differencex == (1*differencey)
                && collapse(tx, ty, m)!=-1;
        
        
        
        
        return c1||c2||c3||c4;
    }
    
    
    
}
