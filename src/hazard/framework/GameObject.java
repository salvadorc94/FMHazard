/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.framework;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author jaiel
 */
public abstract class GameObject {
    protected Vector pos;
    protected ObjectId id;
    protected Vector vel=new Vector(0,0);
    
    public GameObject(Vector position, ObjectId id){
        this.pos=position;
        this.id=id;
    }
    public GameObject(double x, double y, ObjectId id){
        this.pos=new Vector(x,y);
        this.id=id;
    }
    
    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics2D g);
    public abstract Rectangle getBounds();
    
    
    public Vector getPosition(){
        return this.pos;
    }
    public Vector getPosition(boolean copy){
        if(copy)
            return new Vector(this.pos.x, this.pos.y);
        return this.pos;
    }
    
    public double getX() {
        return this.pos.x;
    }
    
    public double getY() {
        return this.pos.y;
    }

    
    public void setPosition(Vector position){
        this.pos=position;
    }
    
    public void setX(double x) {
        this.pos.x=x;
    }

    public void setY(double y) {
        this.pos.y=y;
    }

    
    
    public Vector getVelocity(){
        return this.vel;
    }
    public Vector getVelocity(boolean copy){
        if(copy)
            return new Vector(this.vel.x, this.vel.y);
        return this.vel;
    }
    
    public double getVelX() {
        return this.vel.x;
    }

    public double getVelY() {
        return this.vel.y;
    }

    
    
    public void setVelocity(Vector vel){
        this.vel=vel;
    }
    
    public void setVelX(double velX) {
        this.vel.x=velX;
    }

    public void setVelY(double velY) {
        this.vel.y=velY;
    }

    
    public ObjectId getId() {
        return this.id;
    }
}
