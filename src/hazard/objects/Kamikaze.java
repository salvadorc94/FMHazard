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
import java.util.LinkedList;
/**
 *
 * @author jaiel
 */
public class Kamikaze extends GameObject{
    /*
    Kamikaze rams right into the player
    */
    
    //max velocity and aceleration rate of follower
    private static final double ACEL=0.1;
    private static final double MAXVEL=4;
    
    
    public Kamikaze(double ix, double iy){
        super(ix,iy,ObjectId.Kamikaze);
        
    }
    public Kamikaze(Vector ipos){
        super(ipos,ObjectId.Kamikaze);
    }
    
    public Kamikaze(double ix, double iy, double ivelX, double ivelY){
        super(ix,iy,ObjectId.Kamikaze);
        super.vel=new Vector(ivelX, ivelY);      
    }
    public Kamikaze(Vector ipos, Vector ivel){
        super(ipos,ObjectId.Kamikaze);
        super.vel=ivel;
    }
    
    
    @Override
    public void tick(LinkedList<GameObject> objects) {
        super.vel.plus(Game.PLAYER.getPosition().minus(super.pos).setlength(ACEL),true);
        if(super.vel.getlength()>MAXVEL)
            super.vel.setlength(MAXVEL);
        super.pos.plus(super.vel, true);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.orange);
        g.fillOval((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
        g.setColor(Color.red);
        g.drawRect((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
    }
    
}
