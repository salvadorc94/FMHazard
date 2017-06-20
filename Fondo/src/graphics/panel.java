/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Gerard
 */
public class panel extends JPanel{
  //  int x = 0,y=0;
    private double x=-500,y=-500,dx=4000,dy=2000;
   // tiempo  t2 = new tiempo();;
   private Image fondo;
    public panel(){
        preInit();
        initComponents();
         
    }

    private void initComponents() {
    }
     private void preInit() {
         fondo = new ImageIcon("gif.gif").getImage();
         
    }
    @Override
     public void paint (Graphics g){
       
      /*   g.setColor(Color.red);
       g.fillRect(x, y, 10, 10);
       x++;y++;*/
         g.drawImage(fondo,(int)x,(int)y,(int)dx,(int)dy, this);
         //g.drawImage(fondo, x, y, this);
         x=x+0.1;y=y+0.1;
         
     }
    public double getequiz(){
         return x;
     }
    public double gety(){
        return y;
    }
    
 
     
     
     
}
