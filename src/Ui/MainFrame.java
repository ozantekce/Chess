package Ui;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import chess.*;
import Ui.*;
import Piece.*;
import Frameworks.*;


public class MainFrame extends JFrame implements Runnable{
//w=300 h=600
    
    private MainPanel mp;
    
    
    
    
    public MainFrame(String name, int w, int h) throws HeadlessException {
        super(name);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(w+50, h+50);
        
        this.getContentPane().setLayout(null);
        
        mp = new MainPanel(w, h);

        this.getContentPane().add(mp);
        this.setVisible(true);
        
        
        
    }

    int gameSpeed=10;
    private Thread thread;
    private boolean run=false;
    
    @Override
    public void run() {
        
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(run){

         long now = System.nanoTime();
         delta += (now - lastTime) / ns;
         lastTime = now;

         while(delta >= 1){
          tick();
          
          
          updates++;
          delta--;

         }
         render();
         frames++;

         if(System.currentTimeMillis() - timer > 1000){
          timer += 1000;
          System.out.println("FPS: " + frames + " TICKS: " + updates);
          frames = 0;
          updates = 0;
         }


        }

    }
    
    
    
    public void Start() {
        thread = new Thread(this);
        thread.start();
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean isRun() {
        return run;
    }
    
    
    
    
    public void render(){
        
        mp.render();
        
    }

    
    
    public void tick(){
        
        Chess.m.tick();
        
    }
    
    
    
    
}
