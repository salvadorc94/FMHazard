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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author Gerard
 */
public class Fondo extends GameObject {
    private Image fondo;
    private double dx=1400,dy=1200;
    int i=1;
    public Fondo(double x, double y,double vel){
        super(x,y,ObjectId.Fondo);
        super.vel=new Vector(vel,vel);
        //preInit();
        fondo = new ImageIcon("Fondo.gif").getImage();
        initComponents();
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        if(i==1){
             pos.x=pos.x+vel.x;pos.y=pos.y+vel.y;
             if((int)pos.x==-10&&(int)pos.y==-10){i=2;System.out.println(i);}
         }else if (i==2){
             pos.x=pos.x-vel.x;
             if((int)pos.x==-590&&(int)pos.y==-10){i=3;}
         } else if(i==3){
                 pos.y=pos.y-vel.y;
                 pos.x=pos.x+vel.x;
                 if((int)pos.x==-10&&(int)pos.y==-590){i=4;}
             }
         else if(i==4){
             pos.y=pos.y+vel.y;
             if((int)pos.x==-10&&(int)pos.y==-10){i=5;}
         }
         else if(i==5){
             pos.x=pos.x-vel.x;pos.y=pos.y-vel.y;
             if((int)pos.x==-500&&(int)pos.y==-500){i=1;}
         }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(fondo,(int)pos.x,(int)pos.y,(int)dx,(int)dy, null);
        

    }
    public void render(Graphics g) {
        g.drawImage(fondo,(int)pos.x,(int)pos.y,(int)dx,(int)dy, null);
    }

    @Override
    public Rectangle getBounds() {return null;}
    
    private void initComponents() {
    }
     private void preInit() {
         fondo = new ImageIcon("").getImage();
         
    }
}
