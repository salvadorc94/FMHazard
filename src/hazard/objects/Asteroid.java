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
public class Asteroid extends GameObject{
    /*
    Asteroid follows a fixed direction towards a randomly set position at its constructor
    */
    
    //max and min velocity of any asteroid
    private static final int MINVEL=1;
    private static final int MAXVEL=3-MINVEL;
    
    
    public Asteroid(double ix, double iy){
        super(ix,iy,ObjectId.Asteroid);
        super.vel=(new Vector(Game.WIDTH*Math.random(),Game.HEIGHT*Math.random())).minus(super.pos,true);
        super.vel.setlength(MAXVEL*Math.random()+MINVEL);
        
    }
    public Asteroid(Vector ipos){
        super(ipos,ObjectId.Asteroid);
        super.vel=(new Vector(Game.WIDTH*Math.random(),Game.HEIGHT*Math.random())).minus(super.pos,true);
        super.vel.setlength(MAXVEL*Math.random()+MINVEL);
    }
    
    @Override
    public void tick(LinkedList<GameObject> objects) {
        super.pos.plus(super.vel, true);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.gray);
        g.fillOval((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
        g.setColor(Color.red);
        g.drawRect((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
    }
    
}