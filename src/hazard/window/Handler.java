/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.window;


import java.util.LinkedList;

import hazard.framework.GameObject;
import hazard.objects.*;
import java.awt.Graphics2D;

/**
 *
 * @author jaiel
 */
public class Handler {
    Player player;
    public LinkedList<GameObject> objects = new LinkedList();
    
    private GameObject tempObject;
    
    public void tick(){
        for(GameObject o:objects){            
            o.tick(objects);
        }
    }
    
    public void render(Graphics2D g){
        for(GameObject o: objects){            
            o.render(g);
        }
    }
    
    public void addObject(GameObject object){
        
        this.objects.add(object);
    }
    
    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
    
    
    //This method is for testing purposes only 
    public void createRandomBlocks()
    {
        for(int i=0;i<40;i++)
        addObject(new Block((float)Math.random()*800,(float)Math.random()*600));

    }
    
}
