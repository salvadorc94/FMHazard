/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author jaiel
 */
public abstract class GameObject {
    protected float x,y;
    protected ObjectId id;
    protected float velX=0, velY=0;
    
    public GameObject(float x, float y, ObjectId id){
        this.x=x;
        this.y=y;
        this.id=id;
    }
    
    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    
    public float getX() {
        return this.x;
    }
    
    public float getY() {
        return this.y;
    }

    public void setX(float x) {
        this.x=x;
    }

    public void setY(float y) {
        this.y=y;
    }

    
    
    
    
    public float getVelX() {
        return this.velX;
    }

    public float getVelY() {
        return this.velY;
    }

    public void setVelX(float velX) {
        this.velX=velX;
    }

    public void setVelY(float velY) {
        this.velY=velY;
    }

    
    public ObjectId getId() {
        return this.id;
    }
}
