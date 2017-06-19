/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimientodenave;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Andrea
 */
public class Nave {
    //atributos
    private String nave;
    private int dx; //Movimiento en x
    private int dy; //Movimiento en y
    private int x; //Posicion del objeto en x
    private int y; //Posicion del objeto en y
    private Image imagen_nave; //mapa de bits en consola
    
    //contructor
    public Nave(){
        
        //posiciones iniciales de la nave
        x = 267;
        y = 443;    
        
        nave = "nave.png";
        
        //Jalar recurso de la imagen
        ImageIcon imagen = new ImageIcon(this.getClass().getResource(nave));
        imagen_nave = imagen.getImage();
        
    }
        //metodo para detectar teclas
        public void keyPressed(KeyEvent e){
            
            //almacenamiento de tecla presionada (codigo)
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_A){
                //reducir movimiento en x
                dx = -1;
            }
            if(key == KeyEvent.VK_D){
                //aumentar movimiento en x
                dx = 1;
            }
            if(key == KeyEvent.VK_W){
                //reducir movimiento en y
                dy = -1;
            }
            if(key == KeyEvent.VK_S){
                //aumentar movimiento en y
                dy = 1;
            }
        }
        
        //metodo para detectar que se solataron teclas
        public void keyReleased(KeyEvent e){
            
            //almacenamiento de tecla presionada (codigo)
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_A){
                dx = 0;
            }
            if(key == KeyEvent.VK_D){
                dx = 0;
            }
            if(key == KeyEvent.VK_W){
                dy = 0;
            }
            if(key == KeyEvent.VK_S){
                dy = 0;
            }
        }
        
        //metodo para mover
        public void mover(){
            x += dx;
            y += dy;    
        }
        
        //funciones para retonar valores
        public int tener_X(){
            return x;
        }
        public int tener_Y(){
            return y;
        }
        public Image tener_Imagen(){
            return imagen_nave;
        }
}
