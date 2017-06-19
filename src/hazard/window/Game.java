/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.window;

import hazard.framework.Vector;
import hazard.objects.*;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author jaiel
 */
public class Game extends JPanel implements Runnable{
    
    private boolean running = false;
    private Thread thread;
    
    public static int WIDTH, HEIGHT;
    Handler handler;
    public static Player PLAYER;
    
    
    
    //  Inits all objects (all objects extend from GameObject)
    private void init(){
        WIDTH=getWidth();
        HEIGHT=getHeight();
        handler=new Handler();
        //handler.createRandomBlocks();
        PLAYER=new Player(WIDTH/2,HEIGHT/2);
        handler.addObject(PLAYER);
        ArrayList<Vector> pth= new ArrayList();
        pth.add(new Vector(700,300));
        handler.addObject(new Chaser(700,0,pth));
        handler.addObject(new Kamikaze(0,0, 1,2));
        handler.addObject(new Asteroid(PLAYER.getPosition(true)));
                
    }
    
    
    
    public synchronized void start(){
        if(running) //failsafe checking
            return;
        
        running = true;
        
        thread=new Thread(this);
        thread.start();
    }
    
    
    
    @Override
    public void run(){
        
        /*----------GAME LOOP-----------
            This game loop sets how many times is the game's state to be updated.
            While the fps is set to be as fast as posible (to get the games state
            and render it on screen).
        */
        final boolean isLinux=System.getProperty("os.name").equals("Linux");
        
        init(); //inits objects and handler
        this.requestFocus();
        long lastTime=System.nanoTime();
        double amountOfTicks=60.0;      //How many times to update the game state (update = tick)
        double ns=1000000000/amountOfTicks;
        double delta=0;
        long timer=System.currentTimeMillis();
        int updates=0;
        int frames=0;
        while(running){
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns; //add to delta how many frames have elapsed
            lastTime=now;
            while(delta>=1){    //while there are 'complete' frames to be rendered
                tick();
                updates++;
                delta--;
            }

            repaint();
            //Window Lagging on Linux (have faith)
            //https://stackoverflow.com/questions/33257540/java-window-lagging-on-ubuntu-but-not-windows-when-code-isnt-lagging
            if(isLinux)
                Toolkit.getDefaultToolkit().sync();
                   
            frames++;
            
            
            if(System.currentTimeMillis()-timer >1000){
                timer+=1000;
                
                System.out.println("FPS: "+frames+" TICKS: "+updates);

                frames=0;
                updates=0;
            }
        }
        
    }
    
    private void tick(){    //Update the game's state (Objects);
        handler.tick();
    }
    
    
    @Override
    public void paint(Graphics ctx){    //Update the game's representation (Screen)
        super.paint(ctx);
        ctx.setColor(Color.black);
        ctx.fillRect(0, 0, WIDTH, HEIGHT);
            
        handler.render((Graphics2D) ctx);
        ctx.dispose();
        
    }

    
    public static void main(String args[]){
        
        new Window(800,600,"5-Min Hazard ", new Game());
    }
}
