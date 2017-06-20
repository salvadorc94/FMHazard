/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gerard
 */
public class gui extends JFrame{
 panel p;
 int x,y;
 //tiempo t;
   // JLabel jimagen;
    public gui(){
      
        
      this.setBounds(0, 0, 800, 600);
      //this.setSize(800,600);
      this.setLocationRelativeTo(null);
      this.setTitle("LAL");
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      

      //fondo = this.getClass().getResource("w.png");
      Container contenedor = getContentPane();
      p= new panel();
      //t=new tiempo();
      //t.contar();
      
      contenedor.add(p);
    
     // p.update();
    
      this.setVisible(true);
       while(true){
           /*x=p.getequiz();
           y=p.gety();
           x++;
           y++;*/
           repaint();
       }
    }

}
