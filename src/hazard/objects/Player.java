/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.objects;

import hazard.framework.GameObject;
import hazard.framework.ObjectId;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author jaiel
 */
public class Player extends GameObject{
    
    public Player(double ix, double iy){
        super(ix,iy,ObjectId.Player);
        
    }
    
    @Override
    public void tick(LinkedList<GameObject> objects) {
        
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.blue);
        g.fillOval((int)super.pos.x-10, (int)super.pos.y-10, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)super.pos.x-10, (int)super.pos.y-10, 20, 20);
    }
}
