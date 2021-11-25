package Ui;

import Frameworks.Location;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Piece.*;
import java.util.List;
import chess.*;
import Ui.*;
import Piece.*;
import Frameworks.*;


public class MouseInput implements MouseListener{

    
    
    @Override
    public void mouseClicked(MouseEvent me) {

    }

    
    public static int x=-1;
    public static int y=-1;
    
    
    @Override
    public void mousePressed(MouseEvent me) {
        
        x = me.getX()/Board.width;
        y = me.getY()/Board.width;
        
      //  if(Chess.getMap().gameover()) return;
      //  Chess.getMap().select(x,y);
        
      Chess.getMap().setSelect();
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
