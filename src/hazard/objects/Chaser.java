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
    
    //max velocity and aceleration rate of follower
    private static final double ACEL=0.02;
    private static final double MAXVEL=1.7;
    private static final double MINDIST=15;
    private boolean stopping=false;
    protected ArrayList<Vector> path;
    protected int nextpos=0;
    
    
    public Chaser(double ix, double iy){
        super(ix,iy,ObjectId.Chaser);
        
    }
    public Chaser(Vector ipos){
        super(ipos,ObjectId.Chaser);
    }
    
    public Chaser(double ix, double iy, ArrayList<Vector> path){
        super(ix,iy,ObjectId.Chaser);
        this.path=path;
        
    }
    public Chaser(Vector ipos, ArrayList<Vector> path){
        super(ipos,ObjectId.Chaser);
        this.path=path;
    }
    
    
    public void setPath(ArrayList<Vector> path){
        this.path=path;
    }
    
    
    @Override
    public void tick(LinkedList<GameObject> objects) {
        if(stopping){
            if(super.vel.getlength()>0.3){
                super.vel.minus(super.getVelocity(true).setlength(ACEL), true);
            }
            else{
                stopping=false;
            }
        }
        else{
            if(this.nextpos==path.size()){
                this.path.add(Game.PLAYER.getPosition(true));
            }

            super.vel.plus(this.path.get(nextpos).minus(super.pos).setlength(ACEL),true);
            if(super.vel.getlength()>MAXVEL)
                super.vel.setlength(MAXVEL);


            if(this.path.get(nextpos).minus(super.pos).getlength()<MINDIST){
                this.stopping=true;
                this.nextpos++;
            }
        }
        super.pos.plus(super.vel, true);
             
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
