/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimientodenave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Andrea
 */
public class Dibujar extends JPanel implements ActionListener{
    
    //instancear
    Nave nave = new Nave();
    Nave espacio = new Nave();
    
    Timer timer = new Timer(3,this);
    
    //constructor
    public Dibujar(){
        //parametros iniciales
        setBackground(Color.WHITE);
        setFocusable(true); //activar JPanel
        addKeyListener(new teclado()); //capturar lo que esta en clase teclado
        timer.start(); //inicializar timer
    }
    
    //metodo para colocar la imagen dentro de un punto de la ventana
    @Override
    public void paint(Graphics grafica){
        
        super.paint(grafica);
        
        Graphics2D mostrar_imagen = (Graphics2D)grafica;
        //Mostrar la imagen dentro del JPanel
        mostrar_imagen.drawImage(nave.tener_Imagen(),nave.tener_X(),nave.tener_Y(),null);
        
    }
    
    //metodo para mover nave y que muestre contenido de paint
    @Override
    public void actionPerformed(ActionEvent e){
        
        nave.mover();
        repaint(); //refrescar paint (ya viene reestablecido cuando colocamos una "grafica"   
        
    }
    
    //metodo para mandar a llamar al meotodo de presionar y soltar teclas
    private class teclado extends KeyAdapter{
        
        //presionar teclas
        @Override
        public void keyPressed(KeyEvent e){
            nave.keyPressed(e);
        }
        //soltar teclas
        @Override
        public void keyReleased(KeyEvent e){
            nave.keyReleased(e);
        }
        
    }
}
