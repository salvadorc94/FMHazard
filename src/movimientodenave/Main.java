/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimientodenave;

/**
 *
 * @author Andrea
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Ventana v1 = new Ventana();
        v1.add(new Dibujar()); //llamar metodo  
        v1.setTitle("GAME"); //titulo de la ventana
        v1.setSize(800,685); //tamaño de la ventana
        v1.setVisible(true); //mostrar la ventana
        v1.setLocationRelativeTo(null); //poner ventana al centro
        v1.setResizable(false); //evitar que el usuario edite el tamaño de la ventana
        
    }
    
}
