package Ui;

import Frameworks.Location;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import Piece.*;
import java.util.List;



public class Canvas extends java.awt.Canvas{

    public Canvas(int w, int h) {
        
        this.setBounds(0, 0, w, h);
        
        
        MouseInput mi  = new MouseInput();
        
        this.addMouseListener(mi);
        
        
    }
    
    
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {

            this.createBufferStrategy(3);
            return;

        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        //tuval temizliği
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        //

        //İŞLEMLER
        // START
        
        Board temp = chess.Chess.board;
        
        Font myFont = new Font (g.getFont().getFontName(), 1, 50);
        g.setFont(myFont);
        
        temp.render(g);
        
        if(showPotentials)
            renderPotentials(g);
        
        
        Piece tempPiece = Piece.getSelected();
        if(tempPiece!=null){
            
            g.setColor(Color.BLUE);
            g.drawRect(tempPiece.getRenderX(), tempPiece.getRenderY(), Board.width, Board.width);
            
        }
        
        
        // STOP
        
        g.dispose();

        bs.show();
    }
    
    
    
    private boolean showPotentials = true;
    
    public void renderPotentials(Graphics g){
        
        if(Piece.getSelected()==null)return;
        
        List<Location> list = Piece.getSelected().getPotentials();
        
        if(Piece.getSelected().getPotentials()==null)return;
        
        for (int i = 0; i < list.size(); i++) {
            
            g.setColor(Color.BLUE); 
            Graphics2D g2d =(Graphics2D)g;
            g.fillRect(list.get(i).getX()*Board.width,list.get(i).getY()*Board.width,Board.width,Board.width);
            
        }
        
        
    }
    
    
}
