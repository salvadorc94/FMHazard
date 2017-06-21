/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.window;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author jaiel
 */
public class Window extends JFrame{
    
    public Window(int w, int h, String title, Game game){
        
        game.setPreferredSize(new Dimension(w,h));
        game.setMaximumSize(new Dimension(w,h));
        game.setMinimumSize(new Dimension(w,h));
        
     //   JFrame frame=new JFrame(title);
        this.add(game);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        game.start();
       
    }
    
}
