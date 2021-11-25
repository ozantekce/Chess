package Frameworks;

import Piece.*;
import java.util.ArrayList;
import java.util.List;
import Frameworks.*;
import Ui.MouseInput;


public class Map {
    
    
    private  boolean turn = false;
    
    private boolean moveListen=false;
    
    private Location board [][] = new Location[8][8];

    
    
    
    public Map() {
        
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[i].length; j++) {
                
                board[i][j] = new Location(i,j,null);
                
            }
            
        }
        
        resetBoard();
        
        
    }
    
    private Piece kingw;
    private Piece kingb;
    
    private int wscore=0;
    private int bscore=0;
    
    public boolean gameover(){
        
        if(!kingb.isAlive())wscore++;
        if(!kingw.isAlive())bscore++;
        
        
        if(!kingb.isAlive()||!kingw.isAlive()){
            System.out.println(wscore);
            System.out.println(bscore);
            return true;
        }
        
        
        return false;
    }
    
    public void resetBoard(){
        
        turn =false;
        
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[i].length; j++) {
                
                board[i][j].setP(null);
                
            }
            
        }
        
        
        
        int whiteFirsty = board.length-2;
        
        int blackFirsty = 1;
        
        
        int whiteSecondy = board.length-1;
        
        int blackSecondy = 0;
        
        
        //PAWNS
        for (int i = 0; i < board.length; i++) {
            
            board[i][whiteFirsty].setP( new Pawn(i, whiteFirsty, ID.Pawn,-1) );
            
            board[i][blackFirsty].setP( new Pawn(i, blackFirsty, ID.Pawn, 1) );
            
        }
        
        //WHITE
        // ROOK
        board[0][whiteSecondy].setP(new Rook(0, whiteSecondy, ID.Rook, -1));
        board[board.length-1][whiteSecondy].setP(new Rook(board.length-1, whiteSecondy, ID.Rook, -1));
        
        //KNIGHT
        board[1][whiteSecondy].setP(new Knight(1, whiteSecondy, ID.Knight, -1));
        board[board.length-2][whiteSecondy].setP(new Knight(board.length-2, whiteSecondy, ID.Knight, -1));
        
        
        //Bishop
        board[2][whiteSecondy].setP(new Bishop(2, whiteSecondy, ID.Bishop, -1));
        board[board.length-3][whiteSecondy].setP(new Bishop(board.length-3, whiteSecondy, ID.Bishop, -1));
        
        // Queen and King
        board[3][whiteSecondy].setP(new Queen(3, whiteSecondy, ID.Queen, -1));
        board[board.length-4][whiteSecondy].setP(new King(board.length-4, whiteSecondy, ID.King, -1));
        
        
        
        
        //BLACK
        
        // ROOK
        board[0][blackSecondy].setP(new Rook(0, blackSecondy, ID.Rook, 1));
        board[board.length-1][blackSecondy].setP(new Rook(board.length-1, blackSecondy, ID.Rook, 1));
        
        //KNIGHT
        board[1][blackSecondy].setP(new Knight(1, blackSecondy, ID.Knight, 1));
        board[board.length-2][blackSecondy].setP(new Knight(board.length-2, blackSecondy, ID.Knight, 1));
        
        
        //Bishop
        board[2][blackSecondy].setP(new Bishop(2, blackSecondy, ID.Bishop, 1));
        board[board.length-3][blackSecondy].setP(new Bishop(board.length-3, blackSecondy, ID.Bishop, 1));
        
        // Queen and King
        board[3][blackSecondy].setP(new Queen(3, blackSecondy, ID.Queen, 1));
        board[board.length-4][blackSecondy].setP(new King(board.length-4, blackSecondy, ID.King, 1));
        
        
        kingb = board[board.length-4][blackSecondy].getP();
        
        kingw = board[board.length-4][whiteSecondy].getP();
        
    }
    
    
    public Piece getPiece(int a,int b){
        
        if(a>=8||b>=8||b<0||a<0)return null;
        
        return board[a][b].getP();
        
    }
    
    public Location getLocation(int a,int b){
        
        if(a>=8||b>=8||b<0||a<0)return null;
        
        return board[a][b];
        
    }
    
    
    public void printBoard(){
        
        for (int j = 0; j < board.length; j++) {
            
            for (int i = 0; i < board[j].length; i++) {
                
                System.out.print(" ");
                
                if(board[i][j].getP()==null){
                    System.out.print("  ");
                }
                
                else if(board[i][j].getP().getId()==ID.Pawn)
                    if(board[i][j].getP().getColor()==-1)    
                        System.out.print("♙");
                    else
                        System.out.print("♟");
                
                else if(board[i][j].getP().getId()==ID.Rook)
                    if(board[i][j].getP().getColor()==-1)    
                        System.out.print("♖");
                    else
                        System.out.print("♜");
                
                
                else if(board[i][j].getP().getId()==ID.Knight)
                    if(board[i][j].getP().getColor()==-1)    
                        System.out.print("♘");
                    else
                        System.out.print("♞");
                
                
                else if(board[i][j].getP().getId()==ID.Bishop)
                    if(board[i][j].getP().getColor()==-1)    
                        System.out.print("♗");
                    else
                        System.out.print("♝");
                
                else if(board[i][j].getP().getId()==ID.Queen)
                    if(board[i][j].getP().getColor()==-1)    
                        System.out.print("♕");
                    else
                        System.out.print("♛");
                
                else if(board[i][j].getP().getId()==ID.King)
                    if(board[i][j].getP().getColor()==-1)    
                        System.out.print("♔");
                    else
                        System.out.print("♚");
                
                
                
                System.out.print(" ");
                
            }
            System.out.println("");
        }
        
        
    }
    
    
    
    public List<Piece> getBlackList(){
        
        List<Piece> temp = new ArrayList<>();
        
        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 8; j++) {
                
                if(getPiece(i, j)!=null){
                    if(getPiece(i, j).getColor()==1){
                        temp.add(getPiece(i, j));
                    }
                }
                
            }
            
        }
        
        return temp;
    }
    
    
    
    public Location[][] getBoard() {
        return board;
    }
    
    
    public void resetMoveListen(){
        
        moveListen = false;
        
    }
    
    public void setMoveListen(){
        moveListen =true;
    }

    public boolean isMoveListen() {
        return moveListen;
    }
    
    
    public void changeTurn(){
        turn = !turn;
    }

    public boolean isTurn(int color) {
        
        boolean c1 = turn==false && color==-1;
        boolean c2 = turn && color==1;
        
        
        return c1||c2;
        
        
        
    }
    
    
    
    private boolean select=false;

    public void setSelect() {
        this.select = true;
    }
    
    private void resetSelect() {
        this.select = false;
    }
    
    
    public void select(int x,int y){
        
        resetSelect();
        
        Location location = getLocation(x, y);
        
        if(location==null){
            Piece.resetSelected();
            return;
        }
        
        Piece temp = location.getP();
        
        
        if(Piece.getSelected()==null){
            
            if(temp!=null){
                if(isTurn(temp.getColor())){
                    temp.setSelected();
                }
            }
            
            
        }
        else{
            
            
            if(Piece.getSelected().move(location.getX(), location.getY(), this)){
                 Piece.resetSelected();
            }
            else if(temp == null){
                
                Piece.resetSelected();
                
            }
            else if (temp.getColor()==Piece.getSelected().getColor()){
                
                temp.setSelected();
                
            }
            else{
                Piece.resetSelected();
            }
            
            
        }
        
        
        
    }
    
    
    
    public void tick(){
        
        
        
        if(gameover()){
            resetBoard();
        }
        else{
  
            boolean turn = this.turn;
            
            if(!turn){
                //white can move
                if(select)
                    select(MouseInput.x,MouseInput.y);
                
                if(isMoveListen()){
                    resetMoveListen();
                    changeTurn();
                }
                
                
            }
            else{
                
                
                if(select)
                    select(MouseInput.x,MouseInput.y);
                
                if(isMoveListen()){
                    resetMoveListen();
                    changeTurn();
                }
            }
            
            
            
        }
        
        
        
    }
    
    
    
    
}
