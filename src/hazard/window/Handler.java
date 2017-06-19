/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.window;


import java.util.LinkedList;

import hazard.framework.GameObject;
import hazard.framework.ObjectId;
import hazard.objects.Block;
import java.awt.Graphics;

/**
 *
 * @author jaiel
 */
public class Handler {
    
    public LinkedList<GameObject> object = new LinkedList();
    
    private GameObject tempObject;
    
    public void tick(){
        for(GameObject o:object){            
            o.tick(object);
        }
    }
    
    public void render(Graphics g){
        for(GameObject o: object){            
            o.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    //This method is for testing purposes only 
    public void createRandomBlocks()
    {
        for(int i=0;i<40;i++)
        addObject(new Block((float)Math.random()*800,(float)Math.random()*600,ObjectId.Block));

    }
    
}
