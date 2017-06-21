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
public class Dodger extends GameObject{
    /*
    Dodger moves along a straight line in a cosinusidal motion
    */
    private final Vector position1;
    private final Vector position2;
    private double AMPX;
    private double AMPY;
    private double OFFSETX;
    private double OFFSETY;
    private boolean onTrack=false;
    private int ticks;
    
    
    public Dodger(double ix, double iy, double finalx, double finaly, double length){
        super(ix,iy,ObjectId.Dodger);
        this.position2=new Vector(finalx,finaly);
        Vector tempvec=position2.minus(super.pos);
        tempvec.setlength(tempvec.getlength()-length);
        this.position1=super.pos.plus(tempvec);
        
        this.AMPX=(super.pos.x-position2.x)/2;
        this.AMPY=(super.pos.y-position2.y)/2;
        this.OFFSETX=super.pos.x-AMPX;
        this.OFFSETY=super.pos.y-AMPY;
        
        System.out.println("pos: "+pos.x+","+pos.y);
        System.out.println("pos1: "+position1.x+","+position1.y);
        System.out.println("pos2: "+position2.x+","+position2.y);
    }
    public Dodger(Vector ipos, Vector finalpos, double length){
        super(ipos,ObjectId.Dodger);
        Vector tempvec=finalpos.minus(ipos);
        tempvec.setlength(tempvec.getlength()-length);
        this.position1=super.pos.plus(tempvec);
        this.position2=finalpos;
        
        this.AMPX=(super.pos.x-position2.x)/2;
        this.AMPY=(super.pos.y-position2.y)/2;
        this.OFFSETX=super.pos.x-AMPX;
        this.OFFSETY=super.pos.y-AMPY;
        
    }
    
    public Dodger(Vector ipos,Vector initialpos, Vector finalpos){
        super(ipos,ObjectId.Dodger);
        this.position1=finalpos;
        this.position2=initialpos;
        
        this.AMPX=(super.pos.x-position2.x)/2;
        this.AMPY=(super.pos.y-position2.y)/2;
        this.OFFSETX=super.pos.x-AMPX;
        this.OFFSETY=super.pos.y-AMPY;
        
    }
    
    @Override
    public void tick(LinkedList<GameObject> objects) {
        if(!onTrack&&super.pos.equals(this.position2)){
            this.AMPX=(position2.x-position1.x)/2;
            this.AMPY=(position2.y-position1.y)/2;
            this.OFFSETX=position2.x-AMPX;
            this.OFFSETY=position2.y-AMPY;
            ticks=0;
            this.onTrack=true;
        }
        super.pos.x=AMPX*Math.cos(ticks*0.005*Math.PI)+OFFSETX;
        super.pos.y=AMPY*Math.cos(ticks*0.005*Math.PI)+OFFSETY;
        ticks++;
    }

    
    
    
    
    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.magenta);
        g.fillOval((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
        g.setColor(Color.red);
        g.drawRect((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)super.pos.x-25, (int)super.pos.y-25, 50, 50);
    }
    
}
