/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.objects;

import hazard.framework.GameObject;
import hazard.framework.ObjectId;
import hazard.framework.Vector;
import hazard.window.Game;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author jaiel
 */
public class Chaser extends GameObject{
    /*
    The Chaser follows a given set of positions (path)
    if it has already gone through all positions it sets the next position
    to the player's current position;
    */
    protected ArrayList<Vector> path;
    protected int nextpos=0;
    
    private double AMPX;
    private double AMPY;
    private double OFFSETX;
    private double OFFSETY;
    private int ticks;
    
    
    public Chaser(double ix, double iy){
        super(ix,iy,ObjectId.Chaser);
        this.path.add(Game.PLAYER.getPosition(true));
        CalcNextPos();
        
    }
    public Chaser(Vector ipos){
        super(ipos,ObjectId.Chaser);
        this.path.add(Game.PLAYER.getPosition(true));
        CalcNextPos();
    }
    
    public Chaser(double ix, double iy, ArrayList<Vector> path){
        super(ix,iy,ObjectId.Chaser);
        this.path=path;
        
        if(path.isEmpty()){
            this.path.add(Game.PLAYER.getPosition(true));
        }
        
        CalcNextPos();
        
    }
    public Chaser(Vector ipos, ArrayList<Vector> path){
        super(ipos,ObjectId.Chaser);
        this.path=path;
        
        if(path.isEmpty()){
            this.path.add(Game.PLAYER.getPosition(true));
        }
        
        CalcNextPos();
    }
    
    
    public void setPath(ArrayList<Vector> path){
        this.path=path;
    }
    
    private void CalcNextPos(){
        this.AMPX=(super.pos.x-this.path.get(nextpos).x)/2;
        this.AMPY=(super.pos.y-this.path.get(nextpos).y)/2;
        this.OFFSETX=super.pos.x-AMPX;
        this.OFFSETY=super.pos.y-AMPY;
        ticks=0;
    }
    
    @Override
    public void tick(LinkedList<GameObject> objects) {
        
        
        if(super.pos.equals(this.path.get(nextpos))){
            this.nextpos++;
            if(path.size()==nextpos){
                this.path.add(Game.PLAYER.getPosition(true));
            }
            //if super.pos=path.nextpos {collision}
            CalcNextPos();

        }
        super.pos.x=AMPX*Math.cos(ticks*0.005*Math.PI)+OFFSETX;
        super.pos.y=AMPY*Math.cos(ticks*0.005*Math.PI)+OFFSETY;
        ticks++;
        
        
       
             
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.yellow);
        g.fillOval((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
        g.setColor(Color.red);
        g.drawRect((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
    }
    
}
