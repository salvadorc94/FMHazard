/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.objects;

import hazard.framework.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author jaiel
 */

//-----------Class is for testing purposes only-----------
public class Block extends GameObject{


    public Block(float x, float y, ObjectId id){
        super(x,y,id);
        
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 50, 50);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 50, 50);
    }
    
    
}
