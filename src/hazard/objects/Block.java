/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.objects;

import hazard.framework.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author jaiel
 */

//-----------Class is for testing purposes only-----------
public class Block extends GameObject{


    public Block(double x, double y){
        super(x,y,ObjectId.Block);
        
    }
    @Override
    public void tick(LinkedList<GameObject> objects) {
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect((int)super.pos.x, (int)super.pos.y, 50, 50);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)super.pos.x, (int)super.pos.y, 50, 50);
    }
    
    
}
