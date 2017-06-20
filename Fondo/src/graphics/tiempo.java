/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Gerard
 */
public class tiempo  {
    private Timer timer = new Timer();
    panel p = new panel();
   double x=p.getequiz();

class contador extends TimerTask{
    
    @Override
    
    public void run() {
        x=x+1;
    System.out.println(x);
    p.repaint();
       // System.out.println(x);
    }
}
public void contar(){
    
    timer = new Timer();
    timer.schedule(new contador(), 0,100);

}
public double getx(){
    return this.x;
}
    
    
}
